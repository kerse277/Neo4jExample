package com.oguz.sample.repository;

import com.oguz.sample.relationshipmodel.FriendRelationship;
import org.neo4j.ogm.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.data.neo4j.template.Neo4jTemplate;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by oguz on 23.06.2016.
 */
public class FriendRelationshipRepositoryImpl implements FriendRelationshipRepositoryCustom{

    private Neo4jOperations neo4jOperations;

    @Autowired
    public FriendRelationshipRepositoryImpl(Neo4jOperations neo4jTemplate){
        this.neo4jOperations = neo4jTemplate;
    }

    @Override
    public List<FriendRelationship> friendWay(int limit,  String startNode, String endNode, int length) {

        String query = "MATCH p=((:Person{name: {startNode} })-[:FRIEND*1.." + length +"]->(:Person{name: {endNode} })) return p limit {limit}";

        Map<String,Object> params = new HashMap<>();
        params.put("startNode", startNode);
        params.put("endNode", endNode);
        params.put("limit", limit);

        Result result = neo4jOperations.query(query, params);

        return null;
    }
}
