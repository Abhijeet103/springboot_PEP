package com.example.CRUD.controller;


import com.example.CRUD.auth.JwtUtil;
import com.example.CRUD.dto.PostResponseDto;
import com.example.CRUD.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    private final JwtUtil jwtUtil;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<PostResponseDto> create(@RequestParam("content") String  content , @RequestParam(value = "file" , required = false) MultipartFile file , @RequestHeader("Authorization") String token) {
        token = token.substring(7);
        if(jwtUtil.validateToken(token)){
            String username = jwtUtil.extractUsername(token);
             PostResponseDto  response =  postService.create(content, file, username);
            return ResponseEntity.ok().body(response);
        }

        return ResponseEntity.badRequest().build();


    }


    // update

    // get










}
