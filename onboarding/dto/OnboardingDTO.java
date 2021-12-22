package com.bl.onboarding.dto;

import com.bl.onboarding.model.BankInfo;
import com.bl.onboarding.model.QualificationInfo;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OnboardingDTO {

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

	private BankInfo bankInfo;
	private QualificationInfo qualificationInfo;

}
