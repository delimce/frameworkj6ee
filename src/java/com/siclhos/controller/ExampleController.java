package com.siclhos.controller;

import com.siclhos.model.baremos.ClArea;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zul.*;

public class ExampleController extends SelectorComposer<Component> {

    private static final long serialVersionUID = 1L;
    @Wire
    Textbox input;
    @Wire
    Label output;

    @Listen("onClick=#ok")
    public void submit() {

        ClArea area = new ClArea();
        output.setValue(area.execr_prueba_ejecuta_prc(input.getValue()));

        //      output.setValue(input.getValue());
    }

    @Listen("onClick=#cancel")
    public void cancel() {
        output.setValue("");
    }

    
     @Listen("onClick=#input")
    public void cancel2() {
       cancel();
       input.setText("");
    }
    
    
}
