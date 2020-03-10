package com.daytoday.fhir.repository;

import com.daytoday.fhir.dao.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, String> {
}