package com.ws.model.proxydto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

@Data
public class ResultsDto {

    @JsonProperty("Name")
    public String name;
    @JsonProperty("Capital")
    public CapitalDto capital;
    @JsonProperty("GeoRectangle")
    public GeoRectangleDto geoRectangle;
    @JsonProperty("SeqID")
    public int seqID;
    @JsonProperty("GeoPt")
    public ArrayList<Double> geoPt;
    @JsonProperty("TelPref")
    public String telPref;
    @JsonProperty("CountryCodes")
    public CountryCodesDto countryCodes;
    @JsonProperty("CountryInfo")
    public String countryInfo;
}
