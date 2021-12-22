package com.bl.onboarding.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.bl.onboarding.dto.QualificationInfoDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class QualificationInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
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
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="onboarding_id")
	@JsonBackReference
	private Onboarding onboarding;
	
	public QualificationInfo(QualificationInfoDTO qualificationInfo) {
		this.diploma = qualificationInfo.isDiploma();
		this.degree = qualificationInfo.getDegree();
		this.field = qualificationInfo.getField();
		this.yearOfPassing = qualificationInfo.getYearOfPassing();
		this.finalPercentage = qualificationInfo.getFinalPercentage();
		this.aggrPercentage = qualificationInfo.getAggrPercentage();
		this.enggCertificate = qualificationInfo.getEnggCertificate();
		this.finalCertificate = qualificationInfo.getFinalCertificate();
		this.trainingInstitute = qualificationInfo.getTrainingInstitute();
		this.trainingDuration = qualificationInfo.getTrainingDuration();
		this.course = qualificationInfo.getCourse();
	}

}
