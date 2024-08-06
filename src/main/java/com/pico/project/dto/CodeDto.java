package com.pico.project.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CodeDto {
    private String codeId;
    private String codeNm;
    private String parentCodeId;
}
