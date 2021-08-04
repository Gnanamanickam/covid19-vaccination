package com.covid.vaccination.service;

import com.covid.vaccination.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    StockRepository stockRepository;
    public List<String> getHighestPfizer() {
        return stockRepository.getHighestPfizerVaccine();
    }

    public List<String> getSumVaccinated(String name) {
        return stockRepository.getSumOfVaccined(name);
    }
}
