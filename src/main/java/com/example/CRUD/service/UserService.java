package com.example.CRUD.service;


import com.example.CRUD.dto.UserDto;
import com.example.CRUD.dto.UserResponseDto;
import com.example.CRUD.entity.UserInfo;
import com.example.CRUD.repository.UserInfoRepository;
import com.example.CRUD.repository.UserRepository;
import com.example.CRUD.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private UserInfoRepository userInfoRepository;

    private User toEntity(UserDto userDto){
        User user = new User();
        UserInfo userInfo = new UserInfo();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());

        userInfo.setName(userDto.getName());
        userInfo.setPhone(userDto.getPhone());
        userInfo.setProfilePic(userDto.getProfilePic());
        userInfo.setUser(user);
        user.setUserInfo(userInfo);

        return user;
    }

    private UserDto toDto(User user){
        UserDto userDto = new UserDto();
        UserInfo userInfo = user.getUserInfo();
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(userInfo.getPhone());
        userDto.setProfilePic(userInfo.getProfilePic());
        userDto.setName(userInfo.getName());

        return userDto;

    }

    private UserResponseDto toResponseDto(User user){
        UserResponseDto userDto = new UserResponseDto();
        UserInfo userInfo = user.getUserInfo();
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setName(userInfo.getName());

        return userDto;
    }
    public User createUser(UserDto userDto) {


        User user   = toEntity(userDto) ;
        userRepository.save(user);
        userInfoRepository.save(user.getUserInfo());

        return user;

    }

    public List<UserResponseDto> getUsers() {

        List<User> users  = userRepository.findAll();
        List<UserResponseDto> response = new ArrayList<>();
        for (User user : users) {
            response.add(toResponseDto(user));
        }
        return response;
    }

    public User getuser(long id){
        User  user = userRepository.findById(id).get();
        return user;
    }


    public User updateUser(User user) {
        long id = user.getId(); ;
        User  oldUser = userRepository.findById(id).get();
        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(user.getPassword());
        oldUser.setEmail(user.getEmail());

        userRepository.save(oldUser);
        return user;
    }


    public User deleteUser(long id) {
        User  user = userRepository.findById(id).get();
        userRepository.delete(user);
        return user;
    }




}
