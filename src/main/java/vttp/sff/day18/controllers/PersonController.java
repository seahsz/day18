package vttp.sff.day18.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;
import vttp.sff.day18.models.Person;
import vttp.sff.day18.services.PersonService;

@Controller
@RequestMapping
public class PersonController {

    @Autowired
    private PersonService personSvc;

    private static final String ATTR_PERSON = "person";

    private static final String ATTR_PERSON_LIST = "personList";

    @GetMapping("/person")
    public ModelAndView getPerson() {

        ModelAndView mav = new ModelAndView("person");
        mav.addObject(ATTR_PERSON, new Person());

        return mav;
    }

    @PostMapping("/person")
    public ModelAndView postPerson(
        @Valid Person person,
        BindingResult binding
    ) {

        ModelAndView mav = new ModelAndView();

        if(binding.hasErrors()) {
            mav.setViewName("person");
            return mav;            
        }

        personSvc.createPerson(person);
        List<Person> personList = personSvc.getPersonList();

        mav.setViewName("personListing");
        mav.addObject(ATTR_PERSON_LIST, personList);

        return mav;
    }
    
}
