package com.ws.model.proxydto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.json.JsonArray;
import javax.json.JsonObject;
import java.io.Serializable;
import java.util.ArrayList;


@Data
public class RootDto {
    @JsonProperty("StatusMsg")
    public String statusMsg;
    @JsonProperty("Results")
    public ResultsDto results;
    @JsonProperty("StatusCode")
    public int statusCode;
}