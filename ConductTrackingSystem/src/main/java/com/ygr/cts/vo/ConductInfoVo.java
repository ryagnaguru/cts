package com.ygr.cts.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yagnaguru.r
 */
public class ConductInfoVo implements Serializable {

    private Long conductInfoId;
    private Long studentId;
    private String facultyName;
    private Integer semester;
    private String charge;
    private String resolution;
    private Date createdOn;
    private String createdBy;
    private int deleted;

    public Long getConductInfoId() {
        return conductInfoId;
    }

    public void setConductInfoId(Long conductInfoId) {
        this.conductInfoId = conductInfoId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
}
