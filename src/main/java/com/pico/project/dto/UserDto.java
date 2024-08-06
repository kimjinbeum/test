package com.pico.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String userNo;
    private String userId;
    private String userNm;
    private String userPwd;
    private String userGender;
    private String userEmail;
    private String userBirth;
    private String userAge;
    private String userPhone;
    private String adReceiveYn;

    public void setUserPwd(String userPwd) {
        this.userPwd = encodeMD5(userPwd);
    }

    private String encodeMD5(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found", e);
        }
    }
}
