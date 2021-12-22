package com.bl.onboarding.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bl.onboarding.model.Onboarding;


@Repository
public interface OnboardingRepo extends JpaRepository<Onboarding,Long > {
	
	
	@Query(value="Select * from onboarding where email = :email",nativeQuery=true)
	Onboarding findByEmail(String email);

}
