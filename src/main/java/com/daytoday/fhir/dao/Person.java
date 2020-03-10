package com.daytoday.fhir.dao;

import com.daytoday.fhir.enums.AdministrativeGender;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "identifier")
    private String identifier;

    @OneToOne(targetEntity = HumanName.class)
    private HumanName name;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private AdministrativeGender gender;

    @Column(name = "birthDate")
    private Date birthDate;

    @OneToOne(targetEntity = Address.class)
    private Address address;

    @Column(name = "managingOrganization")
    private String managingOrganization;

}