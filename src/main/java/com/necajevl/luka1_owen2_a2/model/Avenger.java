/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necajevl.luka1_owen2_a2.model;

import java.io.Serializable;

/**
 *
 * @author Gunar
 */
public class Avenger implements Serializable {    
    int id;
    String name;
    String description;
    PowerSource powerSource;
    
    Avenger(){}
    Avenger(int id,String name, String description, PowerSource powerSource){
    this.id=id;
    this.name=name;
    this.description=description;
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    






}
