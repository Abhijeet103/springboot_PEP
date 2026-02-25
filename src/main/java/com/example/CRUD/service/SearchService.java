package com.example.CRUD.service;


import com.example.CRUD.dto.UserDto;
import com.example.CRUD.dto.UserResponseDto;
import com.example.CRUD.entity.User;
import com.example.CRUD.entity.UserInfo;
import com.example.CRUD.repository.PostRepository;
import com.example.CRUD.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SearchService {


    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;


    private UserResponseDto toResponseDto(User user){
        UserResponseDto userDto = new UserResponseDto();
        UserInfo userInfo = user.getUserInfo();
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setName(userInfo.getName());

        return userDto;
    }


    Page<UserResponseDto> searchUser(String username , int page , int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<User> users = userRepository.findByUsernameContainingIgnoreCase(username , pageable) ;

        return users.map(this::toResponseDto) ;
    }

    // search post

}
