package com.counsellorPortal.serviceImpl;

import com.counsellorPortal.dto.DashBoardResponse;
import com.counsellorPortal.dto.RegisterForm;
import com.counsellorPortal.entity.CounsellorEntity;
import com.counsellorPortal.entity.EnquiryEntity;
import com.counsellorPortal.repositories.CounsellorRepo;
import com.counsellorPortal.repositories.EnquiryRepo;
import com.counsellorPortal.services.CounsellorService;
import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CounsellorServiceImpl implements CounsellorService {


    private final CounsellorRepo counsellorRepo;

    private final EnquiryRepo enquiryRepo;
    public CounsellorServiceImpl(CounsellorRepo counsellorRepo,EnquiryRepo enquiryRepo) {
        this.counsellorRepo = counsellorRepo;
        this.enquiryRepo = enquiryRepo;
    }

    @Override
    public boolean register(RegisterForm registerForm) {
        if (counsellorRepo.findByEmail(registerForm.getEmail()).isPresent()) {
            return false;
        }

        CounsellorEntity entity = new CounsellorEntity();
        BeanUtils.copyProperties(registerForm, entity);
        return counsellorRepo.save(entity).getCounsellorId() != null;
    }

    @Override
    public CounsellorEntity login(String email, String password) {
        Optional<CounsellorEntity> exist = counsellorRepo.findByEmailAndPassword(email, password);
        if (exist.isPresent()) {
            return exist.get();
        } else {
            // Handle case where no matching entity is found
            throw new RuntimeException("Invalid email or password");
        }
    }
    @Override
    public DashBoardResponse getDashBoardInfo(Long counsellorId) {

        DashBoardResponse response = new DashBoardResponse();
        List<EnquiryEntity> enqList = enquiryRepo.getEnquiriesByCounselorId(counsellorId);
        int totalEnq=enqList.size();
        int enrolledEnq =(int) enqList.stream()
                .filter(e->e.getEnquiryStatus().equals("Enrolled"))
                .count();
        int lostEnq = (int)enqList.stream()
                .filter(e->e.getEnquiryStatus().equals("Lost"))
                .count();
        int openEnq=(int) enqList.stream()
                .filter(e->e.getEnquiryStatus().equals("Open"))
                .count();


           response.setTotalEnq(totalEnq);
           response.setEnrolledEnq(enrolledEnq);
           response.setLostEnq(lostEnq);
           response.setOpenEnq(openEnq);
            return response;
    }
}

