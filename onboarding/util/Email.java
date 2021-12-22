package com.bl.onboarding.util;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Email {

	String to;
	String from;
	String subject;
	String body;

}
