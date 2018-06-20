package com.candidate.controller;

import java.util.List;
import com.candidate.service.CandidateServiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.candidate.model.CandidateRequest;
import com.candidate.model.CandidateResponse;
import com.candidate.service.CandidateService;

@RequestMapping("/interview")
@RestController
public class CandidateController {
	
//	@Autowired
//	private CandidateService candidateService;
	
	@Autowired
	CandidateServiceRepository candidateService;
	
	
	@PostMapping("/candidates")
	public CandidateResponse createCandidate(@RequestBody CandidateRequest candidateRequest){
		return candidateService.addCandidate(candidateRequest);
	}
	
	@GetMapping("/candidates")
	public List<CandidateResponse> getCandidates(){
		return candidateService.getCandidates();
	}

	@GetMapping("/candidates/{id}")
	public CandidateResponse getCandidate(@PathVariable String id){
		return candidateService.getCandidate(Integer.valueOf(id));
	}
	
	@PutMapping("/candidates/{id}")
	public CandidateResponse updateCandidate(@PathVariable String id, @RequestBody CandidateRequest candidateRequest){
		return candidateService.updateCandidate(Integer.valueOf(id), candidateRequest);
	}
	
	@DeleteMapping("/candidates/{id}")
	public void deleteCandidate(@PathVariable String id){
		candidateService.deleteCandidate(Integer.valueOf(id));
	}
	
}
