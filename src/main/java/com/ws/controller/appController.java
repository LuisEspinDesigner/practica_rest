package com.ws.controller;

import com.aayushatharva.brotli4j.decoder.DecoderJNI;
import com.ws.mapper.MapperPais;
import com.ws.model.mongo.PaisEntity;
import com.ws.model.mongo.dto.PaisDto;
import com.ws.model.proxydto.RootDto;
import com.ws.proxy.ApiProxyPais;
import com.ws.services.mongo.IPaisService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
        }
        return Response.noContent().build();
    }
    @GET
        @Path("pais/nombre/{name}")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
     public Response paisName(@PathParam("name") String name){
        PaisEntity paisEntity = paisService.findByName(name);
        //System.out.println(paisEntity.toString());
        System.out.println(paisEntity.getName());
        return Response.ok(paisEntity).build();
    }

}