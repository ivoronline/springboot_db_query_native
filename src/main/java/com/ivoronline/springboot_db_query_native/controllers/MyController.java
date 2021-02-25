package com.ivoronline.springboot_db_query_native.controllers;

import com.ivoronline.springboot_db_query_native.entities.Person;
import com.ivoronline.springboot_db_query_native.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
public class MyController {

  @Autowired PersonRepository personRepository;

  //================================================================
  // GET JOHN
  //================================================================
  @ResponseBody
  @RequestMapping("/GetJohn")
  public Person getJohn() {
    Person john = personRepository.getJohn();
    return john;
  }

  //================================================================
  // GET PERSON BY NAME AGE INDEXED
  //================================================================
  @ResponseBody
  @RequestMapping("/GetPersonByNameAgeIndexed")
  public Person getPersonByNameAgeIndexed(@RequestParam String name, @RequestParam Integer age) {
    Person person = personRepository.getPersonByNameAgeIndexed(name, age);
    return person;
  }

  //================================================================
  // GET PERSON BY NAME AGE NAMED
  //================================================================
  @ResponseBody
  @RequestMapping("/GetPersonByNameAgeNamed")
  public Person getPersonByNameAgeNamed(@RequestParam String name, @RequestParam Integer age) {
    Person person = personRepository.getPersonByNameAgeNamed(name, age);
    return person;
  }

  //================================================================
  // GET PERSONS BY NAME
  //================================================================
  @ResponseBody
  @RequestMapping("/GetPersonsByName")
  public List<Person> getPersonsByName(@RequestParam String name) {
    List<Person> persons = personRepository.getPersonsByName(name);
    return persons;
  }

}
