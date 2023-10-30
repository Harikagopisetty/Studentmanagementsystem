package com.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.model.Branch;
import com.sms.repository.BranchRepo;

@Service
public class BranchService {
	
	@Autowired
	private BranchRepo branchRepo;
	
	public Branch addBranch(Branch  branch) {
		return branchRepo.save(branch);
	}

}
