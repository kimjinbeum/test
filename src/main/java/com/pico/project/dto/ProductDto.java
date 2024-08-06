package com.pico.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto extends StockDto{
    private String productCd;
    private String productNm;
    private int productAmt;
    private String purchaseAge;
    private int age;
    private List<ProductDto> productList;
}
