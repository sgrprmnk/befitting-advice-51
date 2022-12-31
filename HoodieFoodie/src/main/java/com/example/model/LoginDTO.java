package com.example.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginDTO {

    private String mobileNumber;
    private String password;

//    public LoginDTO() {
//    }
//
//    public LoginDTO(String mobileNumber, String password) {
//        this.mobileNumber = mobileNumber;
//        this.password = password;
//    }
//
//    public String getMobileNumber() {
//        return mobileNumber;
//    }
//
//    public void setMobileNumber(String mobileNumber) {
//        this.mobileNumber = mobileNumber;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    @Override
//    public String toString() {
//        return "LoginDTO{" +
//                "mobileNumber='" + mobileNumber + '\'' +
//                ", password='" + password + '\'' +
//                '}';
//    }
}
