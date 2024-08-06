package com.pico.project.service;

import com.pico.project.dto.OrderDto;
import com.pico.project.dto.PrizeDto;
import com.pico.project.dto.ProductDto;
import com.pico.project.dto.UserSessionDto;
import com.pico.project.mapper.OrderMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    @Autowired
    OrderMapper orderMapper;

    public String insOrder(ProductDto productDto, HttpServletRequest request){
        HttpSession session = request.getSession(false);
        UserSessionDto userDto = (UserSessionDto) session.getAttribute("userDto");

        //1.주문테이블 적용
        String orderNo = orderMapper.insOrder(userDto.getUserNo());

        //3.주문금액에 맞는 경품이 있는지 가지고 오기
        int sumAmt = 0;
        for(int i=0; i < productDto.getProductList().size(); i++){
            sumAmt = sumAmt + productDto.getProductList().get(i).getProductAmt();
        }


        PrizeDto searchPrizeDto = new PrizeDto();
        searchPrizeDto.setPrizeAmt(sumAmt);
        searchPrizeDto.setAge(userDto.getAge());
        PrizeDto prizeDto = orderMapper.getPrize(searchPrizeDto);
        String prizeNm = "";
        String prizeCd = "";
        if(prizeDto != null){
            prizeNm = prizeDto.getPrizeNm();
            prizeCd = prizeDto.getPrizeCd();
        }
        //2.주문상세 등록
        OrderDto orderDto = new OrderDto();
        for(int i=0; i < productDto.getProductList().size(); i++){
            orderDto.setOrderNo(orderNo);
            orderDto.setProductCd(productDto.getProductList().get(i).getProductCd());
            orderDto.setProductAmt(productDto.getProductList().get(i).getProductAmt());
            orderDto.setPrizeCd(prizeCd);
            orderMapper.insOrderDetail(orderDto);

            //3재고 update
            orderMapper.updateStock(orderDto);

            //출고테이블 저장
            orderMapper.insProductOut(orderDto);
        }



        return prizeNm;
    }

    public List<OrderDto> orderList(OrderDto orderDto){

        int offset = (orderDto.getPageNo() - 1) * 15;
        orderDto.setPageSize(15);
        orderDto.setOffset(offset);

        return orderMapper.orderList(orderDto);
    }

    public int orderCount(OrderDto orderDto){
        return orderMapper.orderCount(orderDto);
    }

}
