package com.ws.model.mongo.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class PaisDto {
    private String name;
    private String capital;
    private String code;
}
