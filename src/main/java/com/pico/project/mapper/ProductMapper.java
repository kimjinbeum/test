package com.pico.project.mapper;

import com.pico.project.dto.CodeDto;
import com.pico.project.dto.ProductDto;
import com.pico.project.dto.UserSessionDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<ProductDto> productDtoList(UserSessionDto userSessionDto);
}
