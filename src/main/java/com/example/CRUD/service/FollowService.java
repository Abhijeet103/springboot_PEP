package com.example.CRUD.service;


import com.example.CRUD.entity.User;
import com.example.CRUD.repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowService {


    @Autowired
    FollowRepository followRepository;

    List<User> getFollowers()
    {

    }

    List<User> getFollowing()
    {

    }

    Void toggleFollow(long userId){

    }
}
