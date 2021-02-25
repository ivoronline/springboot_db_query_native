package com.ivoronline.springboot_db_query_native.repositories;

import com.ivoronline.springboot_db_query_native.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {

  //NO PARAMETERS
  @Query(nativeQuery = true, value = "SELECT * FROM PERSON WHERE NAME='John' AND AGE=20")
  Person getJohn();

  //INDEXED PARAMETERS
  @Query(nativeQuery = true, value = "SELECT * FROM PERSON WHERE NAME=?1 AND AGE=?2")
  Person getPersonByNameAgeIndexed(String name, Integer age);

  //NAMED PARAMETERS
  @Query(nativeQuery = true, value = "SELECT * FROM PERSON WHERE NAME=:name AND AGE=:parameterAge")
  Person getPersonByNameAgeNamed(String name, @Param("parameterAge") Integer age);

  //RETURN LIST
  @Query(nativeQuery = true, value = "SELECT * FROM PERSON WHERE NAME=:name")
  List<Person> getPersonsByName(String name);

}
