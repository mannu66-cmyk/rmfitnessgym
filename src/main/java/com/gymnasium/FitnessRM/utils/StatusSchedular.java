package com.gymnasium.FitnessRM.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gymnasium.FitnessRM.entity.Member;
import com.gymnasium.FitnessRM.repository.MemberRepo;

import jakarta.annotation.PostConstruct;
 @Component
public class StatusSchedular {

	@Autowired
    private MemberRepo memberRepo;
	
	@PostConstruct
	void initials() {
		statusChangeToExpired();
	}
	
	@Scheduled(cron = "0 0 0 * * ?")
	public void statusChangeToExpired() {
		  List<Member> members= new ArrayList<>();
	            members = memberRepo.findAll();
	      for(Member member:members) {
	    	  member.setActive(member.getExpiryDate().isAfter(LocalDate.now().minusDays(1)));
	      }      
	      memberRepo.saveAll(members);
	}
}
