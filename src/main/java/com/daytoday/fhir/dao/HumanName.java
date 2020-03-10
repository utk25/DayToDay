package com.daytoday.fhir.dao;

import com.daytoday.fhir.enums.NameUse;
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
@Table(name = "humanName")
public class HumanName {

    @Id
    @Column(name = "identifier")
    private String identifier;

    @Enumerated(EnumType.STRING)
    @Column(name = "nameUse")
    private NameUse use;

    @Column(name = "text")
    private String text;

    @Column(name = "family")
    private String family;

    @Column(name = "given")
    private String given;

    @Column(name = "prefix")
    private String prefix;

    @Column(name = "suffix")
    private String suffix;

    @OneToOne(targetEntity = Period.class)
    private Period period;
}