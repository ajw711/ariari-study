package com.example.demo.v2.dto.comment;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;

@Getter
public class CommentRequestDto {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long postId;

    private String content;
}
