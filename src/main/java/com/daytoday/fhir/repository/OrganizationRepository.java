package com.daytoday.fhir.repository;

import com.daytoday.fhir.dao.Organization;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrganizationRepository extends CrudRepository<Organization, String> {

    @Query("select o from Organization o " +
            "where o.name = :organization_name")
    List<Organization> findByOrganizationName(@Param("organization_name") String organizationName);
}