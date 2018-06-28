package com.candidate.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "candidaterequest")
public class CandidateRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="candidateSequence", sequenceName="candidatId_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="candidateSequence")
	private int candidateId;
	
	@Column(name = "prefix")
	private String prefix;
	
	@Column(name = "firstName")
	private String firstName;

	@Column(name = "middleName")
	private String middleName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	@Column(name = "emailAddress")
	private String emailAddress;
	
	@Column(name = "roleApplied")
	private String roleApplied;
	
	@Column(name = "technicalStack")
	private String technicalStack;
	
	@Column(name = "interviewer")
	private String interviewer;
	
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@Column(name = "interviewScheduleDate")
	private Date interviewScheduleDate;
	
	@Column(name = "yearsOfExperience")
	private int yearsOfExperience;
	
	public int getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getRoleApplied() {
		return roleApplied;
	}
	public void setRoleApplied(String roleApplied) {
		this.roleApplied = roleApplied;
	}
	public String getTechnicalStack() {
		return technicalStack;
	}
	public void setTechnicalStack(String technicalStack) {
		this.technicalStack = technicalStack;
	}
	public String getInterviewer() {
		return interviewer;
	}
	public void setInterviewer(String interviewer) {
		this.interviewer = interviewer;
	}
	public int getYearsOfExperience() {
		return yearsOfExperience;
	}
	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	public Date getInterviewScheduleDate() {
		return interviewScheduleDate;
	}
	public void setInterviewScheduleDate(Date interviewScheduleDate) {
		this.interviewScheduleDate = interviewScheduleDate;
	}

}
