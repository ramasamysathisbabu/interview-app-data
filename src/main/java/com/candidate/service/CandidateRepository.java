package com.candidate.service;

import org.springframework.data.repository.CrudRepository;

import com.candidate.model.CandidateRequest;

public interface CandidateRepository extends CrudRepository<CandidateRequest, Integer>{
	
	

}
