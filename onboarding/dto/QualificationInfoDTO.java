package com.bl.onboarding.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class QualificationInfoDTO {
	
	private boolean diploma;
	private String degree;
	private String field;
	private String yearOfPassing;
	private String finalPercentage;
	private String aggrPercentage;
	private String enggCertificate;
	private String finalCertificate;
	private String trainingInstitute;
	private String trainingDuration;
	private String course;

}
