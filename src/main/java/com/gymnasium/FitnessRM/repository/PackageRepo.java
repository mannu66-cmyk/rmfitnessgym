package com.gymnasium.FitnessRM.repository;


import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.gymnasium.FitnessRM.entity.Package;
import com.gymnasium.FitnessRM.entity.Member;

@Repository
public interface PackageRepo extends JpaRepository<Package, Long> {

	@Query(value="SELECT p.name, p.price, p.date FROM gym.package p inner join\r\n"
			+ "gym.member m on m.id= p.member_id where mobile = ?1 \r\n"
			,nativeQuery = true)
	List<Map<String, Object>> findByMobile(String mobile);
}
