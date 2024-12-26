package com.counsellorPortal.controller;

import com.counsellorPortal.dto.DashBoardResponse;
import com.counsellorPortal.dto.RegisterForm;
import com.counsellorPortal.entity.CounsellorEntity;
import com.counsellorPortal.services.CounsellorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/counsellor")
public class CounsellorController {

    @Autowired
    private CounsellorService counsellorService;
    @PostMapping("/register")
    public ResponseEntity<String> registerCounsellor(@RequestBody RegisterForm registerForm){
        boolean register = counsellorService.register(registerForm);
        if(register){
            return ResponseEntity.status(HttpStatus.CREATED).body("Your Registration is Success");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Your Email Already Exist");
        }

    }
    @PostMapping("/login")
    public ResponseEntity<?> loginCounsellor(@RequestParam String email, @RequestParam String password){
        try{
            CounsellorEntity status = counsellorService.login(email, password);
            return ResponseEntity.ok(status);

        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());

        }

    }

    @GetMapping("/dashboard/{counsellorId}")
    public ResponseEntity<?> getDashboard(@PathVariable Long counsellorId){
        try{
            DashBoardResponse enqList = counsellorService.getDashBoardInfo(counsellorId);
            return ResponseEntity.ok(enqList);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

        }


    }



}
