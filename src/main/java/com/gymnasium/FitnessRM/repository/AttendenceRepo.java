package com.gymnasium.FitnessRM.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gymnasium.FitnessRM.entity.Attendence;

@Repository
public interface AttendenceRepo extends JpaRepository<Attendence, Long> {

	@Query(value = "SELECT name, mobile, date,time FROM gym.attendence a inner join\r\n"
			+ "gym.member m on m.id= a.member_id where mobile = ?1 and date between ?2 and ?3\r\n", nativeQuery = true)
	List<Map<String, Object>> findByMobileAndDate(String mobile, LocalDate start, LocalDate now);

}
