/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necajevl.luka1_owen2_a2.model;

import com.necajevl.luka1_owen2_a2.db.DBConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Gunar
 */
public class AvengerDb {
    
    private ArrayList<Avenger> avengers;

    public AvengerDb() throws Exception {
      

        try {
            String driver = "org.postgresql.Driver";

            Class.forName(driver);

            String connUrl = "jdbc:postgresql://localhost/";
            String database = "MyDb";
            String user = "postgres";
            String pass = "gfBpPdcy9";
            
           Connection conn = DBConnector.getConnection(driver, connUrl, database, user, pass);
            
            //Connection conn = DriverManager.getConnection(connUrl, user, pass);
            
            // get the parameters from the form
            String sql = "SELECT * FROM avengers a, powersource p"
                    + "WHERE a.id = p.id;";


            // Create a statement and execute 
           Statement stmt = conn.createStatement();
           ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

               avengers.add(new Avenger(rs.getInt("a.id"), rs.getString("a.avengername"),
              rs.getString("a.desvription"), new PowerSource(rs.getInt("p.id"),
              rs.getString("p.description"))));
            } 

        } catch (ClassNotFoundException ex) {
            throw new Exception(ex.toString());
        } catch (SQLException ex) {
            throw new Exception(ex.toString());
        }
    }

    
    public static int addUser() {
        // just making it return 0 for now so it complies
        return 0;
    }
    

    public ArrayList<Avenger> getAvengers() {
        return this.avengers;
    }

    public void setAvengers(ArrayList<Avenger> avengers) {
        this.avengers = avengers;
    }
    
}
    

