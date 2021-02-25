package com.ivoronline.springboot_db_query_native.controllers;

import com.ivoronline.springboot_db_query_native.entities.Person;
import com.ivoronline.springboot_db_query_native.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
public class MyController {

  @Autowired PersonRepository personRepository;

  //================================================================
  // SELECT JOHN
  //================================================================
  @ResponseBody
  @RequestMapping("/SelectJohn")
  public Person selectJohn() {
    Person john = personRepository.getJohn();
    return john;
  }

  //================================================================
  // SELECT PERSON BY NAME AGE INDEXED
  //================================================================
  @ResponseBody
  @RequestMapping("/SelectPersonByNameAgeIndexed")
  public Person selectPersonByNameAgeIndexed(@RequestParam String name, @RequestParam Integer age) {
    Person person = personRepository.selectPersonByNameAgeIndexed(name, age);
    return person;
  }

  //================================================================
  // SELECT PERSON BY NAME AGE NAMED
  //================================================================
  @ResponseBody
  @RequestMapping("/SelectPersonByNameAgeNamed")
  public Person selectPersonByNameAgeNamed(@RequestParam String name, @RequestParam Integer age) {
    Person person = personRepository.selectPersonByNameAgeNamed(name, age);
    return person;
  }

  //================================================================
  // SELECT PERSONS BY NAME
  //================================================================
  @ResponseBody
  @RequestMapping("/SelectPersonsByName")
  public List<Person> selectPersonsByName(@RequestParam String name) {
    List<Person> persons = personRepository.selectPersonsByName(name);
    return persons;
  }
  //================================================================
  // UPDATE PERSON BY NAME
  //================================================================
  @ResponseBody
  @Transactional
  @RequestMapping("/UpdatePersonsByName")
  public String updatePersonsByName(@RequestParam String name, @RequestParam Integer newAge) {
    Integer recordsUpdated = personRepository.updatePersonsByName(name, newAge);
    return recordsUpdated + " Records updated";
  }

  //================================================================
  // DELETE PERSON BY NAME
  //================================================================
  @ResponseBody
  @Transactional
  @RequestMapping("/DeletePersonsByName")
  public String deletePersonsByName(@RequestParam String name) {
    Integer recordsDeleted = personRepository.deletePersonsByName(name);
    return recordsDeleted + " Records deleted";
  }

  //=======================================================================================
  // INSERT IS NOT SUPPORTED BY JPA
  //=======================================================================================
  @ResponseBody
  @Transactional
  @RequestMapping("/InsertPerson")
  public String insertPerson(@RequestParam String name, @RequestParam Integer age) {
    Integer recordsDeleted = personRepository.insertPerson(name, age);
    return recordsDeleted + " Records inserted";
  }

}
