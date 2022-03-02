package com.epam.backendtask01.validator;

import com.epam.backendtask01.dto.TransformationRequestDto;
import com.epam.backendtask01.dto.TransformationResponseDto;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Component
public class TransformationService {
    private static final Pattern pattern = Pattern.compile("_[a-z]");
    private static final String SPACE = "_";

    public TransformationResponseDto transform(TransformationRequestDto requestDto) {
        Set<String> items = requestDto.getItems().stream().map(this::snakeToCamel
        ).collect(Collectors.toSet());
        return new TransformationResponseDto(requestDto.getName(),
                items, System.currentTimeMillis());
    }

    private String snakeToCamel(String item) {
        item = item.substring(0, 1).toUpperCase()
                + item.substring(1);
        while (item.contains(SPACE)) {
            item = item
                    .replaceFirst(
                            pattern.pattern(),
                            String.valueOf(
                                    Character.toUpperCase(
                                            item.charAt(
                                                    item.indexOf(SPACE) + 1))));
        }
        return item;
    }
}
