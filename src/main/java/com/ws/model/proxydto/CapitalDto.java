package com.ws.model.proxydto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class CapitalDto {

    @JsonProperty("DLST")
    public String dLST;
    @JsonProperty("TD")
    public double tD;
    @JsonProperty("Flg")
    public int flg;
    @JsonProperty("Name")
    public String name;
    @JsonProperty("GeoPt")
    public ArrayList<Double> geoPt;
}