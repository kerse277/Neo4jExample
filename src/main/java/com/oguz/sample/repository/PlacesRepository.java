package com.oguz.sample.repository;

import com.oguz.sample.model.Places;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by kerse on 20.06.2016.
 */
public interface PlacesRepository extends GraphRepository<Places> {
}
