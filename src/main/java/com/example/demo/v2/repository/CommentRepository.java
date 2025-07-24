package com.example.demo.v2.repository;

import com.example.demo.v2.domain.Comment;
import com.example.demo.v2.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByPost(Post post);
}
