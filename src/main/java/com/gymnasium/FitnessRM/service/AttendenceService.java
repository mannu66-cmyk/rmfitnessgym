package com.gymnasium.FitnessRM.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gymnasium.FitnessRM.*;
import com.gymnasium.FitnessRM.entity.Attendence;
import com.gymnasium.FitnessRM.entity.Member;
import com.gymnasium.FitnessRM.models.AttendenceResponse;
import com.gymnasium.FitnessRM.repository.AttendenceRepo;
import com.gymnasium.FitnessRM.repository.MemberRepo;

import lombok.RequiredArgsConstructor;

@Service
public class AttendenceService {

    private FitnessRmApplication fitnessRmApplication;

	@Autowired
    private  MemberRepo memberRepo;
	@Autowired
    private  AttendenceRepo attendanceRepo;

    AttendenceService(FitnessRmApplication fitnessRmApplication) {
        this.fitnessRmApplication = fitnessRmApplication;
    }

    public String markAttendance(String mobile, String pin) {
        Member member = memberRepo.findByMobile(mobile)
            .orElseThrow(() -> new RuntimeException("Member not found"));

        if (!member.getPin().equals(pin)) {
        	return "Invalid PIN";
        }
        if(!member.getActive()) {
        	return "Package is expired.";
        }
        Attendence attendance = new Attendence();
        attendance.setMember(member);
        attendance.setDate(LocalDate.now());

        attendanceRepo.save(attendance);
        return "Attendance marked successfully.";
    }

    public List<AttendenceResponse> getHistory(String mobile, String filter) {
        LocalDate now = LocalDate.now();
        LocalDate start;

        switch (filter) {
            case "day" -> start = now;
            case "week" -> start = now.minusDays(7);
            case "month" -> start = now.withDayOfMonth(1);
            case "year" -> start = now.withDayOfYear(1);
            default -> throw new RuntimeException("Invalid filter");
        }
        List<AttendenceResponse> attendences = new ArrayList<>();
       List<Map<String, Object>> datas = attendanceRepo.findByMobileAndDate(mobile ,start ,now); 
        for(Map<String, Object> data:datas) {
        	attendences.add(new AttendenceResponse( data.get("name").toString(),
data.get("mobile").toString(),data.get("date").toString()));  }
        return attendences;
    }
}

