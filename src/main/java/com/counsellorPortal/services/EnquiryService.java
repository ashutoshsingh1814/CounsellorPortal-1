package com.counsellorPortal.services;

import com.counsellorPortal.dto.AddEnquiry;
import com.counsellorPortal.dto.ViewEnqFilterRequest;
import com.counsellorPortal.entity.EnquiryEntity;

import java.util.List;

public interface EnquiryService {

    public boolean addEnquiry(AddEnquiry addEnquiry, Long counsellorId) throws Exception;
    public List<EnquiryEntity> getAllEnquiries(Long counsellorId);
    public List<EnquiryEntity> getEnquriesWithFilter(ViewEnqFilterRequest filterRequest, Long counsellorID);
    public EnquiryEntity getEnquiryById(Long enquiryId);

}
