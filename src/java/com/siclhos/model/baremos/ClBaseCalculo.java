/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siclhos.model.baremos;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "CL_BASE_CALCULO")
public class ClBaseCalculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "CODIGO")
    private String codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "FACT_CONVERSION")
    private BigDecimal factConversion;
    @Size(max = 1)
    @Column(name = "BASE_DEFECTO")
    private String baseDefecto;
    @OneToMany(mappedBy = "baseCalculo")
    private Collection<ClItemTipoBaremo> clItemTipoBaremoCollection;
    
    /////atributos propios (colocar estsos dos en cada clase de entidad)
    private BaremosDML objetoDatos; ///objeto de utility para base de datos
    private String table = (String) this.getClass().getAnnotation(Table.class).name(); ///tabla en bd
    
    public ClBaseCalculo() {
    }

    public ClBaseCalculo(String codigo) {
        this.codigo = codigo;
    }

    public ClBaseCalculo(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getFactConversion() {
        return factConversion;
    }

    public void setFactConversion(BigDecimal factConversion) {
        this.factConversion = factConversion;
    }

    public String getBaseDefecto() {
        return baseDefecto;
    }

    public void setBaseDefecto(String baseDefecto) {
        this.baseDefecto = baseDefecto;
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
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClBaseCalculo)) {
            return false;
        }
        ClBaseCalculo other = (ClBaseCalculo) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siclhos.model.baremos.ClBaseCalculo[ codigo=" + codigo + " ]";
    }
    
}
