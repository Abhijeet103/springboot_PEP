package com.example.CRUD.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String content;
    private String mediaUrl ;
    private LocalDateTime createdAt ;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user ;


    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }


}
