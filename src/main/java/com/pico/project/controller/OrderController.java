package com.pico.project.controller;

import com.pico.project.dto.OrderDto;
import com.pico.project.dto.ProductDto;
import com.pico.project.dto.UserSessionDto;
import com.pico.project.service.OrderService;
import com.pico.project.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final ProductService productService;

    @RequestMapping(value = "/insOrder", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> insOrder(@RequestBody ProductDto productDto, HttpServletRequest request){
        Map<String, Object> resMap = new HashMap<>();

        String prizeNm = orderService.insOrder(productDto, request);
        resMap.put("prizeNm",prizeNm);
        return resMap;
    }

    @RequestMapping(value = "/order_history", method = RequestMethod.GET)
    public ModelAndView order_history(OrderDto orderDto, HttpServletRequest request){
        ModelAndView mv = new ModelAndView("order_history");

        HttpSession session = request.getSession(false);
        UserSessionDto userDto = (UserSessionDto) session.getAttribute("userDto");
        orderDto.setOrderUserNo(userDto.getUserNo());
        int orderCount = orderService.orderCount(orderDto);
        //주문데이터 가지고 오기
        orderDto.setPageNo(1);
        List<OrderDto> orderList = orderService.orderList(orderDto);

        mv.addObject("orderCount", orderCount);
        mv.addObject("orderList", orderList);
        return mv;
    }

    @RequestMapping(value = "/historyList", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> historyList(@RequestBody OrderDto orderDto, HttpServletRequest request){
        Map<String, Object> resMap = new HashMap<>();

        HttpSession session = request.getSession(false);
        UserSessionDto userDto = (UserSessionDto) session.getAttribute("userDto");
        orderDto.setOrderUserNo(userDto.getUserNo());
        //주문데이터 가지고 오기
        List<OrderDto> orderList = orderService.orderList(orderDto);
        int orderCount = orderService.orderCount(orderDto);

        resMap.put("orderCount", orderCount);
        resMap.put("orderList", orderList);
        return resMap;
    }
}
