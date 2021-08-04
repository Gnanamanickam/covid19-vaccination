package com.covid.vaccination.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.covid.vaccination.models.CovidVaccinationDetails;

@Repository
public interface CovidVaccinationDetailsRepository extends JpaRepository<CovidVaccinationDetails, Long> {

}
