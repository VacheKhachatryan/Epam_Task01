package com.epam.backendtask01.dto;

import com.epam.backendtask01.validator.IsLetter;
import lombok.Data;

import java.util.Set;

@Data
public class TransformationRequestDto {
    private String name;
    @IsLetter
    private Set<String> items;
}