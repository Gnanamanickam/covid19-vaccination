package com.covid.vaccination.service;

import com.covid.vaccination.models.Receiver;
import com.covid.vaccination.repository.ReceiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;

@Service
public class ReceiverService {
    HashMap<String,String> hmap;
    @Autowired
    private ReceiverRepository receiverRepository;

    public List<Receiver> getAllReceivers() {
        return receiverRepository.getFromDatabase();
    }

    @Transactional
    public void addReceiver(Receiver receiver) {
        receiverRepository.addTodatabse(receiver.getId(),receiver.getUser_id(),receiver.getVaccine_id(),receiver.getCenter_id());
    }

    @Transactional
    public void updateReceiver(Receiver receiver,String id) {

        receiverRepository.updateDatabse(id,receiver.getUser_id(),receiver.getCenter_id(),receiver.getVaccine_id());
    }

    @Transactional
    public void deleteReceiver(String id) {
        receiverRepository.delete(id);
    }

    public List<String> getUsresreceivedVaccine(String month) {
        hmap = new HashMap<>();
        hmap.put("01","31");
        hmap.put("02","28");
        hmap.put("03","31");
        hmap.put("04","30");
        hmap.put("05","31");
        hmap.put("06","30");
        hmap.put("07","31");
        hmap.put("08","31");
        hmap.put("09","30");
        hmap.put("10","31");
        hmap.put("11","30");
        hmap.put("12","31");
        String start_date="2021-"+month+"01";
        String end_date="2021-"+month+"-"+hmap.get(month);
        System.out.println(receiverRepository.getUsersReceivedVaccine(start_date,end_date));
        return receiverRepository.getUsersReceivedVaccine(start_date,end_date);

    }

    public List<String> getCountyWIthSideEffects() {
        return receiverRepository.getCountyWithSIdeEffects();

    }

    public List<String> getNoUsers(String name) {
        return receiverRepository.getNoUsers(name);
    }
}
