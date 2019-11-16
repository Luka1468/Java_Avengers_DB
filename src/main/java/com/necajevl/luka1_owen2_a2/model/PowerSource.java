/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necajevl.luka1_owen2_a2.model;

/**
 *
 * @author Gunar
 */
public class PowerSource {
    int id;
    String description;
    
    PowerSource(){}
    PowerSource(int id,String description){
    this.id=id;
    this.description=description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
