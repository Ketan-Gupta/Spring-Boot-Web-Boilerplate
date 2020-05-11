package com.cryolite.springbootweb.Dao;

import com.cryolite.springbootweb.Model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person,Integer> {
}
