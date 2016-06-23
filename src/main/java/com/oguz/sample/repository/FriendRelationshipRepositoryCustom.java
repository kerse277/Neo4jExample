package com.oguz.sample.repository;

import com.oguz.sample.relationshipmodel.FriendRelationship;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by oguz on 23.06.2016.
 */
public interface FriendRelationshipRepositoryCustom {

 List<FriendRelationship> friendWay(int limit,  String startNode, String endNode, int length);

}
