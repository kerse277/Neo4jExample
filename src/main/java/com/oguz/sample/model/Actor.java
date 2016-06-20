package com.oguz.sample.model;

import lombok.experimental.Accessors;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.RelationshipEntity;

@RelationshipEntity(type = "Actor")
@Accessors(chain = true)
public class Actor {



}
