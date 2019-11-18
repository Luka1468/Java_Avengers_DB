/*
 * This Class is made to connect and execute the queries to send items into the database depending on the methods used
 * This class will have two methods to show all of the avengers from the database, and to also add an avenger into the database.
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
 * Name: Luka Necajev, Owen Ross
 * Date: 11/16/2019
 * Course Code: PROG32758  
 * Class Name: AvengerDb
 * Program Description:
 *  This Class is made to connect and execute the queries to send items into the database depending on the methods used
 * This class will have two methods to show all of the avengers from the database, and to also add an avenger into the database.
 * @author Gunar
 */
public class AvengerDb {

    public static int addAvenger(Avenger avenger) throws Exception {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement ps =null;


        try {
            // driver that would point to the postgres driver
            String driver = "org.postgresql.Driver";

            Class.forName(driver);

            //the connection url to get to the postgres database to Heroku
             String dbUrl = System.getenv("JDBC_DATABASE_URL");

            if (dbUrl != null && dbUrl.length() > 0) {
                conn = DBConnector.getConnection(driver, dbUrl);
            } else {
            //the connection url to get to the postgres database
            String connUrl = "jdbc:postgresql://localhost/";
            //the database name
            String database = "Assignment_2";
            //the username and password for pgAdmin
            String user = "postgres";
            String pass = "Lukanina22";
//            String pass = "gfBpPdcy9";

            //the connection string to point to the getConnection method in the DBConnector class

            conn = DBConnector.getConnection(driver, connUrl, database, user, pass);
            }

            // get the parameters from the form
            String sql = "INSERT INTO avengers (avengername, description, powersource)"
                    + " VALUES ( ?, ?, ?) ";
            


            // Create a statement and execute 
             ps= conn.prepareStatement(sql);
             
             ps.setString(1,avenger.getName());
             ps.setString(2,avenger.getDescription());
             ps.setInt(3, avenger.getPowerSource().getId());
             
//              rs = ps.executeQuery();
              
            int rowsAffected = ps.executeUpdate();
            //returning the rows affected to show the user the query worked
            return rowsAffected;

        } catch (ClassNotFoundException ex) {
            throw new Exception(ex.toString());
        } catch (SQLException ex) {
            throw new Exception(ex.toString());
        } finally {
            DBConnector.closeJDBCObjects(conn, stmt, rs);
        }
            
    }

    
    public static ArrayList<Avenger> getAvengers() throws Exception {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement ps =null;

        ArrayList<Avenger> avengers = new ArrayList<>();

        try {
            String driver = "org.postgresql.Driver";

            Class.forName(driver);

//              String dbUrl = System.getenv("JDBC_DATABASE_URL");
//
//            if (dbUrl != null && dbUrl.length() > 0) {
//                conn = DBConnector.getConnection(driver, dbUrl);
//            } else {
            String connUrl = "jdbc:postgresql://localhost/";
            String database = "Assignment_2";
            String user = "postgres";
            String pass = "Lukanina22";
//            String pass = "gfBpPdcy9";
            conn = DBConnector.getConnection(driver, connUrl, database, user, pass);
//            }
            // get the parameters from the form
            String sql = "SELECT * FROM avengers";
            // Create a statement and execute 
//            stmt = conn.createStatement();
            ps= conn.prepareStatement(sql);
            rs = ps.executeQuery();
//            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String name = rs.getString("avengername");
                String description = rs.getString("description");
                int powerSourceId = rs.getInt("powersource");
                PowerSource powerSource = PowerSourceDb.getPowerSource(powerSourceId);
                avengers.add(new Avenger(name, description, powerSource));
            }

        } catch (ClassNotFoundException ex) {
            throw new Exception(ex.toString());
        } catch (SQLException ex) {
            throw new Exception(ex.toString());
        } finally {
            DBConnector.closeJDBCObjects(conn, stmt, rs);
        }
        return avengers;
    }

}
