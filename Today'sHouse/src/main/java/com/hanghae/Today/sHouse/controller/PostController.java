package com.hanghae.Today.sHouse.controller;

import com.hanghae.Today.sHouse.dto.MultipartFileDto;
import com.hanghae.Today.sHouse.model.Post;
import com.hanghae.Today.sHouse.security.UserDetailsImpl;
import com.hanghae.Today.sHouse.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;

    //게시글 등록
    @PostMapping("/api/post")
    public ResponseEntity<Post>createPost(@AuthenticationPrincipal UserDetailsImpl userDetails, MultipartFileDto requestDto){
        return new ResponseEntity<>(postService.createPost(userDetails, requestDto), HttpStatus.CREATED);
    }
}
