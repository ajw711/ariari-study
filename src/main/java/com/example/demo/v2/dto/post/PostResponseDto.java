package com.example.demo.v2.dto.post;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostResponseDto {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String title;

    private String content;
}
