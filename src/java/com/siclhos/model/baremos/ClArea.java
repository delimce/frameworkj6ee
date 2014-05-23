/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siclhos.model.baremos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author luis
 */
@Entity
@Table(name = "CL_AREA")
public class ClArea {

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

    /////atributos propios (colocar estsos dos en cada clase de entidad)
    private BaremosDML objetoDatos; ///objeto de utility para base de datos
    private String table = (String) this.getClass().getAnnotation(Table.class).name(); ///tabla en bd

    ///constructor por defecto 
    public ClArea() {

    }

    public ClArea(String area) {
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

    /**
     * retorna un arreglo con los nombres de las areas
     *
     * @return
     */
    public List<String> listaAreas() {

        ArrayList<String> areas = new ArrayList<>();
        try {

            objetoDatos = new BaremosDML(table);
            objetoDatos.consultaArea();
            if (objetoDatos.getNreg() > 0) {

                while (objetoDatos.getResult().next()) {

                    areas.add(objetoDatos.getString("DESCRIPCION"));

                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(ClArea.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objetoDatos.close();
        }

        return areas;
    }

    /**
     * crea una nueva area
     */
    public void insertarArea() {

        try {
            objetoDatos = new BaremosDML(table); ///asigna directamente la tabla
            // objetoDatos.setEntityTable(table);
            objetoDatos.setColumn("AREA", this.getArea());
            objetoDatos.setColumn("DESCRIPCION", this.getDescripcion());
            objetoDatos.dataInsert();
        } catch (SQLException ex) {
            Logger.getLogger(ClArea.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objetoDatos.close(); /////muy importante (libera la conexion y la entrega al pool)
        }

    }

    /**
     * borra un area
     *
     * @param area
     */
    public void borrarArea(String area) {

        try {
            objetoDatos = new BaremosDML();
            objetoDatos.setEntityTable(table);
            objetoDatos.setColumnWhere("AREA", area);
            objetoDatos.delete();

        } catch (SQLException ex) {
            Logger.getLogger(ClArea.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objetoDatos.close(); /////muy importante (libera la conexion y la entrega al pool)
        }

    }

    /**
     * modifica un area
     *
     * @param area
     */
    public void modificarArea(String area) {

        try {
            objetoDatos = new BaremosDML(table);
            objetoDatos.setColumn("DESCRIPCION", this.getDescripcion());
            // objetoDatos.setColumn("TIPO_AGRUPA", this.getTipoAgrupa());
            //////where
            objetoDatos.setColumnWhere("AREA", area);
            objetoDatos.update();
        } catch (SQLException ex) {
            Logger.getLogger(ClArea.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objetoDatos.close(); /////muy importante (libera la conexion y la entrega al pool)
        }

    }

    /**
     * ejemplo de ejecucion de 1 procedure
     *
     * @param input
     * @return
     */
    public String execr_prueba_ejecuta_prc(String input) {

        String salida = "";
        try {
            objetoDatos = new BaremosDML();
            objetoDatos.setProcedureName("r_prueba_bulk.r_prueba_ejecuta_prc");
            objetoDatos.setInParameter(input); //parametro de entrada 1
            objetoDatos.setInParameter("2");  //parametro de entrada 2
            objetoDatos.setInParameter(3);  //parametro de entrada 3
            objetoDatos.setOutString();  //parametro de salida 1
            objetoDatos.executeProcedure(); ///ejecucion

            salida = objetoDatos.getString(4);

        } catch (SQLException ex) {
            Logger.getLogger(ClArea.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objetoDatos.close(); /////muy importante (libera la conexion y la entrega al pool)
        }

        return salida;
    }

    public String BuscaTexto(String input) {
        String salida = "";
        try {
            objetoDatos = new BaremosDML();
            objetoDatos.setFunctionName("R_PRUEBA_BULK.busca_texto");
            objetoDatos.setOutString();
            objetoDatos.setInParameter("aaa"); //parametro de entrada 1
            objetoDatos.setInParameter("2");  //parametro de entrada 2
            objetoDatos.setInParameter(3);  //parametro de entrada 3            
            objetoDatos.executeFunction();

            salida = objetoDatos.getString(1);

        } catch (SQLException ex) {
            Logger.getLogger(ClArea.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objetoDatos.close(); /////muy importante (libera la conexion y la entrega al pool)
        }

        return salida;
    }
}
