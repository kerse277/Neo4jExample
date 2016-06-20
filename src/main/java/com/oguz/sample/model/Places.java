package com.oguz.sample.model;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.RelationshipEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by oguz on 19.06.2016.
 */
@NodeEntity(label = "Places")
public class Places {

    @GraphId
    private Long id;
    private String title;

    @Relationship(type = "ACTED_IN", direction = "INCOMING")
    private Set<Person> actors = new HashSet<>();


    public Places(String title) {
        this.title = title;
    }

    @Relationship(type = "ACTED_IN", direction = "INCOMING")
    public Set<Person> getActors() {
        return actors;
    }
}
