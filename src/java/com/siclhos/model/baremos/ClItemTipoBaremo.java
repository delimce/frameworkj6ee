/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siclhos.model.baremos;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Complus Sistemas
 */
@Entity
@Table(name = "CL_ITEM_TIPO_BAREMO")
public class ClItemTipoBaremo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "COD_ARTICULO")
    private String codArticulo;
    @Size(max = 60)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "UNIDAD")
    private String unidad;
    @Size(max = 3)
    @Column(name = "NIVEL1")
    private String nivel1;
    @Size(max = 3)
    @Column(name = "NIVEL2")
    private String nivel2;
    @Size(max = 3)
    @Column(name = "NIVEL3")
    private String nivel3;
    @Size(max = 2)
    @Column(name = "COMPUESTO")
    private String compuesto;
    @Size(max = 1)
    @Column(name = "MONTO_VARIABLE")
    private String montoVariable;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COSTO")
    private BigDecimal costo;
    @Size(max = 8)
    @Column(name = "COD_USUARIO")
    private String codUsuario;
    @Size(max = 1)
    @Column(name = "ACTUALIZA_PRECIO")
    private String actualizaPrecio;
    @Column(name = "ORDEN_ARTICULO")
    private Integer ordenArticulo;
    @Size(max = 15)
    @Column(name = "COD_GENERICO")
    private String codGenerico;
    @Size(max = 1)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 20)
    @Column(name = "CODIGO_INV")
    private String codigoInv;
    @Size(max = 1)
    @Column(name = "IMPRIME_ETIQUETA")
    private String imprimeEtiqueta;
    @Column(name = "FACTOR_INV")
    private Integer factorInv;
    @Size(max = 1)
    @Column(name = "CANT_MODIFICABLE")
    private String cantModificable;
    @Size(max = 1)
    @Column(name = "DETALLAR_DESPACHO")
    private String detallarDespacho;
    @Size(max = 12)
    @Column(name = "COD_ARTICULO_REAL_INV")
    private String codArticuloRealInv;
    @JoinColumn(name = "TIPO_RECURSO", referencedColumnName = "TIPO_RECURSO")
    @ManyToOne
    private ClTipoRecurso tipoRecurso;
    @JoinColumn(name = "TIPO_BAREMO", referencedColumnName = "TIPO_BAREMO")
    @ManyToOne(optional = false)
    private ClTipoBare tipoBaremo;
    @JoinColumn(name = "COD_AGRUPACION_ANX_FAC", referencedColumnName = "TIPO_AGRUPACION")
    @ManyToOne
    private ClTipoAgrupacion codAgrupacionAnxFac;
    @JoinColumn(name = "BASE_CALCULO", referencedColumnName = "CODIGO")
    @ManyToOne
    private ClBaseCalculo baseCalculo;
    
    /////atributos propios (colocar estsos dos en cada clase de entidad)
    private BaremosDML objetoDatos; ///objeto de utility para base de datos
    private String table = (String) this.getClass().getAnnotation(Table.class).name(); ///tabla en bd
    
    public ClItemTipoBaremo() {
    }

    public ClItemTipoBaremo(String codArticulo) {
        this.codArticulo = codArticulo;
    }

    public ClItemTipoBaremo(String codArticulo, String unidad) {
        this.codArticulo = codArticulo;
        this.unidad = unidad;
    }

    public String getCodArticulo() {
        return codArticulo;
    }

    public void setCodArticulo(String codArticulo) {
        this.codArticulo = codArticulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getNivel1() {
        return nivel1;
    }

    public void setNivel1(String nivel1) {
        this.nivel1 = nivel1;
    }

    public String getNivel2() {
        return nivel2;
    }

    public void setNivel2(String nivel2) {
        this.nivel2 = nivel2;
    }

    public String getNivel3() {
        return nivel3;
    }

    public void setNivel3(String nivel3) {
        this.nivel3 = nivel3;
    }

    public String getCompuesto() {
        return compuesto;
    }

    public void setCompuesto(String compuesto) {
        this.compuesto = compuesto;
    }

    public String getMontoVariable() {
        return montoVariable;
    }

    public void setMontoVariable(String montoVariable) {
        this.montoVariable = montoVariable;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getActualizaPrecio() {
        return actualizaPrecio;
    }

    public void setActualizaPrecio(String actualizaPrecio) {
        this.actualizaPrecio = actualizaPrecio;
    }

    public Integer getOrdenArticulo() {
        return ordenArticulo;
    }

    public void setOrdenArticulo(Integer ordenArticulo) {
        this.ordenArticulo = ordenArticulo;
    }

    public String getCodGenerico() {
        return codGenerico;
    }

    public void setCodGenerico(String codGenerico) {
        this.codGenerico = codGenerico;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCodigoInv() {
        return codigoInv;
    }

    public void setCodigoInv(String codigoInv) {
        this.codigoInv = codigoInv;
    }

    public String getImprimeEtiqueta() {
        return imprimeEtiqueta;
    }

    public void setImprimeEtiqueta(String imprimeEtiqueta) {
        this.imprimeEtiqueta = imprimeEtiqueta;
    }

    public Integer getFactorInv() {
        return factorInv;
    }

    public void setFactorInv(Integer factorInv) {
        this.factorInv = factorInv;
    }

    public String getCantModificable() {
        return cantModificable;
    }

    public void setCantModificable(String cantModificable) {
        this.cantModificable = cantModificable;
    }

    public String getDetallarDespacho() {
        return detallarDespacho;
    }

    public void setDetallarDespacho(String detallarDespacho) {
        this.detallarDespacho = detallarDespacho;
    }

    public String getCodArticuloRealInv() {
        return codArticuloRealInv;
    }

    public void setCodArticuloRealInv(String codArticuloRealInv) {
        this.codArticuloRealInv = codArticuloRealInv;
    }

    public ClTipoRecurso getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(ClTipoRecurso tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    public ClTipoBare getTipoBaremo() {
        return tipoBaremo;
    }

    public void setTipoBaremo(ClTipoBare tipoBaremo) {
        this.tipoBaremo = tipoBaremo;
    }

    public ClTipoAgrupacion getCodAgrupacionAnxFac() {
        return codAgrupacionAnxFac;
    }

    public void setCodAgrupacionAnxFac(ClTipoAgrupacion codAgrupacionAnxFac) {
        this.codAgrupacionAnxFac = codAgrupacionAnxFac;
    }

    public ClBaseCalculo getBaseCalculo() {
        return baseCalculo;
    }

    public void setBaseCalculo(ClBaseCalculo baseCalculo) {
        this.baseCalculo = baseCalculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codArticulo != null ? codArticulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClItemTipoBaremo)) {
            return false;
        }
        ClItemTipoBaremo other = (ClItemTipoBaremo) object;
        if ((this.codArticulo == null && other.codArticulo != null) || (this.codArticulo != null && !this.codArticulo.equals(other.codArticulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.siclhos.model.baremos.ClItemTipoBaremo[ codArticulo=" + codArticulo + " ]";
    }
    
}
