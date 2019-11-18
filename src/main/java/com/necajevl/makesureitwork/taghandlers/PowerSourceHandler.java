/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necajevl.makesureitwork.taghandlers;

import com.necajevl.makesureitwork.model.PowerSource;
import com.necajevl.makesureitwork.model.PowerSourceDb;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * Name:Luka Necajev, Owen Ross
 * Date: 11/16/2019
 * Course Code: PROG32758  
 * Class Name: PowerSourceDb
 * Program Description:
 * Will have all of the choices a user can choose when you are adding an avenger into the database
 * will implement the combobox and show powersources from the database.
 * 
 * @author oicr1
 */
public class PowerSourceHandler extends SimpleTagSupport {

    /**
    
     * Called by the container to invoke this tag.The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     *
     * @throws javax.servlet.jsp.JspException
     * @throws java.io.IOException
     */
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();

        try {

            ArrayList<PowerSource> powerSources = PowerSourceDb.getPowerSources();

            out.print("<select name='powerSources'>");
            for (int i = 0; i < powerSources.size(); i++) {
                out.print("<option value='" + powerSources.get(i).getId() + "'>"
                        + powerSources.get(i).getDescription() + "</option>");
            }
            out.print("</select>");

            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

        } catch (java.io.IOException ex) {
            throw new JspException("Error in PowerSourceHandler tag", ex);
        } catch (Exception ex) {
            out.print("<h1>An Error Has Occurred</h1>");
                out.print("<h2>" + ex.toString() + "</h2");
            } 
        }
    }


