/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.aula4po.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sabrina
 */
@WebServlet(name = "MathServlet", urlPatterns = {"/math.html"})
public class MathServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String paramN1 = request.getParameter("n1");
            String paramN2 = request.getParameter("n2");
            String operator = request.getParameter("operator");
            
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MathServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form action='math.html' method='GET'>");
            out.println("<label>Primeiro Número:</label>");
            out.println("<input type='text' name='n1'/>");
            out.println("<label>Segundo Número:</label>");
            out.println("<input type='text' name='n2'/>");
            out.println("<br>");
            out.println("<input type='radio' name='operator' value='+'/>");
            out.println("<label>Somar</label>");
            out.println("<input type='radio' name='operator' value='-'/>");
            out.println("<label>Subtrair</label>");
            out.println("<input type='radio' name='operator' value='*'/>");
            out.println("<label>Multiplicar</label>");
            out.println("<input type='radio' name='operator' value='/'/>");
            out.println("<label>Dividir</label>");
            out.println("<br>");
            out.println("<button type='submit'>Calcular</button>");
            out.println("</form>");
            out.println("<hr/>");
            if (paramN1 != null && paramN2 != null && operator != null) {
                out.println("<h3>Resultado: " + calculate(Double.parseDouble(paramN1), Double.parseDouble(paramN2), operator) + "</h3>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    private static double calculate(double n1, double n2, String operator) {
        switch (operator) {
            case "+":
                return n1 + n2;
            case "-":
                return n1 - n2;
            case "*":
                return n1 * n2;
            case "/":
                return n1 / n2;
            default:
                throw new IllegalArgumentException("Operador Inválido");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
    }

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
        processRequest(request, response);
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
