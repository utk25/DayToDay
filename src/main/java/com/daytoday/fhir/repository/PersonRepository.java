package com.daytoday.fhir.repository;

import com.daytoday.fhir.dao.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, String> {
}