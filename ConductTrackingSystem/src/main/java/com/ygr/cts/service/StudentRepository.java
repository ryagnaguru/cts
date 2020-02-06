package com.ygr.cts.service;

import com.ygr.cts.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author yagnaguru.r
 */

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    Student findByStudentId(Long studentId);
}