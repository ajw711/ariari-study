package com.example.demo.v2.controller;

import com.example.demo.v2.dto.comment.CommentRequestDto;
import com.example.demo.v2.dto.comment.CommentResponseDto;
import com.example.demo.v2.service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/api/comment")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "댓글 API", description = "댓글 등록, 조회, 수정, 삭제 API 입니다.")
public class CommentController {

    private final CommentService commentService;

    @Operation(summary = "해당 게시글에 댓글 조회", description = "")
    @GetMapping("/{postId}")
    public List<CommentResponseDto> getComments(@PathVariable Long postId) {
        log.info("→ [Controller] getComments 호출됨");
        List<CommentResponseDto> list = commentService.getComments(postId);
        log.info("→ [Controller] getComments 종료");
        return list;
    }

    @Operation(summary = "해당 게시글에 댓글 등록", description = "")
    @PostMapping("/create")
    public String createComment(@RequestBody CommentRequestDto commentRequestDto){
        log.info("→ [Controller] createComment 호출됨");
        commentService.createComment(commentRequestDto);
        log.info("→ [Controller] createComment 종료");
        return "댓글 생성 성공";
    }

    @Operation(summary = "해당 게시글에 댓글 수정", description = "")
    @PutMapping("/modify/{id}")
    public String modifyComment(@PathVariable Long id, @RequestBody CommentResponseDto commentResponseDto) {
        log.info("→ [Controller] modifyComment 호출됨");
        commentService.modifyComment(id, commentResponseDto);
        log.info("→ [Controller] modifyComment 종료");
        return "댓글 수정 성공";
    }

    @Operation(summary = "해당 게시글에 댓글 삭제", description = "")
    @DeleteMapping("/delete/{id}")
    public String deleteComment(@PathVariable Long id) {
        log.info("→ [Controller] deleteComment 호출됨");
        commentService.deleteComment(id);
        log.info("→ [Controller] deleteComment 종료");
        return "댓글 삭제 성공";
    }
}
