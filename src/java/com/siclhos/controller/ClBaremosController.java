/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siclhos.controller;

import com.siclhos.model.baremos.ClArea;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Selectbox;

/**
 *
 * @author luis
 */
public class ClBaremosController extends SelectorComposer<Component> {

    private static final long serialVersionUID = 1L;
    ClArea area = new ClArea();

    ListModel<String> selectAreas = new ListModelList<>(area.listaAreas());

    @Wire
    private Selectbox comboAreas;

    /////metodos
    public ClBaremosController() {
        // initialize data

      //  comboAreas.setModel(typesModel);
    
    }

    public ListModel<String> getselectAreas() {
        return selectAreas;
    }
    
    
}
