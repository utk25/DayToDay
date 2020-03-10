package com.daytoday.fhir.dao;

import com.daytoday.fhir.enums.AddressType;
import com.daytoday.fhir.enums.AddressUse;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "address")
public class Address {

    @Id
    @Column(name = "identifier")
    private String identifier;

    @Enumerated(EnumType.STRING)
    @Column(name = "addressUse")
    private AddressUse use;

    @Enumerated(EnumType.STRING)
    @Column(name = "addressType")
    private AddressType type;

    @Column(name = "text")
    private String text;

    @Column(name = "line")
    private String line;

    @Column(name = "city")
    private String city;

    @Column(name = "district")
    private String district;

    @Column(name = "state")
    private String state;

    @Column(name = "postalCode")
    private String postalCode;

    @Column(name = "country")
    private String country;

    @OneToOne(targetEntity = Period.class)
    private Period period;

}