package com.example.demo.v2.service;

import com.example.demo.v2.domain.Post;
import com.example.demo.v2.dto.post.PostRequestDto;
import com.example.demo.v2.dto.post.PostResponseDto;
import com.example.demo.v2.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;


    @Transactional(readOnly = true)
    public List<PostResponseDto> getPosts() {
        log.info("→ [Service] getPosts 호출됨");
        List<PostResponseDto>  postResponseDtoList = new ArrayList<>();
        List<Post> posts = postRepository.findAll(); // DB에서 모든 게시글 조회 (SELECT * FROM post)
        for (Post post : posts) {
            PostResponseDto postResponseDto = new PostResponseDto();
            postResponseDto.setId(post.getId());  // DB에서 가져온 id 값(식별자) 즉 주민등록번호
            postResponseDto.setContent(post.getContent());
            postResponseDto.setTitle(post.getTitle());
            postResponseDtoList.add(postResponseDto);
        }
        log.info("← [Service] getPosts 종료");
        return postResponseDtoList;
    }


    /**
     * new Post() 하고 setTitle, setContent 쓰는 방식은
     * 나중에 문제가 생길 수 있어서 좋은 방법은 아니에요.
     * 나중에 'Post.create()' 같은 방법을 쓰는 게 더 좋아요.
     */
    @Transactional
    public void createPost(PostRequestDto postCreateDto) {
        log.info("→ [Service] createPost 호출됨");
        Post post = new Post();
        post.setTitle(postCreateDto.getTitle());
        post.setContent(postCreateDto.getContent());
       //Post post = Post.create(postCreateDto.getTitle(), postCreateDto.getContent()); 팩토리 메서드 사용시 사용
        postRepository.save(post); // DB에 글 정보를 저장해요
        log.info("← [Service] createPost 종료");
    }

    @Transactional
    public void modifyPost(Long id, PostRequestDto postCreateDto) {
        log.info("→ [Service] modifyPost 호출됨");
        // DB에서 해당 id의 게시글 조회 없으면 예외 발생
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글 없음"));
        post.setTitle(postCreateDto.getTitle());
        post.setContent(postCreateDto.getContent());
        postRepository.save(post); // 변경 내용 저장 (UPDATE)
        log.info("← [Service] modifyPost 종료");
    }

    @Transactional
    public void deletePost(Long id) {
        log.info("→ [Service] deletePost 호출됨");
        postRepository.deleteById(id); // DB에 해당 id 게시글 삭제
        log.info("← [Service] deletePost 종료");
    }
}
