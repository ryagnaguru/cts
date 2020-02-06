package com.ygr.cts.service;

import com.ygr.cts.domain.ConductInfo;
import com.ygr.cts.domain.Student;
import com.ygr.cts.vo.ConductInfoVo;
import com.ygr.cts.vo.StudentVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author yagnaguru.r
 */

@Service
public class ConductInfoServiceImpl {

    @Autowired
    ConductInfoRepository conductInfoRepository;

    @Autowired
    StudentRepository studentRepository;

    /**
     * get Conduct info for a conductInfoId
     *
     * @param conductInfoId
     * @return
     */
    public Map<String, Object> getConductInfoById(Long conductInfoId) {
        try {
            ConductInfo conductInfo = conductInfoRepository.findByConductInfoId(conductInfoId);
            Map<String, Object> stringObjectMap = new HashMap<>();
            if (!Objects.isNull(conductInfo)) {
                Student student = studentRepository.findByStudentId(conductInfo.getStudentId());
                StudentVo studentVo = new StudentVo();
                ConductInfoVo conductInfoVo = new ConductInfoVo();
                BeanUtils.copyProperties(conductInfo, conductInfoVo);
                BeanUtils.copyProperties(student, studentVo);
                studentVo.setConductInfos(Collections.emptyList());
                stringObjectMap.put("conduct", conductInfo);
                stringObjectMap.put("student", studentVo);
                return stringObjectMap;
            }
        } catch (BeansException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteConductInfoById(Long conductInfoId) {
        try {
            conductInfoRepository.deleteByConductInfoId(conductInfoId);
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }
}
