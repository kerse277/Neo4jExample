package com.oguz.sample.repositoryperson;

import com.oguz.sample.model.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by oguz on 18.06.2016.
 */
public interface PersonRepository extends GraphRepository<Person> ,PersonRepositoryCustom {
    Person findByName(String name);

    /*@Query("MATCH (m:ENGINEER)<-[rating:RATED]-(person) WHERE name (m) = {ENGINEER} RETURN rating")
    Person lookup(String name);
    @Query(value = "start n=node({self}) match n-[:KNOWS]->other return other")
    Iterable<Person> friends;*/

}





