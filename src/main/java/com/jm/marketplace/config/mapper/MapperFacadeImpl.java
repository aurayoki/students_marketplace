package com.jm.marketplace.config.mapper;

import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MapperFacadeImpl implements MapperFacade {

    private final MapperFactory mapperFactory;

    @Autowired
    public MapperFacadeImpl(MapperFactory mapperFactory) {
        this.mapperFactory = mapperFactory;
    }

    @Override
    public <S, D> List<D> mapAsList(Iterable<S> sourceObject, Class<D> classDestination) {
        return mapperFactory.getMapperFacade().mapAsList(sourceObject, classDestination);
    }

    @Override
    public <S, D> D map(S sourceObject, Class<D> classDestination) {
        return mapperFactory.getMapperFacade().map(sourceObject, classDestination);
    }

    @Override
    public <S, D> void map(S sourceObject, D destinationObject) {
        mapperFactory.getMapperFacade().map(sourceObject, destinationObject);
    }
}
