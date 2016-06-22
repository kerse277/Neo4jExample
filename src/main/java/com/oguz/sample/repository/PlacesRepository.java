package com.oguz.sample.repository;

import com.oguz.sample.model.Places;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by kerse on 20.06.2016.
 */
public interface PlacesRepository extends GraphRepository<Places> {

    Places findByName(String name);

    Places findByType (String type);
    @Query("MATCH p=((:Person{name: {startNode} })-[:WORK]-(r)) return r")
    Places workSearch(@Param("startNode") String startNode);

}
