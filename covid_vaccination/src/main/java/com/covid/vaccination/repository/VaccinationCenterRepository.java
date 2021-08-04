package com.covid.vaccination.repository;

import com.covid.vaccination.models.VaccinationCentre;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaccinationCenterRepository extends CrudRepository<VaccinationCentre,Integer> {

    String query1="select * from vaccination_center where state=?1";




    @Query(nativeQuery = true,value = query1)
    List<VaccinationCentre> getState(String state);


    String query2="select state from vaccination_center group by state,vaccinated  order by state,sum(vaccinated) desc limit 1";
    @Query(nativeQuery = true,value=query2)
    String getState2();


    String query3="select * from vaccination_center group by county,vaccinated,population having sum(vaccinated)<0.5*sum(population)";
    @Query(nativeQuery = true,value=query3)
    List<VaccinationCentre> getLess();

    String query4="select * from vaccination_center where state=?1 group by county order by count(county) desc limit 1";
    @Query(nativeQuery = true,value=query4)
    List<VaccinationCentre> getHighest(String state);



}
