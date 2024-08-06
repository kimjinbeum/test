package com.pico.project.controller;

import com.pico.project.dto.OrderDto;
import com.pico.project.dto.ProductDto;
import com.pico.project.dto.UserDto;
import com.pico.project.dto.UserSessionDto;
import com.pico.project.service.OrderService;
import com.pico.project.service.ProductService;
import com.pico.project.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final ProductService productService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/fr_main", method = RequestMethod.GET)
    public ModelAndView fr_main(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("fr_main");

        HttpSession session = request.getSession(false);
        UserSessionDto userDto = (UserSessionDto) session.getAttribute("userDto");
        List<ProductDto> productDtoList = productService.productDtoList(userDto);

        mv.addObject("productDtoList", productDtoList);
        mv.addObject("userDto", userDto);
        return mv;
    }

}
