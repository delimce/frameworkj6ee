/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siclhos.model.baremos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Complus Sistemas
 */
@Entity
@Table(name = "CL_TIPO_RECURSO")
public class ClTipoRecurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "TIPO_RECURSO")
    private String tipoRecurso;
    @Size(max = 30)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "COD_CLINICA")
    private String codClinica;
    @OneToMany(mappedBy = "tipoRecurso")
    private Collection<ClItemTipoBaremo> clItemTipoBaremoCollection;
    
    /////atributos propios (colocar estsos dos en cada clase de entidad)
    private BaremosDML objetoDatos; ///objeto de utility para base de datos
    private String table = (String) this.getClass().getAnnotation(Table.class).name(); ///tabla en bd
    
    public ClTipoRecurso() {
    }

    public ClTipoRecurso(String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    public ClTipoRecurso(String tipoRecurso, String codClinica) {
        this.tipoRecurso = tipoRecurso;
        this.codClinica = codClinica;
    }

    public String getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodClinica() {
        return codClinica;
    }

    public void setCodClinica(String codClinica) {
        this.codClinica = codClinica;
    }

    @XmlTransient
    public Collection<ClItemTipoBaremo> getClItemTipoBaremoCollection() {
        return clItemTipoBaremoCollection;
    }

    public void setClItemTipoBaremoCollection(Collection<ClItemTipoBaremo> clItemTipoBaremoCollection) {
        this.clItemTipoBaremoCollection = clItemTipoBaremoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoRecurso != null ? tipoRecurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClTipoRecurso)) {
            return false;
        }
        ClTipoRecurso other = (ClTipoRecurso) object;
        if ((this.tipoRecurso == null && other.tipoRecurso != null) || (this.tipoRecurso != null && !this.tipoRecurso.equals(other.tipoRecurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siclhos.model.baremos.ClTipoRecurso[ tipoRecurso=" + tipoRecurso + " ]";
    }
    
}
