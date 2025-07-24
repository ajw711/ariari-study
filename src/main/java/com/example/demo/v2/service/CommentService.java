package com.example.demo.v2.service;

import com.example.demo.v2.domain.Comment;
import com.example.demo.v2.domain.Post;
import com.example.demo.v2.dto.comment.CommentRequestDto;
import com.example.demo.v2.dto.comment.CommentResponseDto;
import com.example.demo.v2.repository.CommentRepository;
import com.example.demo.v2.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentService {


    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public List<CommentResponseDto> getComments(Long postId) {
        log.info("→ [Service] getComments 호출됨");
        List<CommentResponseDto> commentResponseDtoList = new ArrayList<>();
        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("해당 게시글 없음"));
        List<Comment> comments = commentRepository.findAllByPost(post);
        for(Comment comment : comments){
            CommentResponseDto commentResponseDto = new CommentResponseDto();
            commentResponseDto.setCommentId(comment.getId());
            commentResponseDto.setContent(comment.getContent());

            commentResponseDtoList.add(commentResponseDto);
        }
        log.info("← [Service] getComments 종료");
        return commentResponseDtoList;
    }


    public void createComment(CommentRequestDto postCreateDto) {
        log.info("→ [Service] createComment 호출됨");
        Post post = postRepository.findById(postCreateDto.getPostId()).orElseThrow(() -> new IllegalArgumentException("해당 게시글 없음"));
        Comment comment = new Comment();
        comment.setContent(postCreateDto.getContent());
        comment.setPost(post);
        commentRepository.save(comment);
        log.info("← [Service] createComment 종료");
    }

    public void modifyComment(Long commentId, CommentResponseDto commentResponseDto) {
        log.info("→ [Service] modifyComment 호출됨");
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new IllegalArgumentException("해당 댓글 없음"));
        comment.setContent(commentResponseDto.getContent());
        commentRepository.save(comment);
        log.info("← [Service] modifyComment 종료");
    }

    public void deleteComment(Long id) {
        log.info("→ [Service] deleteComment 호출됨");
        commentRepository.deleteById(id);
        log.info("← [Service] deleteComment 종료");
    }
}


