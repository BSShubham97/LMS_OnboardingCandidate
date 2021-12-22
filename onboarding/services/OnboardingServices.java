package com.bl.onboarding.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bl.onboarding.dto.OnboardingDTO;
import com.bl.onboarding.exception.LoginException;
import com.bl.onboarding.exception.UserNotFoundException;
import com.bl.onboarding.model.BankInfo;
import com.bl.onboarding.model.Onboarding;
import com.bl.onboarding.model.QualificationInfo;
import com.bl.onboarding.repository.OnboardingRepo;

@Service
public class OnboardingServices implements IOnboardingServices{
	
	@Autowired
	private OnboardingRepo onboardingRepo;
	
	@Autowired
	private EmailSenderService mailServices;

	@Override
	public Onboarding addUserData(String token, OnboardingDTO user) throws LoginException {
		if(!token.isEmpty()) {
			Onboarding onboardingUser = new Onboarding(user);
			BankInfo bankInfo = user.getBankInfo();
			QualificationInfo qualifiInfo = user.getQualificationInfo();
			
			onboardingUser.setBankInfo(bankInfo);
			onboardingUser.setQualificationInfo(qualifiInfo);
			
			bankInfo.setOnboarding(onboardingUser);
			qualifiInfo.setOnboarding(onboardingUser);
			
			return onboardingRepo.save(onboardingUser);
		}else {
			throw new LoginException("Access Denied...!");
		}
	}

	@Override
	public Onboarding getOnboardingbyId(String token, long id) throws LoginException, UserNotFoundException {
		if(token.isEmpty()) {
			throw new LoginException("Access Denied...!");
		}else {
			Optional<Onboarding> isPresent = onboardingRepo.findById(id);
			if(isPresent.isPresent()) {
				return isPresent.get();
			}else {
				throw new UserNotFoundException("User not present of this Id");
			}
			
		}
	}

	@Override
	public Onboarding delete(String token, long id) throws LoginException, UserNotFoundException {
		if(token.isEmpty()) {
			throw new LoginException("Access Denied...!");
		}else {
			if(this.getOnboardingbyId(token, id) != null) {
				onboardingRepo.delete(this.getOnboardingbyId(token, id));
				return getOnboardingbyId(token, id);
			}else {
				throw new UserNotFoundException("User not present of this Id");
			}
		}


	}

	@Override
	public List<Onboarding> getAllOnboardingStudent(String token) throws LoginException, UserNotFoundException{
		if(!token.isEmpty()) {
			List<Onboarding> userData = new ArrayList<>();
			onboardingRepo.findAll().forEach(userData::add);
			if(userData.isEmpty()) {
				throw new UserNotFoundException("No Data Present in Database,First Add Data");
			}else {
				return userData;
			}
		}else {
			throw new LoginException("Access Denied...!");
		}
	}

	@Override
	public Onboarding editUser(String token, long id, OnboardingDTO user) throws LoginException, UserNotFoundException {
		if(token.isEmpty()) {
			throw new LoginException("Access Denied...!");	
		}else {
			if(this.getOnboardingbyId(token, id) != null) {
				Onboarding onboardCandidate = this.getOnboardingbyId(token, id);
				
				onboardCandidate.setFirstName(user.getFirstName());
				onboardCandidate.setLastName(user.getLastName());
				onboardCandidate.setMiddleName(user.getMiddleName());
				onboardCandidate.setEmail(user.getEmail());
				onboardCandidate.setMobileNum(user.getMobileNum());
				onboardCandidate.setHiredCity(user.getHiredCity());
				onboardCandidate.setParentName(user.getParentName());
				onboardCandidate.setParentMobile(user.getParentMobile());
				onboardCandidate.setTemporaryAddress(user.getTemporaryAddress());
				onboardCandidate.setParentOccupation(user.getParentOccupation());
				onboardCandidate.setParentAnnualSalary(user.getParentAnnualSalary());
				onboardCandidate.setPermanentAddress(user.getPermanentAddress());
				onboardCandidate.setProfileImage(user.getProfileImage());
				onboardCandidate.setFolderId(user.getFolderId());
				onboardCandidate.setStatus(user.getStatus());
				
				
				BankInfo bankInfo = user.getBankInfo();
				QualificationInfo qualifiInfo = user.getQualificationInfo();
				
				onboardCandidate.setBankInfo(bankInfo);
				onboardCandidate.setQualificationInfo(qualifiInfo);
				
				bankInfo.setOnboarding(onboardCandidate);
				qualifiInfo.setOnboarding(onboardCandidate);
				
				return onboardingRepo.save(onboardCandidate);
				
			}else {
				throw new UserNotFoundException("User not present of this Id");
			}
		}
	}

	@Override
	public void sendOfferMail(String token, String email) throws UserNotFoundException, LoginException {
		if(token.isEmpty()) {
			throw new LoginException("Access Denied...!");
		}else {
			if(onboardingRepo.findByEmail(email) != null) {
				EmailSenderService.sendMail(email, "Selected", "You got selected");
			}else {
				throw new UserNotFoundException("this email not present in this database");
			}
		}
		
	}

}
