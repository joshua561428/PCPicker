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
import pcpicker.Order;
import pcpicker.OrderParts;
import pcpicker.Part;
import pcpicker_webclient.nonservlet.Cart;
import pcpicker_webclient.nonservlet.WebMethods;

/**
 *
 * @author admin
 */
public class OrderPage extends HttpServlet {

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
        
        Integer orderid = getOrderId(request);
        List<OrderParts> op = WebMethods.getOrderItems(orderid);
        HashMap opmap = createOrderPartHashMap(op);
        double totalprice = calculateTotalPrice(op);
        
        
        request.setAttribute("totalprice",totalprice);
        request.setAttribute("orderid",orderid);
        request.setAttribute("orderitems", opmap);
        request.getRequestDispatcher("/orderpage.jsp").forward(request,response);
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
    
    
    private Integer getSelectedOrder(HttpServletRequest request)
    {
        int numListItems = Integer.parseInt((String)request.getParameter("orderLength"));
        String[] orderIds = request.getParameterValues("orderid");
        Integer orderId = null;
        //System.out.println("********************************");
        //System.out.println("numlistitems " + numListItems);
        for(int i = 0; i < numListItems; i++)
        {
            String is = Integer.toString(i);            
            String submit = (String) request.getParameter("submit" + is);
            if(submit!=null)
            {               
                System.out.println("IS" + is);
                orderId = Integer.parseInt(orderIds[i]);   
                break;
            }
        }
        return orderId;
    }
     
    private Integer getOrderId(HttpServletRequest request)
    {
        Integer orderid = SessionMessage.getInt(request);
        
        if(orderid == null)        
            orderid=  getSelectedOrder(request);
        return orderid;
    }
    
    private HashMap createOrderPartHashMap( List<OrderParts> op)
    {
        HashMap map = new HashMap();
        for(int i = 0; i < op.size(); i++)
        {
            OrderParts o = op.get(i);
            HashMap items = new HashMap();
            
            items.put("1",o.getPartId());
            items.put("2",o.getQuantity());
            Part part = WebMethods.getPart(o.getPartId());
            items.put("3",part.getPartName());
            items.put("4",part.getPartPrice());
            
            map.put(Integer.toString(i), items);
        }
        return map;
    }

    private double calculateTotalPrice(List<OrderParts> op) {
        double total=0;
        for(OrderParts o : op)
        {
            total += o.getQuantity() * o.getPrice();
        }
        return total;
    }

}
