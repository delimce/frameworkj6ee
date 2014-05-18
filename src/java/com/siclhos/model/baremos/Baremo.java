/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siclhos.model.baremos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author luis
 */
@Entity
@Table(name = "CL_TIPO_BARE")
public class Baremo {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "TIPO_BAREMO")
    private String tipoBaremo;
    @Size(max = 30)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "POR_SOBREGIRO")
    private Short porSobregiro;
    @Size(max = 1)
    @Column(name = "EXC_DEF")
    private String excDef;
    @Column(name = "POR_DEPOSITO")
    private Short porDeposito;
    @Size(max = 2)
    @Column(name = "CODIGO_CLASIFICACION")
    private String codigoClasificacion;
    @Size(max = 1)
    @Column(name = "BAREMO_HAB")
    private String baremoHab;
    @Size(max = 1)
    @Column(name = "CENTRO_COSTOS")
    private String centroCostos;
    @Size(max = 12)
    @Column(name = "CODIGO")
    private String codigo;
    @Column(name = "FECHA_CORTE")
    @Temporal(TemporalType.DATE)
    private Date fechaCorte;
    @Size(max = 1)
    @Column(name = "MANEJO_INV")
    private String manejoInv;
    @Size(max = 8)
    @Column(name = "COD_USUARIO")
    private String codUsuario;
    @Column(name = "ORDEN_BAREMO")
    private Short ordenBaremo;
    @Size(max = 3)
    @Column(name = "SUF_UNI_TRAB")
    private String sufUniTrab;
    @Size(max = 1)
    @Column(name = "EDO_CTA_DETALLADO")
    private String edoCtaDetallado;
    @Size(max = 3)
    @Column(name = "CATEGORIA_FACT")
    private String categoriaFact;
    @Size(max = 1)
    @Column(name = "REL_CONSUMO_DETALLA_COMP")
    private String relConsumoDetallaComp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoBaremo")

    private ClArea area;
    /**
     * *****mis atributos***
     */
    private BaremosDML objetoDatos;

    private String table;

    /**
     * ******metodos*****
     */
    public Baremo() {
        this.table = "CL_TIPO_BARE";
    }

    public String getTipoBaremo() {
        return tipoBaremo;
    }

    public void setTipoBaremo(String tipoBaremo) {
        this.tipoBaremo = tipoBaremo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Short getPorSobregiro() {
        return porSobregiro;
    }

    public void setPorSobregiro(Short porSobregiro) {
        this.porSobregiro = porSobregiro;
    }

    public String getExcDef() {
        return excDef;
    }

    public void setExcDef(String excDef) {
        this.excDef = excDef;
    }

    public Short getPorDeposito() {
        return porDeposito;
    }

    public void setPorDeposito(Short porDeposito) {
        this.porDeposito = porDeposito;
    }

    public String getCodigoClasificacion() {
        return codigoClasificacion;
    }

    public void setCodigoClasificacion(String codigoClasificacion) {
        this.codigoClasificacion = codigoClasificacion;
    }

    public String getBaremoHab() {
        return baremoHab;
    }

    public void setBaremoHab(String baremoHab) {
        this.baremoHab = baremoHab;
    }

    public String getCentroCostos() {
        return centroCostos;
    }

    public void setCentroCostos(String centroCostos) {
        this.centroCostos = centroCostos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFechaCorte() {
        return fechaCorte;
    }

    public void setFechaCorte(Date fechaCorte) {
        this.fechaCorte = fechaCorte;
    }

    public String getManejoInv() {
        return manejoInv;
    }

    public void setManejoInv(String manejoInv) {
        this.manejoInv = manejoInv;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public Short getOrdenBaremo() {
        return ordenBaremo;
    }

    public void setOrdenBaremo(Short ordenBaremo) {
        this.ordenBaremo = ordenBaremo;
    }

    public String getSufUniTrab() {
        return sufUniTrab;
    }

    public void setSufUniTrab(String sufUniTrab) {
        this.sufUniTrab = sufUniTrab;
    }

    public String getEdoCtaDetallado() {
        return edoCtaDetallado;
    }

    public void setEdoCtaDetallado(String edoCtaDetallado) {
        this.edoCtaDetallado = edoCtaDetallado;
    }

    public String getCategoriaFact() {
        return categoriaFact;
    }

    public void setCategoriaFact(String categoriaFact) {
        this.categoriaFact = categoriaFact;
    }

    public String getRelConsumoDetallaComp() {
        return relConsumoDetallaComp;
    }

    public void setRelConsumoDetallaComp(String relConsumoDetallaComp) {
        this.relConsumoDetallaComp = relConsumoDetallaComp;
    }

    public ClArea getArea() {
        return area;
    }

    public void setArea(ClArea area) {
        this.area = area;
    }

    /**
     * *************metodos propios***************
     */
    public ArrayList<Baremo> getListaBaremo(String pTipobaremo) {

        objetoDatos = new BaremosDML();
        this.objetoDatos.consultaBaremo(pTipobaremo);

        ArrayList vectorBaremos = new ArrayList<>();

        if (this.objetoDatos.getNreg() > 0) {

            try {
                while (objetoDatos.getResult().next()) {

                    Baremo b = new Baremo();
                    b.setTipoBaremo(objetoDatos.getString("tipo_baremo"));
                    b.setDescripcion(objetoDatos.getString("desc_tipo_baremo"));
                    b.setManejoInv(objetoDatos.getString("manejo_inv"));
                    b.setOrdenBaremo((short) objetoDatos.getInteger("orden_baremo"));
                    vectorBaremos.add(b);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Baremo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return vectorBaremos;

    }

}
