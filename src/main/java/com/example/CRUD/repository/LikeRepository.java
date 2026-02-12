package com.example.CRUD.repository;

import com.example.CRUD.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {

        public List<Like> findAllByUserId(long id) ;
}
