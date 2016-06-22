package com.oguz.sample.repository;

import com.oguz.sample.model.Person;
import com.oguz.sample.relationshipmodel.FriendRelationship;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by kerse on 21.06.2016.
 */
public interface FriendRelationshipRepository extends GraphRepository<FriendRelationship> {

    @Query("MATCH p=((:Person{name:{startNode}})-[:FRIEND|WORK*1..2]-(:Person{name:{endNode})) return p")
    List<FriendRelationship> matchMetric(@Param("startNode") String startNode,@Param("endNode") String endNode);


}
