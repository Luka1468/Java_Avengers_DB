/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necajevl.luka1_owen2_a2.servlets;

import com.necajevl.luka1_owen2_a2.model.AvengerDb;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gunar
 */
public class GetAvengers extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
         
        AvengerDb avengers = new AvengerDb();
        
        request.setAttribute("avengers", avengers);
        
        RequestDispatcher rd = request.getRequestDispatcher("displayAvengers.jsp");
        
        rd.forward(request, response);
        
        
    }
    
    
}
