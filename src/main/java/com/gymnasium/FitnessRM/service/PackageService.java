package com.gymnasium.FitnessRM.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gymnasium.FitnessRM.*;
import com.gymnasium.FitnessRM.entity.Attendence;
import com.gymnasium.FitnessRM.entity.Member;
import com.gymnasium.FitnessRM.models.AttendenceResponse;
import com.gymnasium.FitnessRM.models.PackageResponse;
import com.gymnasium.FitnessRM.repository.AttendenceRepo;
import com.gymnasium.FitnessRM.repository.MemberRepo;
import com.gymnasium.FitnessRM.repository.PackageRepo;

import lombok.RequiredArgsConstructor;

@Service
public class PackageService {

	@Autowired
	private PackageRepo packageRepo;

	public List<PackageResponse> getHistory(String mobile) {

		List<PackageResponse> packages = new ArrayList<>();
		List<Map<String, Object>> datas = packageRepo.findByMobile(mobile);
		for (Map<String, Object> data : datas) {
			packages.add(new PackageResponse(data.get("name").toString(),
					Integer.parseInt(data.get("price").toString()), data.get("date").toString()));
		}
		return packages;
	}

	public Integer getAggregate(Integer param) {

		if (param < 13) {
			Optional<Integer> aggMonth = packageRepo.findAggregatePerMonth(param);
			if (aggMonth.isPresent())
				return aggMonth.get();
			else
				return 0;
		} else {
			Optional<Integer> aggYear = packageRepo.findAggregatePerYear(param);
			if (aggYear.isPresent())
				return aggYear.get();
			else
				return 0;
		}
	}
}
