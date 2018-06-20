package com.candidate.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.candidate.model.CandidateRequest;
import com.candidate.model.CandidateResponse;

@Service
public class CandidateServiceRepository {

	@Autowired
	private CandidateRepository candidateRepository;
	
	public List<CandidateResponse> getCandidates(){
		List<CandidateResponse> candidateResponses = new ArrayList<CandidateResponse>();
		
		for (CandidateRequest candidateRequest : candidateRepository.findAll()){
			CandidateResponse CandidateResponse = convertCandidateEntityToResponse(candidateRequest);
			candidateResponses.add(CandidateResponse);
		}
		return candidateResponses;
	}
	
	public CandidateResponse addCandidate(CandidateRequest candidateRequest){
		CandidateRequest persistedCandidate = candidateRepository.save(candidateRequest);
		CandidateResponse candidateResponse = convertCandidateEntityToResponse(persistedCandidate);
		return candidateResponse;
	}
	
	public CandidateResponse getCandidate(int candidateId){
		CandidateRequest candidateRequestFromDatabase = candidateRepository.findOne(candidateId);
		CandidateResponse candidateResponse = convertCandidateEntityToResponse(candidateRequestFromDatabase);
		return candidateResponse;
	}
	
	public CandidateResponse updateCandidate(int candidateId, CandidateRequest candidateRequest){
		CandidateRequest persistedCandidate = candidateRepository.save(candidateRequest);
		CandidateResponse candidateResponse = convertCandidateEntityToResponse(persistedCandidate);
		return candidateResponse;		
	}
	
	public void deleteCandidate(int candidateId){
		candidateRepository.delete(candidateId);
	}
	
	@PostConstruct
	private List<CandidateResponse> populateCandidates() {
		List<CandidateResponse> candidates = new ArrayList<CandidateResponse>();
		
		for (int i = 1; i < 5 ; i++) {
			CandidateResponse candidateResponse = new CandidateResponse();
			candidateResponse.setCandidateId(i);
			candidateResponse.setFirstName("first name " + i);
			candidateResponse.setLastName("last name " + i);
			candidateResponse.setMiddleName("middle name " + i);
			candidates.add(candidateResponse);
		}
		return candidates;
	}
	
	private CandidateResponse convertCandidateEntityToResponse(CandidateRequest candidateRequest){
		CandidateResponse candidateResponse = new CandidateResponse();
		if (candidateRequest != null){
			candidateResponse.setCandidateId(candidateRequest.getCandidateId());
			candidateResponse.setPrefix(candidateRequest.getPrefix());
			candidateResponse.setFirstName(candidateRequest.getFirstName());
			candidateResponse.setMiddleName(candidateRequest.getMiddleName());
			candidateResponse.setLastName(candidateRequest.getLastName());
			candidateResponse.setPhoneNumber(candidateRequest.getPhoneNumber());
			candidateResponse.setEmailAddress(candidateRequest.getEmailAddress());
			candidateResponse.setRoleApplied(candidateRequest.getRoleApplied());
			candidateResponse.setTechnicalStack(candidateRequest.getTechnicalStack());
			candidateResponse.setInterviewer(candidateRequest.getInterviewer());
			candidateResponse.setInterviewScheduleDate(candidateRequest.getInterviewScheduleDate());
			candidateResponse.setYearsOfExperience(candidateRequest.getYearsOfExperience());
		}
		return candidateResponse;
	}
}
