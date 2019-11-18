/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necajevl.makesureitwork.servlet;

import com.necajevl.makesureitwork.model.AvengerDb;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Name:Luka Necajev, Owen Ross
 * Date: 11/16/2019
 * Course Code: PROG32758  
 * Class Name: GetAvengers
 * Program Description:
 * just shows the output of getting the avengers from the database done in the AvengerDb class, 
 * then forwards the file to display on a jsp
 * @author Gunar
 */
public class GetAvengers extends HttpServlet {
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {

            request.setAttribute("avengers", AvengerDb.getAvengers());

        } catch (ClassNotFoundException ex) {
            request.setAttribute("error", ex.toString());
        } catch (Exception ex) {
            request.setAttribute("error", ex.toString());
        } finally {
        RequestDispatcher rd = request.getRequestDispatcher("displayAvengers.jsp");
        rd.forward(request, response);
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
