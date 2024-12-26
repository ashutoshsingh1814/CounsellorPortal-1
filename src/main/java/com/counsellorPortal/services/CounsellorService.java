package com.counsellorPortal.services;


import com.counsellorPortal.dto.DashBoardResponse;
import com.counsellorPortal.dto.RegisterForm;
import com.counsellorPortal.entity.CounsellorEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface CounsellorService {

    public boolean register(@RequestBody RegisterForm registerForm);
    public CounsellorEntity login(String email, String password);
    public DashBoardResponse getDashBoardInfo(Long counsellorId);



}
