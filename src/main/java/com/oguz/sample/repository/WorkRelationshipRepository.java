package com.oguz.sample.repository;

import com.oguz.sample.relationshipmodel.WorkRelationship;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by kerse on 21.06.2016.
 */
public interface WorkRelationshipRepository extends GraphRepository<WorkRelationship> {
}
