package com.bl.onboarding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bl.onboarding.dto.OnboardingDTO;
import com.bl.onboarding.exception.LoginException;
import com.bl.onboarding.exception.UserNotFoundException;
import com.bl.onboarding.model.Onboarding;
import com.bl.onboarding.response.Response;
import com.bl.onboarding.services.EmailSenderService;
import com.bl.onboarding.services.IOnboardingServices;

@RestController
@RequestMapping("/onboarding")
class OnObardingController {

	@Autowired
	private IOnboardingServices onboardServices;
	@Autowired
	EmailSenderService mailService;

	@PostMapping("/add")
	public ResponseEntity<Response> addUser(@RequestHeader String token, @RequestBody OnboardingDTO user)
			throws LoginException {
		Onboarding userdata = onboardServices.addUserData(token, user);
		Response response = new Response("User Added SuccessFully", (long) 200, userdata);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@GetMapping("/get")
	public ResponseEntity<Response> getProfile(@RequestHeader String token, @RequestHeader long id)
			throws LoginException, UserNotFoundException {
		Onboarding profile = onboardServices.getOnboardingbyId(token, id);
		Response response = new Response("Profile got SuccessFully", (long) 200, profile);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Response> delete(@RequestHeader String token, @RequestHeader long id)
			throws LoginException, UserNotFoundException {
		Onboarding profile = onboardServices.delete(token, id);
		Response response = new Response("Profile got SuccessFully", (long) 200, profile);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<Response> getAllCandidates(@RequestHeader String token)
			throws LoginException, UserNotFoundException {
		List<Onboarding> allProfiles = onboardServices.getAllOnboardingStudent(token);
		Response response = new Response("All Candidates got SuccessFully", (long) 200, allProfiles);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@PutMapping("/edit")
	public ResponseEntity<Response> editUser(@RequestHeader String token, @RequestHeader long id,
			@RequestBody OnboardingDTO user) throws UserNotFoundException, LoginException {
		Onboarding updatedUser = onboardServices.editUser(token, id, user);
		Response response = new Response("Updated user successfully", (long) 200, updatedUser);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@GetMapping("/sendmail")
	public ResponseEntity<Response> sendOfferMail(@RequestHeader String email)
			throws UserNotFoundException, LoginException {
		Response respDto = new Response("MAIL SENT !!!", (long) 200, email);
		EmailSenderService.sendMail(email, "You have been selected",
				"This is the Onboarding Message and JOB Offer !!! ");
		return new ResponseEntity<Response>(respDto, HttpStatus.OK);

	}
}
