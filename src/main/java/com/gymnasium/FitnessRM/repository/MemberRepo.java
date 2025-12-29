package com.gymnasium.FitnessRM.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gymnasium.FitnessRM.entity.Member;

@Repository
public interface MemberRepo extends JpaRepository<Member, Long> {

	Optional<Member> findByMobile(String mobile);

	List<Member> findByActive(Boolean active);
}
