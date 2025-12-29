package com.gymnasium.FitnessRM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gymnasium.FitnessRM.entity.Member;
import com.gymnasium.FitnessRM.models.MemberRequest;
import com.gymnasium.FitnessRM.models.MemberResponse;
import com.gymnasium.FitnessRM.service.MemberService;

@RestController
@RequestMapping("/api/members")
@CrossOrigin
public class MemberController {

	@Autowired
    private MemberService memberService;

    // ADD / UPDATE MEMBER
    @PostMapping
    public ResponseEntity<?> saveMember(@RequestBody MemberRequest req) {
        memberService.saveOrUpdate(req);
        return ResponseEntity.ok("Member saved successfully");
    }

    // LIST MEMBERS (ALL / ACTIVE / EXPIRED)
    @GetMapping
    public List<MemberResponse> listMembers(
        @RequestParam(defaultValue = "all") String filter
    ) {
        return memberService.getAll(filter);
    }

    // SEARCH BY MOBILE (Attendance Screen)
    @GetMapping("/{mobile}")
    public MemberResponse getByMobile(@PathVariable String mobile) {
        Member m = memberService.getByMobile(mobile);
        return new MemberResponse(
        		m.getId(),
                m.getName(),
                m.getMobile(),
                m.getPlan(),
                m.getActive() ? "Active" : "Expired",
				m.getPin(),
				m.getAge(),
				m.getStartDate(),
				m.getExpiryDate()
        );
    }
}
