package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("/user/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO){
        return userService.registerUser(userDTO);
    }

    @GetMapping("/user/list")
    public ResponseEntity<?> registerUser(){
        return userService.selectUserList();
    }


}
