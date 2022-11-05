package com.ws.services.mysql.impl;

import com.ws.model.mongo.PaisEntity;
import com.ws.model.mySql.PaisMysqlEntity;
import com.ws.repository.mysql.PaisRepositoryMySql;
import com.ws.services.mysql.IPaisServiceMySql;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Intercepted;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class PaisServiceMysql implements IPaisServiceMySql {

    @Inject
    private PaisRepositoryMySql paisRepositoryMySql;

    @Override
    public List<PaisMysqlEntity> getAllPais() {
        return paisRepositoryMySql.listAll();
    }

    @Override
    public PaisMysqlEntity findById(ObjectId id) {
        return null;
    }

    @Override
    public boolean savePais(PaisEntity paisEntity) {
        return false;
    }

    @Override
    public PaisMysqlEntity updatePais(PaisEntity PaisMysqlEntity, Long id) {
        return null;
    }


    @Override
    public PaisMysqlEntity findByName(String name) {
        return null;
    }
}
