package com.example.seungjinspringgg.service;


import com.example.seungjinspringgg.global.config.security.auth.PrincipalDetails;
import com.example.seungjinspringgg.model.User;

public interface UserService {

    void usersAuthority(PrincipalDetails principal);

    void userJoin(User user);

}
