package com.covid.vaccination.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.covid.vaccination.models.Vaccine;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VaccineRepository extends CrudRepository<Vaccine, Integer> {

    String query1="select * from vaccine";
    @Query(nativeQuery = true,value = query1)
    List<Vaccine> getAllFromDatabase();


    String query2="insert into vaccine(vaccine_name,doses,type) values (:vaccine_name,:doses,:type)";
    @Modifying
    @Query(nativeQuery = true,value=query2)
    void addToDatabase(@Param("vaccine_name") String vaccine_name, @Param("doses") int doses, @Param("type") String type);

    String query3="update vaccine set vaccine_name=?2,doses=?3,type=?4 where id=?1";
    @Modifying
    @Query(nativeQuery = true,value=query3)
    void updateToDatabase(int id, String vaccine_name, int doses, String type);

    String query4="delete from vaccine where id=?1";
    @Modifying
    @Query(nativeQuery = true,value=query4)
    void deleteFromDatabase(int id);
}