package com.oguz.sample.relationshipmodel;

import com.oguz.sample.model.Person;
import com.oguz.sample.model.Places;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = "WORK")
@Accessors(chain = true)
public class WorkRelationship {

    @GraphId
    private Long id;

    @Getter
    @Setter
    private String workType;

    @Getter
    @Setter
    @StartNode
    private Person startNode;

    @Getter
    @Setter
    @EndNode
    private Places endNode;

    @Override
    public String toString () {
        return String.format("Relation[id=%s, startNode='%s', endNode='%s', type='%s']", id,
                startNode, endNode,workType);
    }
}
