/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpicker_webclient;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pcpicker.Order;
import pcpicker.OrderParts;
import pcpicker.Part;
import pcpicker_webclient.nonservlet.WebMethods;

/**
 *
 * @author admin
 */
public class AccountPage extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
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
        ShoppingCart.getCartSummary(request);
        int cust_id = Integer.parseInt((String)request.getSession().getAttribute("userid"));
        List<Order> orders = WebMethods.getOrderList(cust_id);
        request.setAttribute("orders", createOrderHashMap(orders));
        request.getRequestDispatcher("accountpage.jsp").forward(request, response);
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

    
    
     private HashMap createOrderHashMap( List<Order> op)
    {
        HashMap map = new HashMap();
        for(int i = 0; i < op.size(); i++)
        {
            Order o = op.get(i);
            HashMap items = new HashMap();
            
            items.put("1",o.getOrderId());
            items.put("2", o.getDateCreated());
            items.put("3", o.getPaymentType());
                    
            List<OrderParts> ops = WebMethods.getOrderItems(o.getOrderId());
            
            int numItems = ops.size();
            double totalPrice = 0;
            for(OrderParts orderParts : ops)
                totalPrice += orderParts.getQuantity() * orderParts.getPrice();
            
            
            items.put("4", numItems);
            items.put("5",totalPrice);
            
            
           
            
            map.put(Integer.toString(i), items);
        }
        return map;
    }
}
