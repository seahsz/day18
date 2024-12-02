package vttp.sff.day18.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp.sff.day18.models.Person;
import vttp.sff.day18.repositories.PersonRepo;

@Service
public class PersonService {

    @Autowired
    private PersonRepo personRepo;

    public void createPerson(Person person) {
        personRepo.rightPush("persons", person);
    }

    public List<Person> getPersonList() {
        return personRepo.getPersonList("persons");
    }
    
}
