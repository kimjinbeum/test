package com.pico.project.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private String fromDt;
    private String toDt;

    private String orderNo;
    private String orderDt;
    private String orderUserNo;

    private String productCd;
    private String productNm;
    private int productAmt;
    private String prizeCd;
    private String prizeNm;
    private int age;

    private int pageNo;
    private int pageSize;
    private int offset;
}
