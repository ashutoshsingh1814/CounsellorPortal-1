package com.counsellorPortal.dto;

import lombok.Data;

@Data
public class ViewEnqFilterRequest {

    private String courseName;
    private String classMode;
    private String enquiryStatus;

    public String getCourseName() {
        return courseName;
    }

    public String getClassMode() {
        return classMode;
    }

    public String getEnquiryStatus() {
        return enquiryStatus;
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
