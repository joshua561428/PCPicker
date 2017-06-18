/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpicker_webclient;

import pcpicker_webclient.nonservlet.WebMethods;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pcpicker.*;

/**
 *
 * @author admin
 */
public class SearchPage extends HttpServlet {

  



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
        String componentType = getComponentType(request);
        ShoppingCart.getCartSummary(request);
        
       
        //filter(request,componentType);
        request.setAttribute("componentType", componentType);
        request.setAttribute("manufacturers", getManufacturers(componentType));
        request.setAttribute("componentslist",getList(componentType,request));
        request.getRequestDispatcher("searchpage.jsp").forward(request, response);
    }
    private String getManufacturer(HttpServletRequest request)
    {
        String manufacturer = null;
        manufacturer = (String) request.getParameter("manufacturer");         
        if(manufacturer != null && manufacturer.trim().equals("All"))
            manufacturer = null;
            
       
        if(manufacturer!=null)
            manufacturer = manufacturer.trim();
        request.setAttribute("manufacturerval",manufacturer);
        return manufacturer;
    }
    
    private Integer getMinMax(HttpServletRequest request, String parameterName)
    {
        Integer p = null;
        String price = (String)request.getParameter(parameterName);
        if(price != null)
        { 
            price = price.trim().substring(3);
            p = Integer.parseInt(price);
        }
        
        return p;
    }
    private HashMap getList(String compType, HttpServletRequest request)
    {
        String search = request.getParameter("searchbar");
        request.setAttribute("searchbar",search);
        String manufacturer = getManufacturer(request);
        Integer minPrice =  getMinMax(request,"sminPrice") ;
        Integer maxPrice = getMinMax(request,"smaxPrice") ;
        
        if(minPrice == null)
            minPrice =0;
        if(maxPrice == null)
            maxPrice = getMaxPrice(compType);
       
        int setMaxPrice = getMaxPrice(compType);
        int setMinPrice = 0;       
        request.setAttribute("setMaxPrice",maxPrice);
        request.setAttribute("setMinPrice", minPrice);
        request.setAttribute("maxPrice",getMaxPrice(compType));
       
        
        HashMap manuf = new HashMap();        
        if(compType.equals("Processor") || compType.equals("CPU"))
        {
            List<Processor> components = WebMethods.getProcessorList(search,manufacturer,minPrice,maxPrice);
            for(int i = 0; i < components.size();i++)
            {            
                Processor g = components.get(i);
                HashMap items =  getProcessorItem(g,request);
                manuf.put(Integer.toString(i), items);
            }
                   
        }
        
        else if(compType.equals("Memory"))
        {
            List<Memory> components = WebMethods.getMemoryList(search,manufacturer,minPrice,maxPrice);
            for(int i = 0; i < components.size();i++)
            {                            
                Memory g = components.get(i);
                HashMap items = getMemoryItem(g,request);                
                manuf.put(Integer.toString(i), items);
            }
        }
        else if(compType.equals("Mouse"))
        {
            List<Mouse> components = WebMethods.getMouseList(search,manufacturer,minPrice,maxPrice);
            for(int i = 0; i < components.size();i++)
            {                           
                Mouse g = components.get(i);
                HashMap items = getMouseItem(g,request);              
                manuf.put(Integer.toString(i), items);
            }
        }
        else if(compType.equals("Motherboard"))
        {
            List<Motherboard> components = WebMethods.getMotherboardList(search,manufacturer,minPrice,maxPrice);
            for(int i = 0; i < components.size();i++)
            {
                Motherboard g = components.get(i);
                HashMap items = getMotherboardItem(g,request);
                manuf.put(Integer.toString(i), items);
            }
        }
        else if(compType.equals("Cooler"))
        {
            List<Cooler> components = WebMethods.getCoolerList(search,manufacturer,minPrice,maxPrice);
            for(int i = 0; i < components.size();i++)
            {
                Cooler g = components.get(i);
                HashMap items = getCoolerItem(g,request);
                manuf.put(Integer.toString(i), items);
            }
        }
        else if(compType.equals("Storage"))
        {
            List<Storage> components= WebMethods.getStorageList(search,manufacturer,minPrice,maxPrice);
            for(int i = 0; i < components.size();i++)
            {                         
                Storage g = components.get(i);
                HashMap items = getStorageItem(g,request);                    
                manuf.put(Integer.toString(i), items);
            }
        }
        else if(compType.equals("Power Supply"))
        {
            List<PowerSupply> components = WebMethods.getPowerSupplyList(search,manufacturer,minPrice,maxPrice);
            for(int i = 0; i < components.size();i++)
            {                             
                PowerSupply g = components.get(i);
                HashMap items = getPowerSupplyItem(g,request);    
                manuf.put(Integer.toString(i), items);
            }
        }
        else if(compType.equals("Keyboard"))
        {
            List<Keyboard> components = WebMethods.getKeyboardList(search,manufacturer,minPrice,maxPrice);
            for(int i = 0; i < components.size();i++)
            {              
                Keyboard g = components.get(i);
                HashMap items = getKeyboardItem(g,request);                
                manuf.put(Integer.toString(i), items);
            }
        }
        else if(compType.equals("GPU") || compType.equals("graphicscard"))
        {
            List<GraphicsCard> components = WebMethods.getGraphicsCardList(search,manufacturer,minPrice,maxPrice);
            for(int i = 0; i < components.size();i++)
            {
                GraphicsCard g = components.get(i);
                HashMap items = getGraphicsCardItem(g,request);
                manuf.put(Integer.toString(i), items);
            }
        }
        else if(compType.equals("Monitor"))
        {
            List<Monitor> components = WebMethods.getMonitorList(search,manufacturer,minPrice,maxPrice);
            for(int i = 0; i < components.size();i++)
            {
                Monitor g = components.get(i);
                HashMap items = getMonitorItem(g,request);     
                manuf.put(Integer.toString(i), items);
            }
        }
//        //todo -- get motherboard formfactor
       
        
        return manuf;
        
        
    }
    
   
    
   
    private Boolean searchPart(List<Part> parts, String search)
    {
        for(Part part : parts)
        {
            if(part.getPartName().toLowerCase().contains(search.toLowerCase()))
                return true;
            else if(part.getPartId().toLowerCase().contains(search.toLowerCase()))
                return true;
        }
        return false;
    }
    
    
    private String getComponentType(HttpServletRequest request)
    {
        String componentType = (String) request.getParameter("test");
        if(componentType==null||componentType.equals(""))
            componentType = (String) request.getParameter("componentType");
        if(componentType == null || componentType.equals(""))
            componentType = "Processor";
        return componentType;
    }
    
    
    private HashMap getProcessorItem(Processor p, HttpServletRequest request)
    {
        HashMap items = new HashMap();
        items.put("1",p.getPartId());
        items.put("2",p.getPartId()+" " +p.getPartManufacturer() + " "+p.getPartName());
        items.put("3",Double.toString(p.getPartPrice()));
        items.put("4",p.getImagePath());
        items.put("5", p.getCoreClock() + " GHz");
        items.put("6",p.getCoreNum()+"C/"+p.getThreadNum()+"T");
        items.put("7", "TDP: "+p.getTdp() + " W");
        items.put("8", p.getSocket());
        return items;
    }
      
    private HashMap getGraphicsCardItem(GraphicsCard p, HttpServletRequest request)
    {
        HashMap items = new HashMap();
        items.put("1",p.getPartId());
        items.put("2",p.getPartId()+" " +p.getPartManufacturer() + " "+p.getPartName());
        items.put("3",Double.toString(p.getPartPrice()));
        items.put("4",p.getImagePath());
        items.put("6",p.getMemCapacity()+"GB "+p.getMemDdr());
        items.put("5",p.getCoreClock()+" MHz");
                             
        return items;
    }
    
    private HashMap getMonitorItem(Monitor p, HttpServletRequest request)
    {
        HashMap items = new HashMap();
        items.put("1",p.getPartId());
        items.put("2",p.getPartId()+" " +p.getPartManufacturer() + " "+p.getPartName());
        items.put("3",Double.toString(p.getPartPrice()));
        items.put("4",p.getImagePath());
        items.put("6",p.getRefreshRate()+" Hz ");
        items.put("5",p.getMaxResolution() + "");
        items.put("7",p.getAspectRatio() + " aspect ratio");                                
        return items;
    }
    
    
    private HashMap getMemoryItem(Memory p, HttpServletRequest request)
    {
        HashMap items = new HashMap();
        items.put("1",p.getPartId());
        items.put("2",p.getPartId()+" " +p.getPartManufacturer() + " "+p.getPartName());
        items.put("3",Double.toString(p.getPartPrice()));
        items.put("4",p.getImagePath());
        items.put("6",p.getMemCapacity()+" GB ");
        items.put("5",p.getMemClock() + " MHz");
        items.put("7",p.getMemDdr().toUpperCase());                              
        return items;
    }
   
    private HashMap getMouseItem(Mouse p, HttpServletRequest request)
    {
        HashMap items = new HashMap();
        items.put("1",p.getPartId());
        items.put("2",p.getPartId()+" " +p.getPartManufacturer() + " "+p.getPartName());
        items.put("3",Double.toString(p.getPartPrice()));
        items.put("4",p.getImagePath());
        items.put("6",p.getConnection());
        items.put("5",p.getDpi()+" dpi");                             
        return items;
    }
  
    private HashMap getMotherboardItem(Motherboard p, HttpServletRequest request)
    {
        HashMap items = new HashMap();
        items.put("1",p.getPartId());
        items.put("2",p.getPartId()+" " +p.getPartManufacturer() + " "+p.getPartName());
        items.put("3",Double.toString(p.getPartPrice()));
        items.put("4",p.getImagePath());
        items.put("6",p.getFormFactor());
        items.put("5",p.getSocket());                           
        return items;
    }
    
    private HashMap getCoolerItem(Cooler p, HttpServletRequest request)
    {
        HashMap items = new HashMap();
        items.put("1",p.getPartId());
        items.put("2",p.getPartId()+" " +p.getPartManufacturer() + " "+p.getPartName());
        items.put("3",Double.toString(p.getPartPrice()));
        items.put("4",p.getImagePath());
        items.put("6",p.getRatedTdp()+ " W");
        items.put("5",p.getSupportedSockets());
        Boolean liquidCooled = p.isLiquidCooling();
        if(liquidCooled)
            items.put("7","Liquid Cooling System");                         
        return items;
    }
    
    private HashMap getStorageItem(Storage p, HttpServletRequest request)
    {
        HashMap items = new HashMap();
        items.put("1",p.getPartId());
        items.put("2",p.getPartId()+" " +p.getPartManufacturer() + " "+p.getPartName());
        items.put("3",Double.toString(p.getPartPrice()));
        items.put("4",p.getImagePath());
        items.put("5",p.getInterface());
        int cap = p.getCapacity();
        if(cap>20)
            items.put("6",cap + " MB");
        else
            items.put("6", cap + " TB");

        items.put("7",p.getType());                       
        return items;
    }
   
    private HashMap getPowerSupplyItem(PowerSupply p, HttpServletRequest request)
    {
        HashMap items = new HashMap();
        items.put("1",p.getPartId());
        items.put("2",p.getPartId()+" " +p.getPartManufacturer() + " "+p.getPartName());
        items.put("3",Double.toString(p.getPartPrice()));
        items.put("4",p.getImagePath());
        items.put("6",p.getFormFactor());
        items.put("5",p.getWattage()+" W");
        items.put("7",p.getRating());                     
        return items;
    }
    
    private HashMap getKeyboardItem(Keyboard p, HttpServletRequest request)
    {
        HashMap items = new HashMap();
        items.put("1",p.getPartId());
        items.put("2",p.getPartId()+" " +p.getPartManufacturer() + " "+p.getPartName());
        items.put("3",Double.toString(p.getPartPrice()));
        items.put("4",p.getImagePath());
        items.put("5",p.getType());
        if(p.isBacklit())
            items.put("6","RGB");
                
                                                 
        return items;
    }
   
    
    private HashMap getAspectRatios()
    {
        HashMap manuf = new HashMap();
        
        
        //todo -- get motherboard formfactor
        manuf.put("1", "16:9");
        manuf.put("2", "21:9");
        manuf.put("3", "4:3");
        
        return manuf;
    }   
    
    
    private HashMap getMaxResolutions()
    {
        HashMap manuf = new HashMap();
        
        List<String> resos = WebMethods.getMaxResolutions_1();
       
        for(int i = 0; i < resos.size(); i++)
            manuf.put(Integer.toString(i),resos.get(i));
      
        
        return manuf;
    }       
            
            
    private HashMap getStorageInterface()
    {
        HashMap manuf = new HashMap();
        
     
        //todo -- get motherboard formfactor
        manuf.put("1", "SATA");
        manuf.put("2", "FC");
        manuf.put("3", "PCIe");
        
        return manuf;
    }
    private int getMaxPrice(String componentType)
    {
        System.out.println(componentType);
        Double max = WebMethods.getMaxPrice(componentType);
        max = Math.ceil(max / 1000) * 1000;
        return max.intValue();
    }
    private HashMap getFormFactor(String componentType)
    {
        HashMap manuf = new HashMap();
        
        if(componentType.equals("Motherboard") || componentType.equals("Cooler"))
        //todo -- get motherboard formfactor
        manuf.put("1", "Micro-ATX");
        manuf.put("2", "Standard-ATX");
        manuf.put("3", "Mini-ATX");
        
        return manuf;
    }
    
    private HashMap getgpuMemoryTypes()
    {
        HashMap manuf = new HashMap();
      
        List<String> memtypes = WebMethods.getGPUMemoryTypes();

        for(int i = 0; i < memtypes.size(); i++)
            manuf.put(Integer.toString(i),memtypes.get(i));
       
        
        return manuf;
    }
    private HashMap getMemoryTypes()
    {
        HashMap manuf = new HashMap();
        
        List<String> memtypes = WebMethods.getMemoryTypes_1();
       
        for(int i = 0; i < memtypes.size(); i++)
            manuf.put(Integer.toString(i),memtypes.get(i));
       
       
        
        return manuf;
    }
    private HashMap getMemoryCapacities()
    {
        HashMap manuf = new HashMap();
        
        //todo -- getMemoryCapacities
        manuf.put("1", "2gb");
        manuf.put("2", "4gb");
        manuf.put("3", "8gb");
        manuf.put("4", "16gb");
        
        return manuf;
    }
    
    private HashMap getSockets(String componentType)
    {
        HashMap manuf = new HashMap();
        
        if(componentType.equals("CPU")||componentType.equals("Processor")||componentType.equals("Motherboard"))
        {
        //todo -- get socket list from processor rable
            manuf.put("1", "socket1");
            manuf.put("2", "socket2");
            manuf.put("3", "socket3");
        }
        
        return manuf;
    }
    
    private HashMap getManufacturers(String componentType)
    {
        HashMap manuf = new HashMap();
        
        String comp_type ="";
        switch(componentType)
        {            
            case "CPU": comp_type="Processor";break;
            case "Cooler": comp_type="Heatsink";break;
            case "GPU":comp_type="Graphics Card";break;
            default: comp_type = componentType;
        }       
        
        List<String> manufs =  WebMethods.getManufacturers_1(comp_type);
        manuf.put("1", "All");
        for(int i = 0; i < manufs.size(); i++)
            manuf.put(Integer.toString(i+2), manufs.get(i));
        
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

   
   private void filter(HttpServletRequest request, String componentType)
    {
         //todo - on filterget get value max min
        int setMaxPrice = getMaxPrice(componentType);
        int setMinPrice = 0;       
        request.setAttribute("setMaxPrice",setMaxPrice);
        request.setAttribute("setMinPrice", setMinPrice);
        request.setAttribute("maxPrice",getMaxPrice(componentType));
        
        //todo on filterget get value max min
        int setMaxDPI = 2000;
        int setMinDPI = 0;       
        request.setAttribute("setMaxDPI",setMaxDPI);
        request.setAttribute("setMinDPI", setMinDPI);
        request.setAttribute("maxDPI",2000);
        
        //todo on filterget get value max min
        int setMaxgpu_memcap = 2000;
        int setMingpu_memcap = 0;       
        request.setAttribute("setMaxgpu_memcap",setMaxgpu_memcap);
        request.setAttribute("setMingpu_memcap", setMingpu_memcap);
        request.setAttribute("maxgpu_memcap",2000);
        
        //todo on filterget get value max min
        int setMaxwattage = 1500;
        int setMinwattage = 0;       
        request.setAttribute("setMaxwattage",setMaxwattage);
        request.setAttribute("setMinwattage", setMinwattage);
        request.setAttribute("maxwattage",1500);
        
        //todo on filterget get value max min
        int setMaxcore_num = 20;
        int setMincore_num = 0;       
        request.setAttribute("setMaxcore_num",setMaxcore_num);
        request.setAttribute("setMincore_num", setMincore_num);
        request.setAttribute("maxcore_num",20);
        
         //todo on filterget get value max min
        int setMaxtdp =200;
        int setMintdp = 0;       
        request.setAttribute("setMaxtdp",setMaxtdp);
        request.setAttribute("setMintdp", setMintdp);
        request.setAttribute("maxtdp",200);
        
          //todo on filterget get value max min
        int setMaxstoragecapacity = 10;
        int setMinstoragecapacity = 0;       
        request.setAttribute("setMaxstoragecapacity",setMaxstoragecapacity);
        request.setAttribute("setMinstoragecapacity", setMinstoragecapacity);
        request.setAttribute("maxstoragecapacity",10);
        
           //todo on filterget get value max min
        int setMaxscreensize = 50;
        int setMinscreensize = 10;       
        request.setAttribute("setMaxscreensize",setMaxscreensize);
        request.setAttribute("setMinscreensize", setMinscreensize);
        request.setAttribute("maxscreensize",50);
        
           //todo on filterget get value max min
        int setMaxrefreshrate = 200;
        int setMinrefreshrate = 10;       
        request.setAttribute("setMaxrefreshrate",setMaxrefreshrate);
        request.setAttribute("setMinrefreshrate", setMinrefreshrate);
        request.setAttribute("maxrefreshrate",200);
        
        
        request.setAttribute("aspectRatios",getAspectRatios());
        request.setAttribute("maxResolutions",getMaxResolutions());
        request.setAttribute("storageInterface",getStorageInterface());
        request.setAttribute("componentType", componentType);        
        request.setAttribute("sockets",getSockets(componentType));
        
        request.setAttribute("memoryTypes",getMemoryTypes());
        request.setAttribute("gpumemoryTypes",getgpuMemoryTypes());
        request.setAttribute("memoryCapacities",getMemoryCapacities());
        request.setAttribute("formFactor",getFormFactor(componentType));
        
       
    }
    
 

}
