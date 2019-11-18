/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necajevl.makesureitwork.model;

import java.io.Serializable;

/**
 * Name:Luka Necajev, Owen Ross
 * Date: 11/16/2019
 * Course Code: PROG32758  
 * Class Name: PowerSource
 * Program Description:
 * This class would be used to define a PowerSource, it is used to create an object to store properties of the power source
 * @author Gunar
 */

public class PowerSource implements Serializable {
 //creating the variables to create avengers objects to store into the database.
    //these variables would define the columns of the database
    
    int id;
    String description;

    // since Serializable's are required to have an empty constructor
    public PowerSource() {
    }

   /**
    * creating a constructor to pass the variables to create the row in the database
    * @param id
    * @param description 
    */
    
    public PowerSource(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

 //getting the description of the power
    public String getDescription() {
        return description;
    }
    
    //setting the description if we decide to set the description
    public void setDescription(String description) {
        this.description = description;
    }
}
