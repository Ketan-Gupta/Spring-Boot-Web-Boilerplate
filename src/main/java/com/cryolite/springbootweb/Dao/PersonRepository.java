package com.cryolite.springbootweb.Dao;

import com.cryolite.springbootweb.Model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person,Integer> {
    public Person findByName(String name);

    @Query(value="Select * from PERSON", nativeQuery = true)
    public List<Person> extractAllPersons();
}
