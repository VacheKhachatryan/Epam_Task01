package com.epam.backendtask01.controller;

import com.epam.backendtask01.dto.TransformationRequestDto;
import com.epam.backendtask01.dto.TransformationResponseDto;
import com.epam.backendtask01.validator.TransformationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1")
public class TransformationController {
    private final TransformationService transformationService;

    public TransformationController(TransformationService transformationService) {
        this.transformationService = transformationService;
    }

    @PostMapping("/transformation")
    public ResponseEntity<?> transformJson(@Valid @RequestBody TransformationRequestDto requestDto) {
        TransformationResponseDto transformationResponseDto = transformationService.transform(requestDto);
        return new ResponseEntity<>(transformationResponseDto, HttpStatus.OK);
    }
}