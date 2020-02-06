package com.ygr.cts.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @author yagnaguru.r
 */
public class StudentVo implements Serializable {

    private Long studentId;
    private String firstName;
    private String lastName;
    private String guardianName;
    private String phoneNumber;
    private String address;
    private String department;
    private List<ConductInfoVo> conductInfos;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<ConductInfoVo> getConductInfos() {
        return conductInfos;
    }

    public void setConductInfos(List<ConductInfoVo> conductInfos) {
        this.conductInfos = conductInfos;
    }
}
