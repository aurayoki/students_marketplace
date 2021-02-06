package com.jm.marketplace.config.mapper;

import java.util.List;

public interface MapperFacade {
    <S, D> List<D> mapAsList(Iterable<S> sourceObject, Class<D> classDestination);
    <S, D> D map(S sourceObject, Class<D> classDestination);
    <S, D> void map(S sourceObject, D destinationObject);
}
