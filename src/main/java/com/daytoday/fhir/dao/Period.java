package com.daytoday.fhir.dao;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Period {

    @Id
    @Column(name = "Identifier")
    private String id;

    @Column(name = "start")
    private Date start;

    @Column(name = "end")
    private Date end;
}