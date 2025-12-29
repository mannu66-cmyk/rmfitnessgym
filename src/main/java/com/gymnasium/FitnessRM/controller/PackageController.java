package com.gymnasium.FitnessRM.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gymnasium.FitnessRM.models.AttendenceResponse;
import com.gymnasium.FitnessRM.models.PackageResponse;
import com.gymnasium.FitnessRM.service.AttendenceService;
import com.gymnasium.FitnessRM.service.PackageService;
import com.gymnasium.FitnessRM.utils.JwtUtil;

@RestController
@RequestMapping("/api/package")
public class PackageController {

	@Autowired
    private PackageService packageService;

    @GetMapping("/history")
    public List<PackageResponse> history(
        @RequestParam String mobile
    ) {
    	return packageService.getHistory(mobile);
         
    }
}
