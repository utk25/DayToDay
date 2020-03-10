package com.daytoday.fhir.repository;

import com.daytoday.fhir.dao.HumanName;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HumanNameRepository extends CrudRepository<HumanName, String> {

    @Query("select h from HumanName h " +
            "where h.prefix = :first_name and h.suffix = :last_name")
    List<HumanName> findByHumanName(@Param("first_name") String firstName,
                                  @Param("last_name") String lastName);
}