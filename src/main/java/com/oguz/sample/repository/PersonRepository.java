package com.oguz.sample.repository;

import com.oguz.sample.model.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by oguz on 18.06.2016.
 */
public interface PersonRepository extends GraphRepository<Person> {
    Person findByName(String name);

    @Query("MATCH (n:Person {name:'Oguz2'}) Return n")
    Person getPersonFromName(String name);



}





