package com.example.seungjinspringgg.controller;

import com.example.seungjinspringgg.global.config.security.auth.PrincipalDetails;
import com.example.seungjinspringgg.model.User;
import com.example.seungjinspringgg.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    @GetMapping({ "", "/" })
    public String index() {
        return "인덱스 페이지입니다.";
    }

    @GetMapping("/user")
    public String user(@AuthenticationPrincipal PrincipalDetails principal) {
        userService.usersAuthority(principal);
        return "유저 페이지입니다.";
    }

    @GetMapping("/admin")
    public String admin() {
        return "어드민 페이지입니다.";
    }

    @Secured("ROLE_MANAGER")
    @GetMapping("/manager")
    public String manager() {
        return "매니저 페이지입니다.";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/join")
    public String join() {
        return "join";
    }

    @PostMapping("/joinProc")
    public String joinProc(User user) {
        userService.userJoin(user);
        return "redirect:/";
    }
}
