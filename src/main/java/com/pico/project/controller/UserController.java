package com.pico.project.controller;

import com.pico.project.dto.CodeDto;
import com.pico.project.dto.UserDto;
import com.pico.project.service.CodeService;
import com.pico.project.service.UserService;
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
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final CodeService codeService;

    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> userLogin(@RequestBody UserDto userDto){
        Map<String, Object> resMap = new HashMap<>();

        //아이디 비밀번호 체크
        String result = userService.getUser(userDto);

        resMap.put("result", result);
        return resMap;
    }


    @RequestMapping(value = "/userJoin", method = RequestMethod.GET)
    public ModelAndView userJoin(){
        ModelAndView mv = new ModelAndView("fr_sign_in_form");

        //공통코드 가지고 오기
        //1.성별
        List<CodeDto> genderList = codeService.getCodeList("GENDER");
        //2.핸드폰앞번호
        List<CodeDto> phoneList = codeService.getCodeList("PHONE");
        //3.동의 구분
        List<CodeDto> agreeList = codeService.getCodeList("AGREE");
        //4.이메일 구분
        List<CodeDto> emailList = codeService.getCodeList("EMAIL");

        mv.addObject("genderList", genderList);
        mv.addObject("phoneList", phoneList);
        mv.addObject("agreeList", agreeList);
        mv.addObject("emailList", emailList);
        return mv;
    }

    @RequestMapping(value = "/userCheck", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> userCheck(@RequestBody UserDto userDto){
        Map<String, Object> resMap = new HashMap<>();

        int userCnt = userService.userCheck(userDto.getUserId());

        resMap.put("userCnt", userCnt);
         return resMap;
    }

    @RequestMapping(value = "/userJoin", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> userJoin(@RequestBody UserDto userDto){
        Map<String, Object> resMap = new HashMap<>();

        String result = userService.insUser(userDto);

        resMap.put("result", "success");
        return resMap;
    }
}
