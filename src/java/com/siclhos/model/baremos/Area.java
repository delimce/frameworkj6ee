/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siclhos.model.baremos;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author luis
 */
public class Area {
    
     private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "AREA")
    private String area;
    @Size(max = 30)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 2)
    @Column(name = "TIPO_AGRUPA")
    private String tipoAgrupa;
    @Size(max = 23)
    @Column(name = "CODIGO_CONTABLE")
    private String codigoContable;


     public Area() {
    }

    public Area(String area) {
        this.area = area;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoAgrupa() {
        return tipoAgrupa;
    }

    public void setTipoAgrupa(String tipoAgrupa) {
        this.tipoAgrupa = tipoAgrupa;
    }

    public String getCodigoContable() {
        return codigoContable;
    }

    public void setCodigoContable(String codigoContable) {
        this.codigoContable = codigoContable;
    }

    
}
