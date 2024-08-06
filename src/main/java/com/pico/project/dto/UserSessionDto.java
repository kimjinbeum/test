package com.pico.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserSessionDto {
    private String userNo;
    private String userId;
    private String userNm;
    private String userBirth;
    private int age;
}
