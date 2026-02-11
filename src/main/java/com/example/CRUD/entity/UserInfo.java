package com.example.CRUD.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserInfo {
    @Id
    long Id ;

    private String name  ;
    private String profilePic ;
    private String phone ;
    private String location ;

    private VerficationStatus verificationStatus ;

    @OneToOne
    User user  ;


}
