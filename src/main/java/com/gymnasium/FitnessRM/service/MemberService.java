package com.gymnasium.FitnessRM.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymnasium.FitnessRM.entity.Member;
import com.gymnasium.FitnessRM.models.MemberRequest;
import com.gymnasium.FitnessRM.models.MemberResponse;
import com.gymnasium.FitnessRM.repository.MemberRepo;
import com.gymnasium.FitnessRM.repository.PackageRepo;
import com.gymnasium.FitnessRM.entity.Package;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	@Autowired
    private MemberRepo memberRepo;
	@Autowired
    private PackageRepo packageRepo;

    public void saveOrUpdate(MemberRequest req) {

        Member member = memberRepo.findByMobile(req.getMobile())
            .orElse(new Member());

        member.setName(req.getName());
        member.setMobile(req.getMobile());
        member.setAge(req.getAge());
        member.setPin(req.getPin());
        member.setPlan(req.getPlan());
        member.setStartDate(req.getStartDate());

        // Calculate expiry
        member.setExpiryDate(calculateExpiry(member.getExpiryDate()!=null? member.getExpiryDate():req.getStartDate(), req.getPlan()));

        // Active or Expired
        member.setActive(member.getExpiryDate().isAfter(LocalDate.now().plusDays(1)));

        Package p= new Package( req.getPrice(), LocalDate.now(),member,req.getPlan());
        packageRepo.save(p);
    }

    public List<MemberResponse> getAll(String filter) {

        List<Member> members;

        if ("active".equalsIgnoreCase(filter))
            members = memberRepo.findByActive(true);
        else if ("expired".equalsIgnoreCase(filter))
            members = memberRepo.findByActive(false);
        else
            members = memberRepo.findAll();

        return members.stream()
            .map(m -> new MemberResponse(m.getId(),
                m.getName(),
                m.getMobile(),
                m.getPlan(),
                m.getActive() ? "Active" : "Expired",
				m.getPin(),
				m.getAge(),
				m.getStartDate(),
				  m.getExpiryDate()
            ))
            .collect(Collectors.toList());
    }

    public Member getByMobile(String mobile) {
        return memberRepo.findByMobile(mobile)
            .orElseThrow(() -> new RuntimeException("Member not found"));
    }

    private LocalDate calculateExpiry(LocalDate start, String plan) {
        return switch (plan) {
            case "1 Month" -> start.plusMonths(1);
            case "3 Months" -> start.plusMonths(3);
            case "6 Months" -> start.plusMonths(6);
            case "12 Months" -> start.plusMonths(12);
            default -> start;
        };
    }
}
