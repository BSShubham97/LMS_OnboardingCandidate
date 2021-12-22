package com.bl.onboarding.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class BankInfoDTO {
	
	private String panNumber;
	private String aadharNumber;
	private String bankName;
	private String bankAccountNumber;
	private String ifscCode;
	private String passbookPath;
	private String panPath;
	private String aadharPath;

}
