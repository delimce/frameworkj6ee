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
@Table(name = "CL_TIPO_AGRUPACION")
public class ClTipoAgrupacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "TIPO_AGRUPACION")
    private String tipoAgrupacion;
    @Size(max = 60)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 1)
    @Column(name = "FACT")
    private String fact;
    @Size(max = 1)
    @Column(name = "PRES")
    private String pres;
    @Size(max = 1)
    @Column(name = "ITEM")
    private String item;
    @Size(max = 12)
    @Column(name = "COD_ARTICULO")
    private String codArticulo;
    @Size(max = 1)
    @Column(name = "DETALLE")
    private String detalle;
    @Size(max = 1)
    @Column(name = "VISUALIZA_RUBRO")
    private String visualizaRubro;
    @Size(max = 1)
    @Column(name = "DETALLE_PRES")
    private String detallePres;
    @Size(max = 1)
    @Column(name = "DETALLE_ITEM")
    private String detalleItem;
    @Size(max = 1)
    @Column(name = "INFORME")
    private String informe;
    @Column(name = "COD_MEDICO")
    private Integer codMedico;
    @OneToMany(mappedBy = "codAgrupacionAnxFac")
    private Collection<ClItemTipoBaremo> clItemTipoBaremoCollection;
    @OneToMany(mappedBy = "tipoAgrupacion")
    private Collection<ClTipoBare> clTipoBareCollection;
    
    /////atributos propios (colocar estsos dos en cada clase de entidad)
    private BaremosDML objetoDatos; ///objeto de utility para base de datos
    private String table = (String) this.getClass().getAnnotation(Table.class).name(); ///tabla en bd
    
    public ClTipoAgrupacion() {
    }

    public ClTipoAgrupacion(String tipoAgrupacion) {
        this.tipoAgrupacion = tipoAgrupacion;
    }

    public String getTipoAgrupacion() {
        return tipoAgrupacion;
    }

    public void setTipoAgrupacion(String tipoAgrupacion) {
        this.tipoAgrupacion = tipoAgrupacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public String getPres() {
        return pres;
    }

    public void setPres(String pres) {
        this.pres = pres;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getCodArticulo() {
        return codArticulo;
    }

    public void setCodArticulo(String codArticulo) {
        this.codArticulo = codArticulo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getVisualizaRubro() {
        return visualizaRubro;
    }

    public void setVisualizaRubro(String visualizaRubro) {
        this.visualizaRubro = visualizaRubro;
    }

    public String getDetallePres() {
        return detallePres;
    }

    public void setDetallePres(String detallePres) {
        this.detallePres = detallePres;
    }

    public String getDetalleItem() {
        return detalleItem;
    }

    public void setDetalleItem(String detalleItem) {
        this.detalleItem = detalleItem;
    }

    public String getInforme() {
        return informe;
    }

    public void setInforme(String informe) {
        this.informe = informe;
    }

    public Integer getCodMedico() {
        return codMedico;
    }

    public void setCodMedico(Integer codMedico) {
        this.codMedico = codMedico;
    }

    @XmlTransient
    public Collection<ClItemTipoBaremo> getClItemTipoBaremoCollection() {
        return clItemTipoBaremoCollection;
    }

    public void setClItemTipoBaremoCollection(Collection<ClItemTipoBaremo> clItemTipoBaremoCollection) {
        this.clItemTipoBaremoCollection = clItemTipoBaremoCollection;
    }

    @XmlTransient
    public Collection<ClTipoBare> getClTipoBareCollection() {
        return clTipoBareCollection;
    }

    public void setClTipoBareCollection(Collection<ClTipoBare> clTipoBareCollection) {
        this.clTipoBareCollection = clTipoBareCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoAgrupacion != null ? tipoAgrupacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClTipoAgrupacion)) {
            return false;
        }
        ClTipoAgrupacion other = (ClTipoAgrupacion) object;
        if ((this.tipoAgrupacion == null && other.tipoAgrupacion != null) || (this.tipoAgrupacion != null && !this.tipoAgrupacion.equals(other.tipoAgrupacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siclhos.model.baremos.ClTipoAgrupacion[ tipoAgrupacion=" + tipoAgrupacion + " ]";
    }
    
}
