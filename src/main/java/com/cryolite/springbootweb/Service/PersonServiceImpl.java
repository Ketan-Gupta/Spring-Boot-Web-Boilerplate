package com.cryolite.springbootweb.Service;

import com.cryolite.springbootweb.Dao.PersonRepository;
import com.cryolite.springbootweb.Model.Person;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.jvm.hotspot.debugger.SymbolLookup;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl {

    @Autowired
    PersonRepository personRepository;

    public Person getPersonByName(String name){
        if(Strings.isNotBlank(name)){
            return personRepository.findByName(name);
        }
        return null;
    }

    public Optional<Person> getPersonById(int id){
        if(id !=0 ){
            return personRepository.findById(id);
        }
        return null;
    }

    public Boolean createPerson(Person person){
        if(person.getName()!= null && person.getId()!=0){
            Person createdPerson = personRepository.save(person);
            if(createdPerson!=null){
                return true;
            }
        }
        return false;
    }

    public List<Person> extractAllPersons(){
        return personRepository.extractAllPersons();
    }

    public Boolean deletePerson(int id){
        try {
            personRepository.deleteById(id);
        }
        catch(Exception e){
            return false;
        }
        return true;
    }
}
