package com.pico.project.mapper;

import com.pico.project.dto.CodeDto;
import com.pico.project.dto.OrderDto;
import com.pico.project.dto.PrizeDto;
import com.pico.project.dto.ProductDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    String insOrder(String userNo);
    PrizeDto getPrize(PrizeDto prizeDto);
    void insOrderDetail(OrderDto orderDto);
    void updateStock(OrderDto orderDto);
    void insProductOut(OrderDto orderDto);
    List<OrderDto> orderList(OrderDto orderDto);
    int orderCount(OrderDto orderDto);
}
