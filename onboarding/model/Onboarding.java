package com.bl.onboarding.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.bl.onboarding.dto.OnboardingDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Onboarding {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String mobileNum;
	private String hiredCity;
	private String parentName;
	private String parentMobile;
	private String temporaryAddress;
	private String parentOccupation;
	private String parentAnnualSalary;
	private String permanentAddress;
	private String profileImage;
	private String folderId;
	private String status;
	
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "onboarding")
	@JsonManagedReference
	private BankInfo bankInfo;
	

	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "onboarding")
	@JsonManagedReference
	private QualificationInfo qualificationInfo;
	
	
	public Onboarding(OnboardingDTO onboardingDTO) {
		this.firstName = onboardingDTO.getFirstName();
		this.middleName = onboardingDTO.getMiddleName();
		this.lastName = onboardingDTO.getLastName();
		this.email = onboardingDTO.getEmail();
		this.mobileNum = onboardingDTO.getMobileNum();
		this.hiredCity = onboardingDTO.getHiredCity();
		this.parentName = onboardingDTO.getParentName();
		this.parentMobile = onboardingDTO.getParentMobile();
		this.parentAnnualSalary = onboardingDTO.getParentAnnualSalary();
		this.parentOccupation = onboardingDTO.getParentOccupation();
		this.temporaryAddress = onboardingDTO.getTemporaryAddress();
		this.permanentAddress = onboardingDTO.getPermanentAddress();
		this.profileImage = onboardingDTO.getProfileImage();
		this.folderId = onboardingDTO.getFolderId();
		this.status = onboardingDTO.getStatus();
		this.bankInfo = onboardingDTO.getBankInfo();
		this.qualificationInfo = onboardingDTO.getQualificationInfo();
		
	}

}
