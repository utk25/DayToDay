package com.daytoday.fhir.service;

import com.daytoday.fhir.adapter.PersonModelConverter;
import com.daytoday.fhir.constants.Constants;
import com.daytoday.fhir.dao.HumanName;
import com.daytoday.fhir.dao.Organization;
import com.daytoday.fhir.dao.Person;
import com.daytoday.fhir.dto.request.PersonRequest;
import com.daytoday.fhir.dto.response.PersonInfo;
import com.daytoday.fhir.dto.response.PersonOrganizationResponse;
import com.daytoday.fhir.exception.OrganizationNotFound;
import com.daytoday.fhir.repository.HumanNameRepository;
import com.daytoday.fhir.repository.OrganizationRepository;
import com.daytoday.fhir.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private HumanNameRepository humanNameRepository;

    @Autowired
    private AddressService addressService;

    @Autowired
    private HumanNameService humanNameService;

    public PersonOrganizationResponse getAllPersons() {
        List<Person> persons = (List<Person>) personRepository.findAll();
        return createPersonResponse(persons);
    }

    public String createPerson(PersonRequest personRequest) {
        try {
            Organization managingOrganization = getOrganization(personRequest.getManagingOrganization());

            if (managingOrganization == null) {
                throw new OrganizationNotFound("Organization doesn't exist.");
            }

            Person person = PersonModelConverter.convertToDomainObject(personRequest);
            addressService.saveAddress(person.getAddress());
            humanNameService.saveHumanName(person.getName());
            personRepository.save(person);
            return person.getIdentifier();
        } catch (OrganizationNotFound e) {
            return Constants.ORGANIZATION_NOT_FOUND;
        } catch (Exception e) {
            return Constants.PERSON_SAVE_ERROR;
        }
    }

    public PersonOrganizationResponse findPerson(String firstName, String lastName, String organizationName) {
        List<HumanName> humanNames = humanNameRepository.findByHumanName(firstName, lastName);
        List<Organization> organizations = organizationRepository.findByOrganizationName(organizationName);

        Map<String, HumanName> humanNameIdToHumanName = formHumanNameIdToHumanName(humanNames);
        Map<String, Organization> organizationIdToOrganization = formOrganizationIdToOrganization(organizations);

        List<Person> persons = (List<Person>) personRepository.findAll();
        List<PersonInfo> personInfos = new ArrayList<>();

        for (Person person : persons) {
            if (humanNameIdToHumanName.containsKey(person.getName().getIdentifier()) &&
                organizationIdToOrganization.containsKey(person.getManagingOrganization())) {
                PersonInfo personInfo = PersonInfo.builder().person(person).
                        organization(organizationIdToOrganization.
                                get(person.getManagingOrganization())).build();
                personInfos.add(personInfo);
            }
        }
        return PersonOrganizationResponse.builder().personInfo(personInfos).build();
    }

    private PersonOrganizationResponse createPersonResponse(List<Person> persons) {
        List<PersonInfo> personInfos = new ArrayList<>();

        for (Person person : persons) {
            Organization managingOrganization = getOrganization(person.getManagingOrganization());
            PersonInfo personInfo = PersonInfo.builder().person(person).
                    organization(managingOrganization).build();
            personInfos.add(personInfo);
        }

        return PersonOrganizationResponse.builder().personInfo(personInfos).build();
    }

    private Organization getOrganization(String id) {
        Optional<Organization> organization = organizationRepository.findById(id);
        return organization.orElse(null);
    }

    private Map<String, Organization> formOrganizationIdToOrganization(List<Organization> organizations) {
        Map<String, Organization> map = new HashMap<>();
        for (Organization organization : organizations) {
            map.putIfAbsent(organization.getIdentifier(), organization);
        }
        return map;
    }

    private Map<String, HumanName> formHumanNameIdToHumanName(List<HumanName> humanNames) {
        Map<String, HumanName> map = new HashMap<>();
        for (HumanName humanName : humanNames) {
            map.putIfAbsent(humanName.getIdentifier(), humanName);
        }
        return map;
    }
}