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
import pcpicker.Part;
import pcpicker.Processor;
import pcpicker_webclient.nonservlet.Cart;
import pcpicker_webclient.nonservlet.CartItem;
import pcpicker_webclient.nonservlet.WebMethods;

/**
 *
 * @author admin
 */
public class ShoppingCart extends HttpServlet {

    final int ADD = 1;
    final int REMOVE = 2;
    final int UPDATE = 3;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cart cart = getCart(request);
        getCartSummary(request);
        
        SessionMessage.getMessage(request);
        
        
        
        request.setAttribute("totalPrice", cart.getTotalPrice());
        request.setAttribute("componentType", request.getParameter("componentType"));
        request.setAttribute("cart",createCartHashMap(cart));
        request.getRequestDispatcher("ShoppingCart.jsp").forward(request,response);
    }
    
    
 
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cart cart = getCart(request);
        Part part = getSelectedPart(request);
        if(getSubmitValue(request) == ADD)
            cart.add(part, 1);
            
        else 
        {
            cart.remove(part);
        }
        
        request.getSession().setAttribute("cart", cart);
        doGet(request,response);
    }
    
    private static Cart getCart(HttpServletRequest request)
    {
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        if(cart==null)
            cart = new Cart();
        System.out.print("getcart quantity " + cart.numItems + "    " + cart.getList().size());
        
        return cart;
    }
    
    private Part getSelectedPart(HttpServletRequest request)
    {
        int numListItems = Integer.parseInt((String)request.getParameter("numListItems"));
        String[] partIds = request.getParameterValues("partid");
        String partid = "";
        //System.out.println("********************************");
        //System.out.println("numlistitems " + numListItems);
        for(int i = 0; i < numListItems; i++)
        {
            String is = Integer.toString(i);            
            String submit = (String) request.getParameter("submit" + is);
            if(submit!=null)
            {               
                partid = partIds[i];              
               
                break;
            }
        }
        //System.out.println("----------------partid= "+ partid);    
        Part a = WebMethods.getPart(partid);
        System.out.println("submitPart"+a.getPartId());
        
        return WebMethods.getPart(partid);
    }
   
    private HashMap createCartHashMap(Cart cart)
    {
        HashMap map = new HashMap();
        for(int i = 0; i < cart.numItems; i++)
        {
            HashMap items = new HashMap();
            items.put("1",cart.getList().get(i).part.getPartId());
            items.put("2",cart.getList().get(i).part.getPartName());
            items.put("3",Double.toString(cart.getList().get(i).part.getPartPrice()));
            items.put("4",Integer.toString(cart.getList().get(i).quantity));
            
            map.put(Integer.toString(i), items);
        }
        System.out.println("cart quantity: " + cart.numItems);
        return map;
    }
    
    
    private int getSubmitValue(HttpServletRequest request)
    {
        int numListItems = Integer.parseInt((String)request.getParameter("numListItems"));
        String[] partIds = request.getParameterValues("partid");
        String partid = "";
        int sv=0;
        for(int i = 0; i < numListItems; i++)
        {
            String is = Integer.toString(i);            
            String submit = (String) request.getParameter("submit" + is);
            if(submit!=null)
            {               
                  
                if(submit.equals("Add to Cart")) 
                    sv = ADD;
                else 
                {
                    System.out.println("REMOVE");
                    sv = REMOVE;
                }
                break;
            }
        }
        
        return sv;
    }
    public static void getCartSummary(HttpServletRequest request)
    {
        Cart cart = getCart(request);
        
        double total = 0;
        for(CartItem c : cart.getList())
        {
            total += c.quantity * c.part.getPartPrice();
        }
        
        request.setAttribute("cartsummary", Double.toString(total) + " (" + Integer.toString(cart.numItems) + " items)"        );
        //return  Double.toString(total) + " (" + Integer.toString(cart.numItems) + " items)"; 
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
