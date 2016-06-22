package com.oguz.sample.repository;

import com.oguz.sample.model.Person;
import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by oguz on 18.06.2016.
 */
public interface PersonRepository extends GraphRepository<Person> {
    Person findByName(String name);

    @Query("MATCH (n:Person {name:'Oguz2'}) Return n")
    Person getPersonFromName(String name);



    @Query("MATCH (p:Person { name:'A1' }) RETURN p")
    Person metric ();

    @Query("MATCH (p:Person)-[r:'name']->(n:HOSPITAL)" +
            "RETURN p,n")
    String work ();

    @Query("MATCH p=((:Person{name:'A5'})-[:RELATIONSHIP*1..2]-(:Person{name:'A4'})) return p")
    List<Person> matchMetric();


}






