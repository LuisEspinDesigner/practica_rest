package com.ws.services.mongo;

import com.ws.model.mongo.PaisEntity;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import org.bson.types.ObjectId;

import java.util.List;

public interface IPaisService  {

    List<PaisEntity> getAllPais();

    PaisEntity findById(ObjectId id);

    boolean savePais(PaisEntity paisEntity);

    PaisEntity updatePais(PaisEntity paisEntity,ObjectId id);
    PaisEntity findByName(String name);

}
