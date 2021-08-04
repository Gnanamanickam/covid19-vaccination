package com.covid.vaccination.repository;

import com.covid.vaccination.models.Receiver;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceiverRepository extends CrudRepository<Receiver,Integer> {

    String query1 = "select * from receiver";

    @Query(nativeQuery = true, value = query1)
    List<Receiver> getFromDatabase();

    String query2 = "insert into receiver values (?1,?2,?3,?4)";

    @Modifying
    @Query(nativeQuery = true, value = query2)
    void addTodatabse(String id, int user_id, int vaccine_id, int center_id);

    String query3 = "update receiver set user_id = ?2,center_id = ?3,vaccine_id = ?4 where id = ?1";

    @Modifying
    @Query(nativeQuery = true, value = query3)
    void updateDatabse(String id, int user_id, int center_id, int vaccine_id);

    String query4 = "delete from receiver where id = ?1";

    @Modifying
    @Query(nativeQuery = true, value = query4)
    void delete(String id);

    String complex_query3="select u.name from user u inner join \n" +
            "receiver r on u.ssn=r.user_id where r.receive_date between ?1 and ?2 group by u.name having count(r.receive_date)>=2";
    @Query(nativeQuery = true,value=complex_query3)
    List<String> getUsersReceivedVaccine(String start_date, String end_date);

    String complex_query4="select vc.county from receiver r inner join \n" +
            "user u on r.user_id=u.ssn inner join \n" +
            "vaccination_center vc on r.center_id=vc.id inner join\n" +
            "side_effects se on se.user_id=u.ssn group by vc.county order by count(side_effect) desc limit 1";
    @Query(nativeQuery = true,value=complex_query4)
    List<String> getCountyWithSIdeEffects();

    String complex_query5="select u.name from side_effects s inner join \n" +
            "user u on s.user_id=u.ssn inner join \n" +
            "vaccine v on s.vaccine_id=v.id\n" +
            "where s.side_effect='Body pain' and v.vaccine_name=?1 and s.duration>\n" +
            "(\n" +
            "select avg(sa.duration) from side_effects sa inner join vaccine va on sa.vaccine_id=va.id where va.vaccine_name=?1\n" +
            ")";
    @Query(nativeQuery = true,value=complex_query5)
    List<String> getNoUsers(String name);
}
