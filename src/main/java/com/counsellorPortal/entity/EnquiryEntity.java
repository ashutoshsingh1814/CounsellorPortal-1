package com.counsellorPortal.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Data

@Table(name = "enquiry_tbl")
public class EnquiryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enquiryId;
    private String studentName;
    private Long studentPhone;
    private String courseName;
    private String classMode;
    private String enquiryStatus;
    @CreationTimestamp
    private LocalDate createdDate;
    @UpdateTimestamp
     private LocalDate updatedDate;
    @ManyToOne
    @JoinColumn(name = "counsellorId")
    private CounsellorEntity createdBy;

    public Long getEnquiryId() {
        return enquiryId;
    }

    public String getStudentName() {
        return studentName;
    }

    public Long getStudentPhone() {
        return studentPhone;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getClassMode() {
        return classMode;
    }

    public String getEnquiryStatus() {
        return enquiryStatus;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public LocalDate getUpdatedDate() {
        return updatedDate;
    }

    public CounsellorEntity getCreatedBy() {
        return createdBy;
    }

    public void setEnquiryId(Long enquiryId) {
        this.enquiryId = enquiryId;
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

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public void setUpdatedDate(LocalDate updatedDate) {
        this.updatedDate = updatedDate;
    }

    public void setCreatedBy(CounsellorEntity createdBy) {
        this.createdBy = createdBy;
    }
}
