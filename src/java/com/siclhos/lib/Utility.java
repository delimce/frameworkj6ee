/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.siclhos.lib;

import java.rmi.server.UID;

/**
 * clase de utilidades para ser llamada de forma estatica
 * @author luis de lima
 */
public class Utility {
    
    /**
     * genera una cadena representativa tipo UUID
     * @return 
     */
    static String generateUUID(){
        UID id = new UID();
        return id.toString();
    }
    
    
}
