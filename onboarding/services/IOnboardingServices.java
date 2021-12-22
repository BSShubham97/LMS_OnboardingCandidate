package com.bl.onboarding.services;

import java.util.List;

import com.bl.onboarding.dto.OnboardingDTO;
import com.bl.onboarding.exception.LoginException;
import com.bl.onboarding.exception.UserNotFoundException;
import com.bl.onboarding.model.Onboarding;

public interface IOnboardingServices {

	Onboarding addUserData(String token, OnboardingDTO user) throws LoginException;

	Onboarding getOnboardingbyId(String token, long id) throws LoginException, UserNotFoundException;

	Onboarding delete(String token, long id) throws LoginException, UserNotFoundException;

	List<Onboarding> getAllOnboardingStudent(String token) throws LoginException, UserNotFoundException;

	Onboarding editUser(String token, long id, OnboardingDTO user) throws LoginException, UserNotFoundException;

	void sendOfferMail(String token, String email) throws UserNotFoundException, LoginException;

}
