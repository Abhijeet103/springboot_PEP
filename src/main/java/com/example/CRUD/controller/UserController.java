package com.example.CRUD.controller;


import com.example.CRUD.dto.UserDto;
import com.example.CRUD.dto.UserResponseDto;
import com.example.CRUD.entity.User;
import com.example.CRUD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<UserResponseDto> getAllUsers(){
      return userService.getUsers()   ;
    }

    @PostMapping("")
    public UserResponseDto createUser(@RequestBody UserDto userDto){
        return userService.createUser(userDto) ;
    }
    @GetMapping("/{id}")
    public UserResponseDto getUser(@PathVariable long id){
        return userService.getuser(id) ;
    }

    @PutMapping("")
    public UserResponseDto UpdateUser(@RequestBody UserDto userDto){
        return userService.updateUserPartial(userDto) ;
    }

    @DeleteMapping("/{id}")
    public UserResponseDto deleteUser(@PathVariable long id){
        return userService.deleteUser(id) ;
    }








}
