package com.ygr.cts.controller;

import com.ygr.cts.service.StudentServiceImpl;
import com.ygr.cts.vo.StudentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author yagnaguru.r
 */

@RequestMapping("/student")
@RestController
public class StudentController {

    @Autowired
    StudentServiceImpl studentService;

    @GetMapping("/details/{id}")
    public StudentVo getStudentsForList(@PathVariable Long id) {
        return studentService.getStudentInfo(id);
    }

    @PostMapping("/create/data")
    public void createData(@RequestBody Map<String, String> data) {
        studentService.createData(data);
    }
}
