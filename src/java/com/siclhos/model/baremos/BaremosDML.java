/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siclhos.model.baremos;

import com.siclhos.lib.database.HelperDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis
 */
public class BaremosDML extends HelperDAO {

    public BaremosDML() {
        super();
    }

    /**
     * constructor del objeto paasndo la tabla (entidad a la que hace referencia)
     * @param tabla
     */
     public BaremosDML(String tabla) {
        super(tabla);
    }
    
    /**
     * Consulta de un area especifica dado su codigo
     * @param area
     */
    public void consultaArea(String area) {

        try {
            prepareSQL("select * from cl_area where area = ? ");
            setString(1, area);
            query();

        } catch (SQLException ex) {
            Logger.getLogger(BaremosDML.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    /**
     * Consulta de un baremo dado su codigo
     * @param tipoBaremo 
     */
     public void consultaBaremo(String tipoBaremo) {

        try {
            prepareSQL("select * from cl_baremo_vn where tipo_baremo = ? ");
            setString(1, tipoBaremo);
            query();

        } catch (SQLException ex) {
            Logger.getLogger(BaremosDML.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    

}
