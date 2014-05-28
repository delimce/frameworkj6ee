/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siclhos.model.baremos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class ClTipoBare {
        
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoBaremo")
    //private Collection<ClItemTipoBaremo> clItemTipoBaremoCollection;
    @JoinColumn(name = "TIPO_AGRUPACION", referencedColumnName = "TIPO_AGRUPACION")
    //@ManyToOne
    private ClTipoAgrupacion tipoAgrupacion;
    //@JoinColumn(name = "AREA", referencedColumnName = "AREA")
    //@ManyToOne
    //private ClArea area;
    
    private static final long serialVersionUID = 1L;
    @Id
    //@Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "TIPO_BAREMO")
    private String tipoBaremo;
    @Size(max = 30)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 2)
    @Column(name = "EXC_DEF")
    private String excDef;
    @Size(max = 3)
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
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoBaremo")
    //@Size(max = 3)
    //@Column(name = "TIPO_AGRUPACION")
    //private String tipoAgrupacion;    
    @Column(name = "POR_SOBREGIRO")
    private Integer porSobregiro;
    @Column(name = "POR_DEPOSITO")
    private Integer porDeposito;
    @JoinColumn(name = "AREA", referencedColumnName = "AREA")
    private ClArea area;
    /**
     * *****mis atributos***
     */
    private BaremosDML objetoDatos; ///objeto de utility para base de datos
    private String table =(String) this.getClass().getAnnotation(Table.class).name(); ///tabla en bd

    /**
     * ******metodos*****
     */
    public ClTipoBare() {        
    }    
    
    public String getTipoBaremo() {
        return tipoBaremo;
    }

    public void setTipoBaremo(String tipoBaremo) {
        this.tipoBaremo = tipoBaremo;
    }
    /*
    public String getTipoAgrupacion() {
        return tipoAgrupacion;
    }

    public void setTipoAgrupacion(String tipoAgrupacion) {
        this.tipoAgrupacion = tipoAgrupacion;
    }
    */
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPorSobregiro() {
        return porSobregiro;
    }

    public void setPorSobregiro(Integer porSobregiro) {
        this.porSobregiro = porSobregiro;
    }

    public String getExcDef() {
        return excDef;
    }

    public void setExcDef(String excDef) {
        this.excDef = excDef;
    }

    public Integer getPorDeposito() {
        return porDeposito;
    }

    public void setPorDeposito(Integer porDeposito) {
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
    public ArrayList<ClTipoBare> getListaBaremo(String pTipobaremo) {

        ArrayList vectorBaremos = new ArrayList<>();

        try {
            objetoDatos = new BaremosDML();
            this.objetoDatos.consultaBaremo(pTipobaremo);

            if (this.objetoDatos.getNreg() > 0) {

                while (objetoDatos.getResult().next()) {

                    ClTipoBare b = new ClTipoBare();
                    b.setTipoBaremo(objetoDatos.getString("tipo_baremo"));
                    b.setDescripcion(objetoDatos.getString("DESC_TIPO_BAREMO"));
                    b.setManejoInv(objetoDatos.getString("manejo_inv"));
                    b.setOrdenBaremo((short) objetoDatos.getInteger("orden_baremo"));
                    ClTipoAgrupacion xagrupa = new ClTipoAgrupacion(objetoDatos.getString("TIPO_AGRUPACION"));
                    b.setTipoAgrupacion(xagrupa);                    
                    ClArea xarea = new ClArea(objetoDatos.getString("AREA"));
                    b.setArea(xarea);                    
                    b.setBaremoHab(objetoDatos.getString("BAREMO_HAB"));
                    b.setPorDeposito(objetoDatos.getInteger("POR_DEPOSITO"));
                    b.setPorSobregiro(objetoDatos.getInteger("POR_SOBREGIRO"));
                    b.setCodigo(objetoDatos.getString("CODIGO"));
                    b.setExcDef(objetoDatos.getString("EXC_DEF"));
                    b.setCentroCostos(objetoDatos.getString("CENTRO_COSTOS"));
                    vectorBaremos.add(b);
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClTipoBare.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objetoDatos.close();
        }    

        return vectorBaremos;
    }
    /* lista los baremo*/
    public List<ClTipoBare> ListaBaremos(){
	//ArrayList vectorBaremos = new ArrayList<>();
        List vectorBaremos = new ArrayList<>();    
        try {
            objetoDatos = new BaremosDML();
            this.objetoDatos.consultaBaremo();

            if (this.objetoDatos.getNreg() > 0) {

                while (objetoDatos.getResult().next()) {

                    ClTipoBare b = new ClTipoBare();
                    b.setTipoBaremo(objetoDatos.getString("tipo_baremo"));
                    b.setDescripcion(objetoDatos.getString("DESC_TIPO_BAREMO")); 
                    b.setManejoInv(objetoDatos.getString("manejo_inv"));
                    b.setOrdenBaremo((short) objetoDatos.getInteger("orden_baremo"));
                    ClTipoAgrupacion xagrupa = new ClTipoAgrupacion(objetoDatos.getString("TIPO_AGRUPACION"));
                    b.setTipoAgrupacion(xagrupa);
                    ClArea xarea = new ClArea(objetoDatos.getString("AREA"));
                    b.setArea(xarea);                    
                    b.setBaremoHab(objetoDatos.getString("BAREMO_HAB"));
                    b.setPorDeposito(objetoDatos.getInteger("POR_DEPOSITO"));
                    b.setPorSobregiro(objetoDatos.getInteger("POR_SOBREGIRO"));
                    b.setCodigo(objetoDatos.getString("CODIGO"));
                    b.setExcDef(objetoDatos.getString("EXC_DEF"));
                    b.setCentroCostos(objetoDatos.getString("CENTRO_COSTOS"));
                    vectorBaremos.add(b);
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClTipoBare.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objetoDatos.close();
        }    
        return vectorBaremos;
    }       
    /*
    @XmlTransient
    public Collection<ClItemTipoBaremo> getClItemTipoBaremoCollection() {
        return clItemTipoBaremoCollection;
    }

    public void setClItemTipoBaremoCollection(Collection<ClItemTipoBaremo> clItemTipoBaremoCollection) {
        this.clItemTipoBaremoCollection = clItemTipoBaremoCollection;
    }
    */
    public ClTipoAgrupacion getTipoAgrupacion() {
        return tipoAgrupacion;
    }

    public void setTipoAgrupacion(ClTipoAgrupacion tipoAgrupacion) {
        this.tipoAgrupacion = tipoAgrupacion;
    }
}
