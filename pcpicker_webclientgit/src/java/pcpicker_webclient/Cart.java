/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpicker_webclient;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pcpicker.Component;

/**
 *
 * @author admin
 */
public class Cart extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet responseaaa
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
 

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
        HashMap list = getCartList();
        request.setAttribute("list", list);
        
    }
    
    private HashMap getCartList()
    {
        HashMap manuf = new HashMap();
        
        
        //todo -- get motherboard formfactor
        ShoppingCart sc = ShoppingCart.GetInstance();
        
        List<Component> components = sc.getList();
        
        for(int i = 0; i < components.size();i++)
            manuf.put(i, components.get(i));
        
        return manuf;
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
        
        String submit = (String) request.getAttribute("submit");
        //for(int i = 0; i < )
        if(submit.equals("Add to Cart"))
        {
            ShoppingCart instance = ShoppingCart.GetInstance();
            Component component = new Component();
            String compname = (String)request.getAttribute("compname");
            System.out.println("companme"+ compname);

            component.setCompName(compname);
            instance.addItem(component);
       
        }
        request.getRequestDispatcher("ShoppingCart.jsp").forward(request,response);
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
