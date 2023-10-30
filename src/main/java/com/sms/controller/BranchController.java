package com.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sms.model.Branch;
import com.sms.service.BranchService;

@RestController
public class BranchController {
	
	@Autowired
	private BranchService branchService;
	
	@PostMapping("/addBranch")
	public Branch addBranch(@RequestBody Branch branch) {
		return branchService.addBranch(branch);
	}

}
