/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.examen.repositories.IProyectoRepository;
import org.una.examen.utils.MapperUtils;
import org.una.examen.utils.ServiceConvertionHelper;
import org.una.examen.dto.ProyectoDTO;
import org.una.examen.entities.Proyecto;
/**
 *
 * @author cordo
 */
@Service
public class ProyectoServiceImplementation implements IProyectoService{
    
    @Autowired
    private IProyectoRepository proyectoRepository;
 
    @Override
    @Transactional(readOnly = true)
    public Optional<List<ProyectoDTO>> findAll() {
        return ServiceConvertionHelper.findList(proyectoRepository.findAll(),ProyectoDTO.class);
    }
    
    @Override
    @Transactional
    public ProyectoDTO create(ProyectoDTO proyecto) {
        Proyecto proy = MapperUtils.EntityFromDto(proyecto, Proyecto.class);
        proy = proyectoRepository.save(proy);
        return MapperUtils.DtoFromEntity(proy, ProyectoDTO.class);
    }

    @Override
    public Optional<ProyectoDTO> update(ProyectoDTO proyecto, Long id) {
        if (proyectoRepository.findById(id).isPresent()) {
            Proyecto proy = MapperUtils.EntityFromDto(proyecto, Proyecto.class);
            proy = proyectoRepository.save(proy);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(proy, ProyectoDTO.class));
        } else {
            return null;
        } 
    }
    
    @Override
    public void delete(Long id) {
        proyectoRepository.deleteById(id);
    }
}
