package com.oguz.sample.repositoryperson;

import com.oguz.sample.model.Person;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by oguz on 18.06.2016.
 */
public class PersonRepositoryImpl implements PersonRepositoryCustom {

    @Autowired
    PersonRepository personRepository;

    @Override
    public Person customMethod(String name) {
        return personRepository.findByName(name);
    }
}
