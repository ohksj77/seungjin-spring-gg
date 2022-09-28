package com.example.seungjinspringgg.service;


import com.example.seungjinspringgg.global.config.security.auth.PrincipalDetails;
import com.example.seungjinspringgg.entity.User;

public interface UserService {

    void usersAuthority(PrincipalDetails principal);

    void userJoin(User user);

}
