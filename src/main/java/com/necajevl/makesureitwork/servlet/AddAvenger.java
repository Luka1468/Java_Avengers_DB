/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necajevl.makesureitwork.servlet;

import com.necajevl.makesureitwork.model.Avenger;
import com.necajevl.makesureitwork.model.AvengerDb;
import com.necajevl.makesureitwork.model.PowerSource;
import com.necajevl.makesureitwork.model.PowerSourceDb;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Name:Luka Necajev, Owen Ross
 * Date: 11/16/2019
 * Course Code: PROG32758  
 * Class Name: Add Avenger
 * Program Description:
 * This class will add your avenger to the database, and then display the amount of rows that were modified by you adding the avenger
 * if there is one, you have successfully completed it, if it is 0 you did not.
 * @author oicr1
 */
public class AddAvenger extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;

        try {

            out = response.getWriter();

            String avengerName = request.getParameter("name");
            String description = request.getParameter("description");
            int powerSourceId = Integer.parseInt(request.getParameter("powerSources"));

            PowerSource powerSource = PowerSourceDb.getPowerSource(powerSourceId);
//            ArrayList<Avenger> avengerArr = AvengerDb.getAvengers();
//            int id = avengerArr.size() + 1;
            // Ask prof about id
            Avenger avenger = new Avenger(avengerName, description, powerSource);

            int rowsAffected = AvengerDb.addAvenger(avenger);

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddAvenger</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + avengerName + " added succesfully!</h1>");
            out.println("<br>");
            out.print("<h2>Rows Affected: " + rowsAffected + "</h2>");
            out.print("<br>");
            out.println("<a href='index.html'>Back to index</a>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception ex) {
            out.print(ex.toString());
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
