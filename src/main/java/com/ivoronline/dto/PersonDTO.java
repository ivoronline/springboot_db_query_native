package com.ivoronline.dto;

public class PersonDTO {

  //PROPERTIES
  public String  name;
  public Integer age;

  //CONSTRUCTORS
  public PersonDTO() { }                               //Forced by @Entity
  public PersonDTO(String name, Integer age) {         //To simplify PersonLoader
    this.name = name;
    this.age  = age;
  }

}
