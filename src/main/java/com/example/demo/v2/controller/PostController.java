package com.example.demo.v2.controller;


import com.example.demo.v2.dto.post.PostRequestDto;
import com.example.demo.v2.dto.post.PostResponseDto;
import com.example.demo.v2.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/api/post")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "게시글 API", description = "게시글 등록, 조회, 수정, 삭제 API 입니다.")
public class PostController {

    private final PostService postService;

    @Operation(summary = "게시글 조회", description = "")
    @GetMapping
    public List<PostResponseDto> getPosts() {
        log.info("→ [Controller] getPosts 호출됨");
        List<PostResponseDto> list = postService.getPosts();
        log.info("→ [Controller] getPosts 종료");
        return list;
    }

    @Operation(summary = "게시글 등록", description = "")
    @PostMapping("/create")
    public String createPost(@RequestBody PostRequestDto postCreateDto) {
        log.info("→ [Controller] createPost 호출됨");
        postService.createPost(postCreateDto);
        log.info("→ [Controller] createPost 종료");
        return "게시글 등록 성공";
    }

    @Operation(summary = "게시글 수정", description = "")
    @PutMapping("/modify/{id}")
    public String modifyPost(@PathVariable Long id, @RequestBody PostRequestDto postCreateDto) {
        log.info("→ [Controller] modifyPost 호출됨");
        postService.modifyPost(id, postCreateDto);
        log.info("→ [Controller] modifyPost 종료");
        return "게시글 수정 성공";
    }

    @Operation(summary = "게시글 삭제", description = "")
    @DeleteMapping("/delete/{id}")
    public String deletePost(@PathVariable Long id) {
        log.info("→ [Controller] deletePost 호출됨");
        postService.deletePost(id);
        log.info("→ [Controller] deletePost 종료");
        return "게시글 삭제 성공";
    }
}
