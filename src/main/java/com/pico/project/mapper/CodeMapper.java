package com.pico.project.mapper;

import com.pico.project.dto.CodeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CodeMapper {
    List<CodeDto> getCodeList(String codeId);
}
