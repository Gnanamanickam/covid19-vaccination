package com.covid.vaccination.service;

import com.covid.vaccination.models.Vaccine;
import com.covid.vaccination.repository.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class VaccineService {

    @Autowired
    VaccineRepository vaccinationRepository;



    public List<Vaccine> getAllVaccines() {
        return vaccinationRepository.getAllFromDatabase();
    }

    @Transactional
    public void addVaccine(Vaccine vaccine){
        vaccinationRepository.addToDatabase(vaccine.getVaccine_name(),vaccine.getDoses(),vaccine.getType());

    }

    @Transactional
    public void updateVaccine(Vaccine vaccine,String  id){
        int vaccine_id=Integer.parseInt(id);
        vaccinationRepository.updateToDatabase(vaccine_id,vaccine.vaccine_name,vaccine.doses,vaccine.type);
    }

    @Transactional
    public void deleteVaccine(String id){
        int vaccine_id=Integer.parseInt(id);
        vaccinationRepository.deleteFromDatabase(vaccine_id);
    }
}
