package com.ws.controller;

import com.ws.mapper.MapperPais;
import com.ws.model.mongo.PaisEntity;
import com.ws.model.mongo.dto.PaisDto;
import com.ws.model.mongo.dto.ResponseSmsDto;
import com.ws.model.proxydto.RootDto;
import com.ws.proxy.ApiProxyPais;
import com.ws.services.mongo.IPaisService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/v1")
public class appController {

    @Inject
    @RestClient
    private ApiProxyPais apiProxyPais;

    @Inject
    private MapperPais mapperPais;

    @Inject
    private IPaisService paisService;

    @GET
    @Path("Pais/{code}")
    //@RolesAllowed("admin")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response paisCode(@PathParam("code") String code) {
        RootDto rootDto =apiProxyPais.getPais(code);
        if (rootDto.getResults() != null){
            PaisDto paisDto=mapperPais.toDto(rootDto);
            PaisEntity PE= paisService.findByName(paisDto.getName());
        if (PE== null){
                if (paisService.savePais(mapperPais.toEntity(paisDto)))
                    return Response.ok(paisDto).build();
            }
            return Response.ok(new ResponseSmsDto(PE.getName()+" ya se encuentra en MongoDB")).build();
        }
        return  Response.ok(new ResponseSmsDto("No se a encontrado coincidencias")).build();
        }

        @GET
        @Path("pais/mongo/allpais")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public List<PaisEntity> getPasesMongo(){

        return paisService.getAllPais();
        }
        @GET
        @RolesAllowed("")
        @Path("pais/nombre/{name}")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public Response paisName(@PathParam("name") String name){
        PaisEntity paisEntity = paisService.findByName(name);
        if (paisEntity!= null){

        }


        return Response.ok(paisEntity).build();
    }

}