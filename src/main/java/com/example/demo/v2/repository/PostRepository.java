package com.example.demo.v2.repository;

import com.example.demo.v2.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
