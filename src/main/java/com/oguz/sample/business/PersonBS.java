package com.oguz.sample.business;

import com.oguz.sample.model.Person;
import com.oguz.sample.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by oguz on 23.06.2016.
 */
@Service
public class PersonBS {
    @Autowired
    PersonRepository personRepository;


    Person person = new Person();

}
