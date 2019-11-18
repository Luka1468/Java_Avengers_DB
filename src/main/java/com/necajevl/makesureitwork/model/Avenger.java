package com.necajevl.makesureitwork.model;

import java.io.Serializable;

/**
 *  Name:Luka Necajev, Owen Ross
 * Date: 11/16/2019
 * Course Code: PROG32758  
 * Class Name: Avenger
 * Program Description:
 * This class will be used to store the information of an Avenger
 * @author Gunar
 */
public class Avenger implements Serializable {
    //creating the variables to create avengers objects to store into the database.
    //these variables would define the columns of the database
    
    private int id;
    private String name;
    private String description;
    private PowerSource powerSource;

    /**
     * This is the no-arg construction because this class is a bean
     */
    
        // since Serializable's are required to have an empty constructor
    public Avenger() {
    }

    /**
     * This is the 3-arg constructor for the Avenger class
     * @param name the name of the Avenger
     * @param description a short description of the avenger
     * @param powerSource the power source of the avenger 
     */
    public Avenger(String name, String description, PowerSource powerSource) {
        if(name != null){
        this.name = name;
        }
        
        if(description != null){
          this.description = description;
        }
        
        if(powerSource !=null){
           this.powerSource = powerSource;
        }
    }

    /**
     * This will get the power source of the avenger
     * @return this method will return the avenger's power source
     */
    public PowerSource getPowerSource() {
        return powerSource;
    }

    /**
     * This will set the value of the powerSource data field when called
     * @param powerSource an instance of the PowerSource class
     */
    public void setPowerSource(PowerSource powerSource) {
        this.powerSource = powerSource;
    }
    
     //setting the Id for the table, would be automatically done in the table
    public void setId(int id) {
        this.id = id;
    }

    //getting the name of the Avenger
    public String getName() {
        return name;
    }

    //setting the Avengers name
    public void setName(String name) {
        this.name = name;
    }

    //getting the description of the power source
    public String getDescription() {
        return description;
    }

    //setting the description of the power source
    public void setDescription(String description) {
        this.description = description;
    }


}
