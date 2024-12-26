package com.counsellorPortal.repositories;

import com.counsellorPortal.entity.CounsellorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CounsellorRepo extends JpaRepository<CounsellorEntity,Long> {
   // select * from counsellor_tbl where email=:email
   Optional<CounsellorEntity> findByEmail(String email);

   // select * from counsellor_tbl where email=:email and password=:password
   Optional<CounsellorEntity> findByEmailAndPassword(String email, String password);
}
