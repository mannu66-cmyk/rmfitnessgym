package com.gymnasium.FitnessRM.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gymnasium.FitnessRM.entity.Attendence;
import com.gymnasium.FitnessRM.models.AttendenceDTO;
import com.gymnasium.FitnessRM.models.AttendenceResponse;
import com.gymnasium.FitnessRM.service.AttendenceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/attendance")
public class AttendenceController {

	@Autowired
    private AttendenceService attendanceService;

    // MARK ATTENDANCE
    @PostMapping("/mark")
    public ResponseEntity<?> markAttendance(@RequestBody AttendenceDTO req) {
    	 return ResponseEntity.ok(attendanceService.markAttendance(req.getMobile(), req.getPin()));
    }

    // ATTENDANCE HISTORY
    @GetMapping("/history")
    public List<AttendenceResponse> history(
        @RequestParam String mobile,
        @RequestParam String filter
    ) {
    	return attendanceService.getHistory(mobile, filter);
         
    }
}
