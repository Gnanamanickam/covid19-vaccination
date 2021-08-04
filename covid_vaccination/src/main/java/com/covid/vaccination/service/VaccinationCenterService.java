package com.covid.vaccination.service;

import com.covid.vaccination.models.VaccinationCentre;
import com.covid.vaccination.repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaccinationCenterService {
    @Autowired
    VaccinationCenterRepository vaccinationCenterRepository;



    public List<VaccinationCentre> getALLVaccinationCentresInState(String state) {
        return vaccinationCenterRepository.getState(state);
    }

    public String getALlVaccinationCentersQuery() {
        return vaccinationCenterRepository.getState2();
    }

    public List<VaccinationCentre> getLessVaccinatedQuery() {
        return vaccinationCenterRepository.getLess();
    }

    public List<VaccinationCentre> getCountyHighestState(String state) {
        return vaccinationCenterRepository.getHighest(state);
    }

}
