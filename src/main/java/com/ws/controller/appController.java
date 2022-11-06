package com.ws.controller;

import com.ws.mapper.MapperPais;
import com.ws.model.mongo.PaisEntity;
import com.ws.model.mongo.dto.PaisDto;
import com.ws.model.mongo.dto.ResponseSmsDto;
import com.ws.model.proxydto.RootDto;
import com.ws.proxy.ApiProxyPais;
import com.ws.services.mongo.IPaisService;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/v1")
@OpenAPIDefinition(
        info = @Info(
                title = "Este servicio es un crud que consume el Api de http://www.geognos.com/api/en/countries/info/all.json",
                version = "1.0.0",
                contact = @Contact(
                        name = "Luis Espin ",
                        url = "www.google.com",
                        email = "luis.espin2015@uteq.edu.ec"
                )
        )
)
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
    @APIResponse(responseCode = "200" )
    @APIResponseSchema(value = PaisEntity.class, responseCode = "200",responseDescription = "Extrae el pais segun el codigo Iso2 ")
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
        public Response getPasesMongo(){
        return Response.ok(paisService.getAllPais()).build();
        }

        @POST
        @Path("pais/mongo/update/{name}")
        @Produces(MediaType.APPLICATION_JSON)
        @Consumes(MediaType.APPLICATION_JSON)
        public PaisEntity getPasesMongo(@PathParam("name") String name,PaisEntity pais){
            return paisService.updatePais(pais,name);
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