/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siclhos.model.baremos;

import com.siclhos.lib.database.HelperDAO;
import java.sql.SQLException;

/**
 *
 * @author luis
 */
public class BaremosDML extends HelperDAO {

    public BaremosDML() {
        super();
    }

    /**
     * constructor del objeto paasndo la tabla (entidad a la que hace
     * referencia)
     *
     * @param tabla
     */
    public BaremosDML(String tabla) {
        super(tabla);
    }

    /**
     * trae todas las areas
     */
    public void consultaArea() throws SQLException {

        prepareSQL("select * from cl_area ");
        query();

    }

    /**
     * Consulta de un area especifica dado su codigo
     * @param area
     */
    public void consultaArea(ClArea area) throws SQLException {

        prepareSQL("select * from cl_area where area = ? ");
        setString(1, area.getArea());
        query();

    }

    /**
     * Consulta todos los baremos
     */
    public void consultaBaremo() throws SQLException {

        prepareSQL("select * from cl_baremo_vn");     
        query();

    }
    
    /**
     * Consulta de un baremo dado su codigo
     *
     * @param tipoBaremo
     */
    public void consultaBaremo(String tipoBaremo) throws SQLException {

        prepareSQL("select * from cl_baremo_vn where tipo_baremo = ? ");
        setString(1, tipoBaremo);
        query();

    }

}
