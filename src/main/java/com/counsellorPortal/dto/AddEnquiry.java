package com.counsellorPortal.dto;

import lombok.Data;

@Data
public class AddEnquiry {


    private String studentName;
    private Long studentPhone;
    private String courseName;
    private String classMode;
    private String enquiryStatus;

    public String getStudentName() {
        return studentName;
    }

    public Long getStudentPhone() {
        return studentPhone;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getEnquiryStatus() {
        return enquiryStatus;
    }

    public String getClassMode() {
        return classMode;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentPhone(Long studentPhone) {
        this.studentPhone = studentPhone;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setClassMode(String classMode) {
        this.classMode = classMode;
    }

    public void setEnquiryStatus(String enquiryStatus) {
        this.enquiryStatus = enquiryStatus;
    }
}
