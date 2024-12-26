package com.counsellorPortal.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class RegisterForm {
    private String name;
    private String email;
    private String password;
    private Long phone;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Long getPhone() {
        return phone;
    }
}
