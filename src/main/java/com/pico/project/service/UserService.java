package com.pico.project.service;


import com.pico.project.dto.UserDto;
import com.pico.project.dto.UserSessionDto;
import com.pico.project.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    private HttpSession httpSession;

    public String getUser(UserDto userDto){
        String result = "";
        int userCount = userMapper.getUserCount(userDto);
        if(userCount > 0){
            UserDto user = userMapper.getUser(userDto);
            UserSessionDto sessionDto = new UserSessionDto();
            setUserSession("", user);
            result = "success";
        }else{
            result = "error";
        }

        return result;
    }

    public int userCheck(String userId){
        return userMapper.userCheck(userId);
    }

    public String insUser(UserDto userDto){

        String userNo = userMapper.insUser(userDto);
        //setUserSession(userNo, userDto);
        return "success";
    }

    public void setUserSession(String userNo, UserDto userDto){
        UserSessionDto sessionDto = new UserSessionDto();
        if(userNo.equals("")){
            sessionDto.setUserNo(userDto.getUserNo());
        }else{
            sessionDto.setUserNo(userNo);
        }

        sessionDto.setUserId(userDto.getUserId());
        sessionDto.setUserNm(userDto.getUserNm());
        sessionDto.setUserBirth(userDto.getUserBirth());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate birthDate = LocalDate.parse(userDto.getUserBirth(), formatter);
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(birthDate, currentDate).getYears();
        if (currentDate.getDayOfYear() < birthDate.getDayOfYear()) {
            age--;
        }
        sessionDto.setAge(age);

        httpSession.setAttribute("userDto", sessionDto);
    }

}
