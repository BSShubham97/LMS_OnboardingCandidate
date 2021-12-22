package com.bl.onboarding.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.bl.onboarding.dto.BankInfoDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class BankInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String panNumber;
	private String aadharNumber;
	private String bankName;
	private String bankAccountNumber;
	private String ifscCode;
	private String passbookPath;
	private String panPath;
	private String aadharPath;
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="onboarding_id")
	@JsonBackReference
	private Onboarding onboarding;
	
	public BankInfo(BankInfoDTO bankinfoDTO) {
		this.panNumber = bankinfoDTO.getPanNumber();
		this.aadharNumber = bankinfoDTO.getAadharNumber();
		this.bankName = bankinfoDTO.getBankName();
		this.bankAccountNumber = bankinfoDTO.getBankAccountNumber();
		this.ifscCode = bankinfoDTO.getIfscCode();
		this.passbookPath = bankinfoDTO.getPassbookPath();
		this.panPath = bankinfoDTO.getPanPath();
		this.aadharPath = bankinfoDTO.getAadharPath();
	}

}
