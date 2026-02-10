package com.example.CRUD;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    User createUser(User user) {
        userRepository.save(user);
        return user;
    }

    List<User> getUsers() {

        List<User> users  = userRepository.findAll();
        return users;
    }

    User getuser(long id){
        User  user = userRepository.findById(id).get();
        return user;
    }


    User updateUser(User user) {
        long id = user.getId(); ;
        User  oldUser = userRepository.findById(id).get();
        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(user.getPassword());
        oldUser.setEmail(user.getEmail());

        userRepository.save(oldUser);
        return user;
    }


    User deleteUser(long id) {
        User  user = userRepository.findById(id).get();
        userRepository.delete(user);
        return user;
    }




}
