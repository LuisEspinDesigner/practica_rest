package com.ws.repository.mysql;

import com.ws.model.mySql.PaisMysqlEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;


import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PaisRepositoryMySql implements PanacheRepository<PaisMysqlEntity> {
}
