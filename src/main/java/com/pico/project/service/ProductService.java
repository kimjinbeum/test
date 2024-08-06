package com.pico.project.service;


import com.pico.project.dto.CodeDto;
import com.pico.project.dto.ProductDto;
import com.pico.project.dto.UserSessionDto;
import com.pico.project.mapper.CodeMapper;
import com.pico.project.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    ProductMapper productMapper;

    public List<ProductDto> productDtoList(UserSessionDto userSessionDto){
        return productMapper.productDtoList(userSessionDto);
    }

}
