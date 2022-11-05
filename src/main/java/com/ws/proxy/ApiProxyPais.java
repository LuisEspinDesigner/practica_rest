package com.ws.proxy;


import com.ws.model.proxydto.ResultsDto;
import com.ws.model.proxydto.RootDto;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@RegisterRestClient(baseUri = "http://www.geognos.com/api/en/countries/")
public interface ApiProxyPais {

    @GET
    @Path("info/{code}.json")
    RootDto getPais(@PathParam("code")String code);
}
