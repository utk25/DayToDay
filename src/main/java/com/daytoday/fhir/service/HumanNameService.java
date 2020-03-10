package com.daytoday.fhir.service;

import com.daytoday.fhir.dao.HumanName;
import com.daytoday.fhir.repository.HumanNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HumanNameService {

    @Autowired
    private HumanNameRepository humanNameRepository;

    public void saveHumanName(HumanName humanName) {
        humanNameRepository.save(humanName);
    }
}