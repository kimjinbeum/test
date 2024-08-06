package com.pico.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrizeDto {
    private String prizeCd;
    private String prizeNm;
    private int prizeAmt;
    private int age;
}
