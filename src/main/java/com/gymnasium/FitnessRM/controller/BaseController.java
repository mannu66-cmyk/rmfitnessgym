package com.gymnasium.FitnessRM.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gymnasium.FitnessRM.utils.JwtUtil;

@RestController
public class BaseController {

    @GetMapping 
    public String check() {

        return "running..........";
    }
}
