package com.daytoday.fhir.service;

import com.daytoday.fhir.dao.Address;
import com.daytoday.fhir.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public void saveAddress(Address address) {
        addressRepository.save(address);
    }
}