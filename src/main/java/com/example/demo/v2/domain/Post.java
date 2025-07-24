package com.example.demo.v2.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity // 이 클래스는 DB 테이블
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {


    @Id // 이 필드가 테이블의 기본 키
    @GeneratedValue // DB에서 자동으로 글 번호를 만들어줘요
    private Long id;

    private String title;

    private String content;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    /*
    // 이런 식으로 'create'라는 특별한 방법(메서드)으로만 글을 만들면 좋아요.
    // new Post() 하고 set()으로 값을 넣는 건 실수할 수도 있고 필요한 값이 빠질 수도 있어요.
    // 그래서 이런 식으로 아예 title, content를 필수로 받게 만들어두면 실수를 줄일 수 있어요.

    private Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public static Post create(String title, String content) {
        return new Post(title, content);
    }
    */

}
