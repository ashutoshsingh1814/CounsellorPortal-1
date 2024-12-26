package com.counsellorPortal.controller;

import com.counsellorPortal.dto.AddEnquiry;
import com.counsellorPortal.dto.ViewEnqFilterRequest;
import com.counsellorPortal.entity.EnquiryEntity;
import com.counsellorPortal.repositories.EnquiryRepo;
import com.counsellorPortal.services.EnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enquiry")
public class EnquiryController {
     @Autowired
     private EnquiryService enquiryService;


     @PostMapping("/addEnquiry/{counsellorId}")
     public ResponseEntity<?> addEnquiry(@RequestBody AddEnquiry addEnquiry, @PathVariable Long counsellorId) throws Exception {
         try {
             boolean enq = enquiryService.addEnquiry(addEnquiry, counsellorId);
             if(enq){
                 return ResponseEntity.status(HttpStatus.CREATED).body("Enquiry added");

             }else{
                 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong");

             }

         }catch (Exception e){
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

         }

     }

     @GetMapping("getEnquiries")
     public ResponseEntity<?> getAllEnquiries(@PathVariable Long counsellorId){
         try{
             List<EnquiryEntity> enqList = enquiryService.getAllEnquiries(counsellorId);
             if(enqList.isEmpty()){
                 return ResponseEntity.status(HttpStatus.NO_CONTENT).body(enqList);
             }
                 return ResponseEntity.status(HttpStatus.FOUND).body(enqList);


         }catch (Exception e){
             ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

         }


         return null;
     }



     @GetMapping("filter")
     public ResponseEntity<List<EnquiryEntity >> getEnquiriesWithFilter(@RequestBody ViewEnqFilterRequest viewEnqFilterRequest,
     @RequestParam Long counsellorId){
         try{
             List<EnquiryEntity> enqList= enquiryService.getEnquriesWithFilter(viewEnqFilterRequest,counsellorId);
             return ResponseEntity.ok(enqList);
         }catch (Exception e){
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
         }

     }


}
