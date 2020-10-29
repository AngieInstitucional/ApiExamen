/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author cordo
 */
@Entity
@Table(name = "exa_acc_tareas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Tarea implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String nombre;
    
    @Column(length = 100)
    private String descripcion;

    @Column(name = "fecha_inicio"/*, updatable = false*/)
    @Temporal(TemporalType.TIMESTAMP)
  //  @Setter(AccessLevel.NONE)
    private Date fechaInicio;

    @Column(name = "fecha_finalizacion"/*, updatable = false*/)
    @Temporal(TemporalType.TIMESTAMP)
    //@Setter(AccessLevel.NONE)
    private Date fechaFinalizacion;

    @Column
    private Integer importancia;

    @Column
    private Integer urgencia;

    @Column(name = "porcentaje_avance")
    private Integer porcentajeAvance;

    @ManyToOne
    @JoinColumn(name = "proyecto")
    private Proyecto proyecto;
//
//    @PrePersist
//    public void prePersist() {
//        fechaInicio = new Date();
//        fechaFinalizacion = new Date();
//    }
//
//    @PreUpdate
//    public void preUpdate() {
//        fechaFinalizacion = new Date();
//    }
}
