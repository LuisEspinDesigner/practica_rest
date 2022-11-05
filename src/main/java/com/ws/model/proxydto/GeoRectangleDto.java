package com.ws.model.proxydto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GeoRectangleDto {

    @JsonProperty("West")
    public double west;
    @JsonProperty("East")
    public double east;
    @JsonProperty("North")
    public double north;
    @JsonProperty("South")
    public double south;
}
