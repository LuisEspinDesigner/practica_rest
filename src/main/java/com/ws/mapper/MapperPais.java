package com.ws.mapper;

import com.ws.model.mongo.PaisEntity;
import com.ws.model.mongo.dto.PaisDto;
import com.ws.model.proxydto.RootDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface MapperPais {

    @Mapping(target = "name",source = "rootDto.results.name")
    @Mapping(target = "capital",source = "rootDto.results.capital.name")
    @Mapping(target = "code",source = "rootDto.results.countryCodes.iso2")
    //@Mapping(target = "name",expression = "java(rootDto.getResults().getName())")
    //@Mapping(target = "capital",expression = "java(rootDto.getResults().getCapital().getName())")
    //@Mapping(target = "code",expression = "java(rootDto.getResults().getCountryCodes().getIso2())")
    PaisDto toDto(RootDto rootDto);
    PaisDto toDto(PaisEntity paisEntity);
    PaisEntity toEntity(PaisDto paisDto);
}
