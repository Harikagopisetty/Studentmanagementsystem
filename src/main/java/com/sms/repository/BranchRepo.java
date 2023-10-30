package com.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sms.model.Branch;

public interface BranchRepo extends JpaRepository<Branch, Integer> {
	
   Branch findByBranchName(String branchName);

}
