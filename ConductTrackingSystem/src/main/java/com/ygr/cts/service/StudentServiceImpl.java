package com.ygr.cts.service;

import com.ygr.cts.domain.ConductInfo;
import com.ygr.cts.domain.Student;
import com.ygr.cts.vo.ConductInfoVo;
import com.ygr.cts.vo.StudentVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yagnaguru.r
 */

@Service
public class StudentServiceImpl {

    @Autowired
    StudentRepository studentRepository;

    /**
     * get student info for a student id
     *
     * @param studentId
     * @return
     */
    public StudentVo getStudentInfo(Long studentId) {
        try {
            Student student = studentRepository.findByStudentId(studentId);
            if (!Objects.isNull(student)) {
                StudentVo studentVo = new StudentVo();
                BeanUtils.copyProperties(student, studentVo);
                List<ConductInfoVo> conductInfoVoList = student.getConductInfos().stream().map(cI -> {
                    ConductInfoVo conductInfoVo = new ConductInfoVo();
                    BeanUtils.copyProperties(cI, conductInfoVo);
                    return conductInfoVo;
                }).collect(Collectors.toList());
                studentVo.setConductInfos(conductInfoVoList);
                return studentVo;
            }
        } catch (BeansException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void createData(Map<String, String> info) {
        try {
            if (!Objects.isNull(info)) {
                Student student = new Student();
                student.setAddress(info.get("address"));
                student.setCreatedOn(new Date());
                student.setDepartment(info.get("department"));
                student.setDeleted(0);
                student.setFirstName(info.get("firstName"));
                student.setGuardianName(info.get("guardian"));
                student.setPhoneNumber(info.get("phoneNumber"));
                student.setStudentId(Long.valueOf(info.get("studentId")));
                ConductInfo conductInfo = new ConductInfo();
                conductInfo.setCharge(info.get("charge"));
                conductInfo.setResolution(info.get("resolution"));
                conductInfo.setRemarks(info.get("remarks"));
                if( info.get("conductId") != null ){
                    conductInfo.setConductInfoId(Long.valueOf(info.get("conductId")));
                }
                student.setConductInfos(Arrays.asList(conductInfo));
                studentRepository.save(student);
            }
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }
}
