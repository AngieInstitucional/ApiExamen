/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.services;

import java.util.List;
import java.util.Optional;
import org.una.examen.dto.TareaDTO;

/**
 *
 * @author cordo
 */
public interface ITareaService {
    
    public TareaDTO create(TareaDTO tarea);
    
    public Optional<TareaDTO> update(TareaDTO tarea, Long id);
    
    public void delete(Long id);
}
