package com.oguz.sample.repository;

import com.oguz.sample.relationshipmodel.FriendRelationship;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by kerse on 21.06.2016.
 */
public interface FriendRelationshipRepository extends GraphRepository<FriendRelationship> {
}
