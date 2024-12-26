package com.counsellorPortal.serviceImpl;

import com.counsellorPortal.dto.AddEnquiry;
import com.counsellorPortal.dto.ViewEnqFilterRequest;
import com.counsellorPortal.entity.CounsellorEntity;
import com.counsellorPortal.entity.EnquiryEntity;
import com.counsellorPortal.repositories.CounsellorRepo;
import com.counsellorPortal.repositories.EnquiryRepo;
import com.counsellorPortal.services.EnquiryService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EnquiryServiceImpl implements EnquiryService {
    @Autowired
    private EnquiryRepo enquiryRepo;
    @Autowired
    private CounsellorRepo counselorRepo;

    @Override
    public boolean addEnquiry(AddEnquiry addEnquiry,Long counsellorId) throws Exception {
        CounsellorEntity counsellor = counselorRepo.findById(counsellorId)
                .orElseThrow(() -> new Exception("No Counsellor Found"));

        EnquiryEntity entity = new EnquiryEntity();
        BeanUtils.copyProperties(addEnquiry, entity);
        entity.setCreatedBy(counsellor);
        enquiryRepo.save(entity);
        return true;
    }

    @Override
    public List<EnquiryEntity> getAllEnquiries(Long counsellorId) {
        return enquiryRepo.getEnquiriesByCounselorId(counsellorId);
    }

    @Override
    public List<EnquiryEntity> getEnquriesWithFilter(ViewEnqFilterRequest filterRequest, Long counsellorId) {
        // QBE implementation (Dynamic Query Implementation)
        EnquiryEntity entity = new EnquiryEntity();

       if(StringUtils.isNotEmpty(filterRequest.getClassMode())){
            entity.setClassMode(filterRequest.getClassMode());
        }
       if(StringUtils.isNotEmpty(filterRequest.getCourseName())){
           entity.setCourseName(filterRequest.getCourseName());
       }
       if(StringUtils.isNotEmpty(filterRequest.getEnquiryStatus())){
           entity.setEnquiryStatus(filterRequest.getEnquiryStatus());
       }

        CounsellorEntity c = counselorRepo.findById(counsellorId).orElse(null);
        entity.setCreatedBy(c);
       Example<EnquiryEntity> of = Example.of(entity);
        List<EnquiryEntity> enqList = enquiryRepo.findAll(of);
        return enqList;
    }

    @Override
    public EnquiryEntity getEnquiryById(Long enquiryId) {
        Optional<EnquiryEntity> byId = enquiryRepo.findById(enquiryId);
        if(byId.isPresent()){
            return byId.get();
        }
        else {
            throw new RuntimeException("Invalid Id ");
        }
    }
}
