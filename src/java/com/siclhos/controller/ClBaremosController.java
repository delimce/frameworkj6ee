/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siclhos.controller;

import com.siclhos.model.baremos.ClArea;
import com.siclhos.model.baremos.ClTipoAgrupacion;
import com.siclhos.model.baremos.ClTipoBare;
import java.util.Set;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Bandbox;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.ext.Selectable;

/**
 *
 * @author luis
 */
public class ClBaremosController extends SelectorComposer<Component> {

    private static final long serialVersionUID = 1L;
    ClArea area = new ClArea();

    ListModel<String> selectAreas = new ListModelList<>(area.listaAreas());
    
    public ListModel<String> getselectAreas() {
        return selectAreas;
    }
    
    @Wire
    private Combobox comboAreas;    
    @Wire
    private Listbox comboRubro; 
    @Wire
    private Textbox descriptionLabel;
    @Wire
    private Textbox agrupa;
    @Wire
    private Bandbox conbaremo;
    @Wire
    private Combobox comboInv; 
    @Wire
    private Combobox comboUBaremo;
    @Wire
    private Textbox orden;
    @Wire
    private Textbox cuentaconta;
    @Wire
    private Textbox deposito;
    @Wire
    private Textbox sobregiro;    
    @Wire
    private Radio  Cexceso;
    @Wire
    private Radio  Cdefecto;
    @Wire
    private Radio  ccs;
    @Wire
    private Radio  ccn;
    /////metodos
    public ClBaremosController() {
        // initialize data

      //  comboAreas.setModel(typesModel);
    
    }
    ClTipoBare tipoBare = new ClTipoBare();
        
    ListModel<ClTipoBare> allEvents = new ListModelList<>(tipoBare.ListaBaremos());
    
    public ListModel<ClTipoBare> getallEvents() {
        return allEvents;
    }   
    @Listen("onSelect = #comboRubro")
    public void showDetail(){
        Set<ClTipoBare> selection = ((Selectable<ClTipoBare>)comboRubro.getModel()).getSelection();
	if (selection!=null && !selection.isEmpty()){
            ClTipoBare selected = selection.iterator().next();		
            conbaremo.setValue(selected.getTipoBaremo());
            descriptionLabel.setValue(selected.getDescripcion()); 
            //ClTipoAgrupacion xagrupa = new ClTipoAgrupacion(selected.getTipoAgrupacion().toString());
            agrupa.setValue(selected.getTipoAgrupacion().toString());        
            //agrupa.setValue(selected.getTipoAgrupacion());                      
            selectAreas = new ListModelList<>(area.listaArea(selected.getArea()));             
            comboAreas.setModel(selectAreas);            
            comboAreas.setValue(area.listaArea(selected.getArea()).toString().replace("]", "").replace("[", ""));                                      
            if (selected.getManejoInv().contentEquals("N")) comboInv.setValue("NO");
            else comboInv.setValue("SI");                        
            if ("L".equals(selected.getBaremoHab())) comboUBaremo.setValue("Laboratorio");
            else if ("M".equals(selected.getBaremoHab())) comboUBaremo.setValue("Honorario Medico");
            else if ("Q".equals(selected.getBaremoHab())) comboUBaremo.setValue("Area Quirurgica");
            else if ("H".equals(selected.getBaremoHab())) comboUBaremo.setValue("Cargo de Habitacion");
            else comboUBaremo.setValue("Normal");   
            orden.setValue(selected.getOrdenBaremo().toString());  
            deposito.setValue(selected.getPorDeposito().toString());
            sobregiro.setValue(selected.getPorSobregiro().toString());
            cuentaconta.setValue(selected.getCodigo());
            if (selected.getExcDef().equals("D")) Cdefecto.setChecked(true);
            else Cexceso.setChecked(true);            
            if (selected.getCentroCostos().equals("N")) ccn.setChecked(true);
            else ccs.setChecked(true);            
            comboAreas.setReadonly(true);                    
            conbaremo.setReadonly(true);
            agrupa.setReadonly(true);
            conbaremo.close();
	}
    }         
}