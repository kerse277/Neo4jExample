package com.oguz.sample.repository;

import com.oguz.sample.relationshipmodel.FriendRelationship;
import org.neo4j.ogm.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;

import java.sql.ResultSet;
import java.util.*;

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

        List<FriendRelationship> list = new ArrayList<FriendRelationship>();

        for (FriendRelationship friendRelationship:neo4jOperations.queryForObjects(FriendRelationship.class,query,params)){
            list.add(friendRelationship);
        }
        return list;
    }
}
