/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankmisr.warehouse.Security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;

/**
 *
 * @author AhmedElsayed
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    private static final long serialVersionUID = -7858869558953243875L;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException e) throws IOException {

        final String expired = (String) request.getAttribute("expired");
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa   "+expired);
        
        
        //System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbb "+response.getHeader(expired));
        if (expired != null) {
//            response.setContentType("application/json");
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            response.getOutputStream().println("{ \"eqpired\": \"" + e.getMessage() + "\" }");
            com.bankmisr.warehouse.Security.ApiResponse responsee = new com.bankmisr.warehouse.Security.ApiResponse(301, expired);
            
            OutputStream out = response.getOutputStream();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(out, responsee);
            out.flush();

            // response.sendError(HttpServletResponse.SC_UNAUTHORIZED, expired);
        } else {
//            response.setContentType("application/json");
//            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//            response.getOutputStream().println("{ \"error is \": \"" + e.getMessage() + "\" }");
//            
             com.bankmisr.warehouse.Security.ApiResponse responsee = new com.bankmisr.warehouse.Security.ApiResponse(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
            
            OutputStream out = response.getOutputStream();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(out, responsee);
            out.flush();

            //  response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid Login details");
        }
    }

}
