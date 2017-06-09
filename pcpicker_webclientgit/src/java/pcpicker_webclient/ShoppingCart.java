/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpicker_webclient;

import java.util.ArrayList;
import java.util.List;
import pcpicker.*;


/**
 *
 * @author admin
 */
public class ShoppingCart {
    private List<Component> components = new ArrayList<Component>();
    private static ShoppingCart instance;
    private ShoppingCart(){}
    
    public static ShoppingCart GetInstance()
    {
        if(instance == null)
            instance = new ShoppingCart();
        
        return instance;
    }
    public void addItem(Component component)
    {
        components.add(component);
    }
    public void removeItem(Component component)
    {
        for(int i = 0; i < components.size();i++)
            if(components.get(i).getCompId().equals(component.getCompId()))
                components.remove(i);            
    }
    public List<Component> getList()
    {
        return components;
    }
    public void destroy()
    {
        instance = null;
    }
}
