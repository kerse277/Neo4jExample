package com.oguz.sample.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by oguz on 18.06.2016.
 */
@NodeEntity(label = "Person")
@Accessors(chain = true)
public class Person {

    @GraphId
    @Getter
    private Long id;

    @Getter
    @Setter
    private String tc;

    @Setter
    @Getter
    private String name;

    @Setter
    @Getter
    private String surname;

    @Getter
    @Setter
    private String gender;

    @Setter
    @Getter
    private String hoby;

    @Setter
    @Getter
    private String photo;

    @Getter
    @Setter
    private String occupation;

    //Work Relationship

    @Relationship(type = "WORK")
    private Set<Places> work = new HashSet<>();

    public Person work(Places places) {
        work.add(places);
        places.getPersons().add(this);
        return null;
    }

    //Friend Relationship

    @Relationship(type = "FRIEND")
    private Set<Person> friend = new HashSet<>();

    public Person friend(Person person) {
        friend.add(person);
        person.getFriend().add(this);
        return null;
    }


    @Relationship(type = "FRIEND")
    public Set<Person> getFriend() {
        return friend;
    }
}
