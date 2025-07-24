package com.example.demo.v2.dto.comment;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentResponseDto {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long commentId;

    private String content;
}
