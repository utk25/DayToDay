package com.daytoday.fhir.dao;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "organization")
public class Organization {

    @Id
    @Column(name = "identifier")
    private String identifier;

    @Column(name = "active")
    private boolean active;

    @Column(name = "name")
    private String name;

    @Column(name = "alias")
    private String alias;

    @OneToOne(targetEntity = Address.class)
    private Address address;
}