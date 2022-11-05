package com.ws.repository.mongo;

import com.ws.model.mongo.PaisEntity;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PaisRepository implements PanacheMongoRepository<PaisEntity> {
    public PaisEntity findByName(String name){
        return find("name", name).firstResult();
    }
}
