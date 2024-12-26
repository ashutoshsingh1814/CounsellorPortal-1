package com.counsellorPortal.dto;

import lombok.Data;

@Data
public class DashBoardResponse {
    private Integer totalEnq;
    private Integer openEnq;
    private Integer enrolledEnq;
    private Integer lostEnq;

    public Integer getOpenEnq() {
        return openEnq;
    }

    public Integer getTotalEnq() {
        return totalEnq;
    }

    public Integer getEnrolledEnq() {
        return enrolledEnq;
    }

    public Integer getLostEnq() {
        return lostEnq;
    }

    public void setOpenEnq(Integer openEnq) {
        this.openEnq = openEnq;
    }

    public void setTotalEnq(Integer totalEnq) {
        this.totalEnq = totalEnq;
    }

    public void setEnrolledEnq(Integer enrolledEnq) {
        this.enrolledEnq = enrolledEnq;
    }

    public void setLostEnq(Integer lostEnq) {
        this.lostEnq = lostEnq;
    }
}
