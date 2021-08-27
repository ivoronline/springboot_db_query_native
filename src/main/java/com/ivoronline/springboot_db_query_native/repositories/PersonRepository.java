package com.ivoronline.springboot_db_query_native.repositories;

import com.ivoronline.springboot_db_query_native.entities.Person;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {

  //=======================================================================================
  // PARAMETERS
  //=======================================================================================
  //NO PARAMETERS
  @Query(value = "SELECT * FROM PERSON WHERE NAME = 'John' AND AGE = 20", nativeQuery = true)
  Person noParameters();

  //INDEXED PARAMETERS
  @Query(value = "SELECT * FROM PERSON WHERE NAME = ?1 AND AGE = ?2", nativeQuery = true)
  Person indexedParameters(String name, Integer age);

  //NAMED PARAMETERS
  @Query(value = "SELECT * FROM PERSON WHERE NAME = :name AND AGE = :parameterAge", nativeQuery = true)
  Person namedParameters(String name, @Param("parameterAge") Integer age);

  //=======================================================================================
  // SELECT
  //=======================================================================================
  //RETURN SINGLE ENTITY
  @Query(value = "SELECT * FROM PERSON WHERE NAME = :name AND AGE = :age", nativeQuery = true)
  Person selectPersonByNameAge(String name, Integer age);

  //RETURN LIST
  @Query(value = "SELECT * FROM PERSON WHERE NAME = :name", nativeQuery = true)
  List<Person> selectPersonsByName(String name);

  //=======================================================================================
  // UPDATE
  //=======================================================================================
  @Modifying
  @Transactional
  @Query(value = "UPDATE PERSON SET AGE = :newAge WHERE NAME = :name", nativeQuery = true)
  Integer updatePersonsByName(String name, Integer newAge);

  //=======================================================================================
  // DELETE
  //=======================================================================================
  @Modifying
  @Transactional
  @Query(value = "DELETE FROM PERSON WHERE NAME = :name", nativeQuery = true)
  Integer deletePersonsByName(String name);

  //=======================================================================================
  // INSERT
  //=======================================================================================
  @Modifying
  @Transactional
  @Query(value = "INSERT INTO PERSON (name, age) VALUES (:name, :age)", nativeQuery = true)
  Integer insertPerson(String name, Integer age);

}
