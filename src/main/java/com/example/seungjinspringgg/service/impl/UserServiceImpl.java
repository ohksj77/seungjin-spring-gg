package com.example.seungjinspringgg.service.impl;

import com.example.seungjinspringgg.global.config.security.auth.PrincipalDetails;
import com.example.seungjinspringgg.entity.User;
import com.example.seungjinspringgg.repository.UserRepository;
import com.example.seungjinspringgg.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Iterator;

import static com.example.seungjinspringgg.entity.Role.ROLE_USER;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void usersAuthority(PrincipalDetails principal) {
        Iterator<? extends GrantedAuthority> iter = principal.getAuthorities().iterator();
        while (iter.hasNext()) {
            GrantedAuthority auth = iter.next();
            System.out.println(auth.getAuthority());
        }
    }

    public void userJoin(User user) {
        String rawPassword = user.getPassword();
        String encPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encPassword);
        user.setRole(ROLE_USER);
        userRepository.save(user);
    }

}
