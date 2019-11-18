/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necajevl.makesureitwork.model;

import com.necajevl.makesureitwork.db.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Name:Luka Necajev, Owen Ross
 * Date: 11/16/2019
 * Course Code: PROG32758  
 * Class Name: PowerSourceDb
 * Program Description:
 * This class is used for getting the powerSources from the Database and adding powersources into an array 
 * @author Gunar
 */
public class PowerSourceDb {

    public static PowerSource getPowerSource(int id) throws Exception {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement ps =null;
        PowerSource powerSource = null;

        try {
            String driver = "org.postgresql.Driver";

            Class.forName(driver);

              String dbUrl = System.getenv("JDBC_DATABASE_URL");

            if (dbUrl != null && dbUrl.length() > 0) {
                conn = DBConnector.getConnection(driver, dbUrl);
            } else {
            String connUrl = "jdbc:postgresql://localhost/";
            String database = "Assignment_2";
            String user = "postgres";
            String pass = "Lukanina22";
//            String pass = "gfBpPdcy9";
            conn = DBConnector.getConnection(driver, connUrl, database, user, pass);
            }
            // get the parameters from the form
            String sql = "SELECT * FROM powersource WHERE id = "
                    + id;

            // Create a statement and execute 
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            //if the power source is ID, get the value from the table with the specified id.
            if (rs.next()) {

                powerSource = new PowerSource(rs.getInt("id"), rs.getString("description"));
            }

        } catch (ClassNotFoundException ex) {
            throw new Exception(ex.toString());
        } catch (SQLException ex) {
            throw new Exception(ex.toString());
        } finally {
            DBConnector.closeJDBCObjects(conn, stmt, rs);
        }
        return powerSource;
    }

    public static ArrayList<PowerSource> getPowerSources() throws Exception {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement ps =null;

        ArrayList<PowerSource> powerSources = new ArrayList<>();

        try {
            String driver = "org.postgresql.Driver";

            Class.forName(driver);

              String dbUrl = System.getenv("JDBC_DATABASE_URL");

            if (dbUrl != null && dbUrl.length() > 0) {
                conn = DBConnector.getConnection(driver, dbUrl);
            } else {
            String connUrl = "jdbc:postgresql://localhost/";
            String database = "Assignment_2";
            String user = "postgres";
            String pass = "Lukanina22";
//            String pass = "gfBpPdcy9";
            conn = DBConnector.getConnection(driver, connUrl, database, user, pass);
            }
            // get the parameters from the form
            String sql = "SELECT * FROM powersource";

            // Create a statement and executing the prepaired statement
            ps= conn.prepareStatement(sql);
            
            rs = ps.executeQuery();
            
            
//            stmt = conn.createStatement();
//            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                powerSources.add(new PowerSource(rs.getInt("id"), rs.getString("description")));
            }

        } catch (ClassNotFoundException ex) {
            throw new Exception(ex.toString());
        } catch (SQLException ex) {
            throw new Exception(ex.toString());
        } finally {
            DBConnector.closeJDBCObjects(conn, stmt, rs);
        }
        return powerSources;
    }

}
