package com.ws.services.mongo.impl;

import com.ws.model.mongo.PaisEntity;
import com.ws.repository.mongo.PaisRepository;
import com.ws.services.mongo.IPaisService;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class PaisService implements IPaisService {

    @Inject
    private PaisRepository paisRepository;

    @Override
    public List<PaisEntity> getAllPais() {
        return paisRepository.listAll();
    }

    @Override
    public PaisEntity findById(ObjectId id) {
        return paisRepository.findById(id);
    }

    @Override
    public boolean savePais(PaisEntity paisEntity) {
        try {
            paisRepository.persist(paisEntity);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public PaisEntity updatePais(PaisEntity paisEntity, ObjectId id) {
        PaisEntity pais=paisRepository.findById(id);
        if (pais != null){
            paisRepository.update(paisEntity);
            return paisEntity;
        }
        return null;
    }

    @Override
    public PaisEntity findByName(String name) {

        PaisEntity paisEntity =  paisRepository.findByName(name);
        return paisEntity;
    }
}
