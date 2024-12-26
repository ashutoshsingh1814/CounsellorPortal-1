package com.counsellorPortal.repositories;

import com.counsellorPortal.entity.EnquiryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnquiryRepo extends JpaRepository<EnquiryEntity, Long> {
    @Query(value="select * from enquiry_tbl where counsellor_id=:counsellorId",nativeQuery = true)
    List<EnquiryEntity> getEnquiriesByCounselorId(Long counsellorId);

}
