package com.oguz.sample.repository;

import com.oguz.sample.model.Places;
import com.oguz.sample.relationshipmodel.WorkRelationship;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by kerse on 21.06.2016.
 */
public interface WorkRelationshipRepository extends GraphRepository<WorkRelationship> {



    @Query("MATCH p =((:Person {name: {nodeName} })-[x:WORK]-()) return x")
    WorkRelationship findNodeWorkType(@Param("nodeName") String nodeName);

    WorkRelationship findByWorkType(String workType);


}

