package com.dragon.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dragon.movie.service.MyUserDetailsService;

@RestController
public class adminController {
	
	@Autowired
	MyUserDetailsService myUserDetailsService;
	
    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome User</h1>");
    }
}
