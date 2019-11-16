/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.necajevl.luka1_owen2_a2.taghandlers;

import com.necajevl.luka1_owen2_a2.model.PowerSource;
import com.necajevl.luka1_owen2_a2.model.PowerSourceDb;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author oicr1
 */
public class PowerSourceHandler extends SimpleTagSupport {

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            
            PowerSourceDb ps = new PowerSourceDb();
            
            ArrayList<PowerSource> powerSources = ps.getPowerSources();
            
            out.print("<select name=\"powerSources\">");
            for (int i = 0; i < powerSources.size(); i++){
                out.print("<option value=''" + powerSources.get(i).getDescription() + 
                        ">" + powerSources.get(i).getDescription() + "</option>");
            }

            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in PowerSourceHandler tag", ex);
        } catch (Exception ex) {
            Logger.getLogger(PowerSourceHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
