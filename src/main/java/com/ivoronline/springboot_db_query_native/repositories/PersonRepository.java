package com.ivoronline.springboot_db_query_native.repositories;

import com.ivoronline.springboot_db_query_native.entities.Person;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {

  //=======================================================================================
  // SELECT
  //=======================================================================================

  //NO PARAMETERS
  @Query(nativeQuery = true, value = "SELECT * FROM PERSON WHERE NAME = 'John' AND AGE = 20")
  Person getJohn();

  //INDEXED PARAMETERS
  @Query(nativeQuery = true, value = "SELECT * FROM PERSON WHERE NAME = ?1 AND AGE = ?2")
  Person selectPersonByNameAgeIndexed(String name, Integer age);

  //NAMED PARAMETERS
  @Query(nativeQuery = true, value = "SELECT * FROM PERSON WHERE NAME = :name AND AGE = :parameterAge")
  Person selectPersonByNameAgeNamed(String name, @Param("parameterAge") Integer age);

  //RETURN LIST
  @Query(nativeQuery = true, value = "SELECT * FROM PERSON WHERE NAME = :name")
  List<Person> selectPersonsByName(String name);

  //=======================================================================================
  // UPDATE
  //=======================================================================================
  @Modifying
  @Query(nativeQuery = true, value = "UPDATE PERSON SET AGE = :newAge WHERE NAME = :name")
  Integer updatePersonsByName(String name, Integer newAge);

  //=======================================================================================
  // DELETE
  //=======================================================================================
  @Modifying
  @Query(nativeQuery = true, value = "DELETE FROM PERSON WHERE NAME = :name")
  Integer deletePersonsByName(String name);

  //=======================================================================================
  // INSERT
  //=======================================================================================
  @Modifying
  @Query(nativeQuery = true, value = "INSERT INTO PERSON (name, age) VALUES (:name, :age)")
  Integer insertPerson(String name, Integer age);

}
