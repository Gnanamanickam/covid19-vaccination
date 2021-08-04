package com.covid.vaccination.repository;

import com.covid.vaccination.models.Stock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends CrudRepository<Stock,String> {

    String complex_query1="select vc.state from stock s inner join\n" +
            "vaccine v on v.id = s.vaccine_id inner join\n" +
            "vaccination_center vc on vc.id=s.center_id \n" +
            "group by vc.state,v.vaccine_name having v.vaccine_name=\"Pfizer\" \n" +
            "order by sum(s.stock) desc limit 1";
    @Query(nativeQuery = true,value=complex_query1)
    List<String> getHighestPfizerVaccine();

    String complex_query2="select sum(vc.vaccinated) from stock s inner join\n" +
            "vaccine v on v.id = s.vaccine_id inner join\n" +
            "vaccination_center vc on vc.id=s.center_id where vc.state=\"Illinois\" and v.vaccine_name=?1";
    @Query(nativeQuery = true,value=complex_query2)
    List<String> getSumOfVaccined(String name);
}
