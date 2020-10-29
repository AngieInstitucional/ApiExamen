
package org.una.examen.utils;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class ServiceConvertionHelper {
    
    
    public static<D, E> Optional<List<D>> findList(final Collection<E> list, Class<D> dtoClass){
        if(list != null){
            List<D> lista = MapperUtils.DtoListFromEntityList(list, dtoClass);
            return Optional.ofNullable(lista);
        }
        return null;
    }
    
    public static<D, E> Optional<List<D>> findList(final Optional<Collection<E>> list, Class<D> dtoClass){
        if(list.isPresent()){
            return findList(list.get(), dtoClass);
        }
        return null;
    }
    public static<D, E> Optional<D> oneToOptionalDto(final Optional<E> one, Class<D> dtoClass){
        if(one.isPresent()){
            D oneDto = MapperUtils.DtoFromEntity(one.get(), dtoClass);
            return Optional.ofNullable(oneDto);
        }
        return null;
    }
    
    public static<D, E> D oneToDto(final Optional<E> one, Class<D> dtoClass){
        if(one.isPresent()){
            return MapperUtils.DtoFromEntity(one.get(), dtoClass);
        }
        return null;
    }
    
    public static<D, E> Optional<D> OptionalOneToOptionalDto(final Optional<E> one, Class<D> dtoClass){
        if(one.isPresent()){
            return Optional.ofNullable(MapperUtils.DtoFromEntity(one.get(), dtoClass));
        }
        return null;
    } 
}
