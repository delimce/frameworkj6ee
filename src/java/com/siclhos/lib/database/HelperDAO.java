/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siclhos.lib.database;

import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author delimce
 */
public class HelperDAO extends Database {

    private static final String POOL = "SiclhosDS";
    protected String EntityTable; ///atributo de tabla fisica a la entidad
    protected List<String> columns; ////conjunto de campos para operaciones crud
    protected List<String> columnsWhere; ///columnas para clausulas where
    protected List<Object> values; ////conjunto de valores de los campos
    protected List<Object> valuesWhere; ////conjunto de valores de los campos where
    
    
    public HelperDAO() {

        this.getPool(POOL);
        this.connect();

    }

   public String getEntityTable() {
        return EntityTable;
    }

    /**
     * realiza el reseteo de las variables de columnas y valores
     */
    public void resetColumns() {

        this.columns = new ArrayList<>(); ///setiando los campos
        this.values = new ArrayList<>();
        this.columnsWhere = new ArrayList<>();
        this.valuesWhere = new ArrayList<>();
    }

    /**
     * hace el set de la tabla para realizar las operaciones crud sobre esta
     *
     * @param EntityTable
     */
    public void setEntityTable(String EntityTable) {
        this.EntityTable = EntityTable;
        resetColumns();

    }

    /**
     * Generate a String by Joining the Elements of Array, seperated By Glue
     *
     * @param glue The String to be placed between two array elements
     * @param Array The Array to be converted to String
     * @return String
     */
    public String Join(String glue, List Array) {
        String res = "";
        int i = 0;
        for (i = 0; i < Array.size() - 1; i++) {
            res = res + Array.get(i) + glue;
        }
        res = res + Array.get(i);
        return res;
    }

    /**
     * Generate a String of "repeat" repeted count times, seperated by glue
     *
     * @param glue The part which comes between the "repeat"
     * @param repeat The string to be repeted Count times
     * @param count The number of times "repeat" String is repeated
     * @return String Repeat(", ", "?", 3) = "?, ?" Repeat(", ", "Repeat", 3) =
     * "Repeat, Repeat, Repeat"
     */
    public String Repeat(String glue, String repeat, Integer count) {
        String res = "";
        int i = 0;
        for (i = 0; i < count - 1; i++) {
            res = res + repeat + glue;
        }
        res = res + repeat;
        return res;
    }

    /**
     * metodo que setea el nombre del campo y el valor (requerido para
     * insert,update,delete), recibe el nombre del campo en tabla y el valor
     * (debe ser objeto)
     *
     * @param name
     * @param obj
     */
    public void setColumn(String name, Object obj) {

        this.columns.add(name);
        this.values.add(obj);

    }

    public void setColumnWhere(String name, Object obj) {

        this.columnsWhere.add(name);
        this.valuesWhere.add(obj);

    }

    /**
     * hace el seting de la posicion del campo y el tipo de objeto a enviar
     *
     * @param obj
     * @param pos
     */
    protected void getObject(Object obj, int pos) {

        if (obj.getClass().equals(String.class)) {
            System.out.println("string");
            this.setString(pos, (String) obj);
        } else if (obj.getClass().equals(Integer.class)) {
            System.out.println("int");
            this.setInteger(pos, (Integer) obj);
        } else if (obj.getClass().equals(Short.class)) {
            System.out.println("short");
            this.setInteger(pos, (Integer) obj);
        } else if (obj.getClass().equals(Float.class)) {
            this.setFloat(pos, (Float) obj);
        } else if (obj.getClass().equals(Double.class)) {
            System.out.println("double");
            this.setDoble(pos, (Double) obj);
        }
    }

    /////metodos para CRUD
    public void dataInsert() {

        try {
            String tablename = this.getEntityTable();
            String sql = "insert into " + tablename + " (" + Join(", ", columns) + ") values (" + Repeat(", ", "?", columns.size()) + ")";
            System.out.println(sql);
            prepareTSQL(sql);

            for (int i = 0; i < columns.size(); i++) {
                getObject(values.get(i), i + 1);
            }

            tquery();
        } catch (SQLException ex) {
            Logger.getLogger(HelperDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void delete() {
        try {
            if (columnsWhere.size() < 1) { ///debe haber un criterio al menos
                System.out.println("IMPOSIBLE APLICAR OPERACION SIN UN CRITERIO");
                return;
            }

            String tablename = this.getEntityTable();
            String sql = "delete from " + tablename + " where ";
            int i;
            for (i = 0; i < columnsWhere.size() - 1; i++) {
                sql = sql + columnsWhere.get(i) + "=? and "; ///todo: hacer que agrupe por and/or
            }
            sql = sql + columnsWhere.get(i) + "=?";
            prepareTSQL(sql);
            for (i = 0; i < columnsWhere.size(); i++) {
                getObject(valuesWhere.get(i), i + 1);
            }
            tquery();
        } catch (SQLException ex) {
            Logger.getLogger(HelperDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void update() {

        try {
            if (columnsWhere.size() < 1) { ///debe haber un criterio al menos
                System.out.println("IMPOSIBLE APLICAR OPERACION SIN UN CRITERIO");
                return;
            }
            String tablename = this.getEntityTable();
            String sql = "update " + tablename + " set ";
            int i;
            for (i = 0; i < columns.size() - 1; i++) {
                sql += columns.get(i) + "=?,";
            }
            sql += columns.get(i) + "=? where ";
            for (i = 0; i < columnsWhere.size() - 1; i++) {
                sql += columnsWhere.get(i) + "=? and "; ///todo: hacer que agrupe por and/or
            }
            sql += columnsWhere.get(i) + "=?";

            System.out.println(sql);
            prepareTSQL(sql);
            /////mexclando vectores de valores para pasar los parametros
            List<List<Object>> mexcla = asList(this.values, this.valuesWhere);
            for (i = 0; i < mexcla.size(); i++) {
                System.out.println(mexcla.get(i));
                getObject(mexcla.get(i), i + 1);
            }
            tquery();
        } catch (SQLException ex) {
            Logger.getLogger(HelperDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
