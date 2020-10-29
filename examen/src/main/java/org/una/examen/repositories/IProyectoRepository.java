/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.examen.entities.Proyecto;
/**
 *
 * @author cordo
 */
public interface IProyectoRepository extends JpaRepository<Proyecto, Long>{
    
}
