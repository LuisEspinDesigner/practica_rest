package com.ws.services.mysql;

import com.ws.model.mongo.PaisEntity;
import com.ws.model.mySql.PaisMysqlEntity;
import org.bson.types.ObjectId;

import java.util.List;

public interface IPaisServiceMySql {

    List<PaisMysqlEntity> getAllPais();

    PaisMysqlEntity findById(ObjectId id);

    boolean savePais(PaisEntity paisEntity);

    PaisMysqlEntity updatePais(PaisEntity PaisMysqlEntity,Long id);
    PaisMysqlEntity findByName(String name);
}
