package com.oguz.sample.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.cypher.query.SortOrder;
import org.springframework.context.annotation.Role;

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

    @Override
    public String toString () {
        return String.format("Person[id=%s, name='%s', surname='%s']", id,
                name, surname);
    }
}
