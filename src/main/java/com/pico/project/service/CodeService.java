package com.pico.project.service;


import com.pico.project.dto.CodeDto;
import com.pico.project.mapper.CodeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CodeService {

    @Autowired
    CodeMapper codeMapper;

    public List<CodeDto> getCodeList(String codeId){
        return codeMapper.getCodeList(codeId);
    }
}
