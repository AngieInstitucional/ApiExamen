/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.examen.dto.TareaDTO;
import org.una.examen.repositories.ITareaRepository;
import org.una.examen.utils.MapperUtils;
import org.una.examen.entities.Tarea;

/**
 *
 * @author cordo
 */
@Service
public class TareaServiceImplementation implements ITareaService {

    @Autowired
    private ITareaRepository tareaRepository;

    @Override
    @Transactional
    public TareaDTO create(TareaDTO tarea) {
        Tarea ent = MapperUtils.EntityFromDto(tarea, Tarea.class);
        ent = tareaRepository.save(ent);
        return MapperUtils.DtoFromEntity(ent, TareaDTO.class);
    }

    @Override
    @Transactional
    public Optional<TareaDTO> update(TareaDTO tarea, Long id) {
        if (tareaRepository.findById(id).isPresent()) {
            Tarea ent = MapperUtils.EntityFromDto(tarea, Tarea.class);
            ent = tareaRepository.save(ent);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(ent, TareaDTO.class));
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        tareaRepository.deleteById(id);
    }
}
