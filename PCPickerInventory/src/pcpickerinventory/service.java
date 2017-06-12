/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpickerinventory;
import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author appbenigno
 */
public class service {
    
    //
    // System Log
    //
    public static boolean isErrorLogged = false;
    public static JTextArea sysLog = new JTextArea();
    
    // systemLog(Exception, String)
    public static void systemLog(Exception ex, String systemMessage)
    {
        sysLog.append("\n(System):  <" + ex.getClass().getSimpleName() + "> -- " + systemMessage);
    }

    // systemLog(String)
    public static void systemLog(String systemMessage)
    {
        sysLog.append("\n(System): <!> -- " + systemMessage);
    }

    // alert(JMenu)
    public static void errAlert(JMenu targetMenu)
    {
        isErrorLogged = true;
        targetMenu.setForeground(Color.RED);
    }
    public static void errAlert(JMenuItem targetMenuItem)
    {
        isErrorLogged = true;
        targetMenuItem.setForeground(Color.RED);
    }

    //
    // Service Methods
    //
    
    // addCPU(String, String, String, Double, String, int, int, int, String, int)
    public static void insert_CPU(String ID, String manufacturer, String name, double price, String type, int coreClock, int coreNum, int threads, String socket, int tdp)
    {
        addCPU(ID, manufacturer, name, coreClock, coreNum, threads, socket, tdp, price, type);
    }
    
    // addGPU(String, String, String, double, String, int, String, String, int)
    public static void insert_GPU(String ID, String manufacturer, String name, double price, String type, int coreClock, String memDDR, String memCapacity, int memClock)
    {    
        addGPU(ID, manufacturer, name, coreClock, memDDR, memCapacity, memClock, price, type);
    }
    
    // addMemory(String, String, String, int, String, int, double, String)
    public static void insert_Memory(String ID, String manufacturer, String name, double price, String type, int memCapacity, String memDDR, int memClock)
    {
        addMemory(ID, manufacturer, name, memCapacity, memDDR, memClock, price, type);
    }
    
    // addPowerSupply(String, String, String, int, String, String, double, String)
    public static void insert_PowerSupply(String ID, String manufacturer, String name, double price, String type, int wattage, String rating, String formFactor)
    {
        addPowerSupply(ID, manufacturer, name, wattage, rating, formFactor, price, type);
    }
    
    //
    // Web Services
    //
 
    private static String addCPU(java.lang.String compId, java.lang.String compManufacturer, java.lang.String compName, int coreClock, int coreNum, int threadNum, java.lang.String socket, int tdp, double compPrice, java.lang.String compType) {
        pcpickerinventory.PcpickerWebserviceForDesktop_Service service = new pcpickerinventory.PcpickerWebserviceForDesktop_Service();
        pcpickerinventory.PcpickerWebserviceForDesktop port = service.getPcpickerWebserviceForDesktopPort();
        return port.addCPU(compId, compManufacturer, compName, coreClock, coreNum, threadNum, socket, tdp, compPrice, compType);
    }

    private static String addGPU(java.lang.String compId, java.lang.String compManufacturer, java.lang.String compName, int coreClock, java.lang.String memDdr, java.lang.String memCapacity, int memClock, double compPrice, java.lang.String compType) {
        pcpickerinventory.PcpickerWebserviceForDesktop_Service service = new pcpickerinventory.PcpickerWebserviceForDesktop_Service();
        pcpickerinventory.PcpickerWebserviceForDesktop port = service.getPcpickerWebserviceForDesktopPort();
        return port.addGPU(compId, compManufacturer, compName, coreClock, memDdr, memCapacity, memClock, compPrice, compType);
    }

    private static String addMemory(java.lang.String compId, java.lang.String compManufacturer, java.lang.String compName, int memCapacity, java.lang.String memDdr, int memClock, double compPrice, java.lang.String compType) {
        pcpickerinventory.PcpickerWebserviceForDesktop_Service service = new pcpickerinventory.PcpickerWebserviceForDesktop_Service();
        pcpickerinventory.PcpickerWebserviceForDesktop port = service.getPcpickerWebserviceForDesktopPort();
        return port.addMemory(compId, compManufacturer, compName, memCapacity, memDdr, memClock, compPrice, compType);
    }

    private static String addPowerSupply(java.lang.String compId, java.lang.String compManufacturer, java.lang.String compName, int wattage, java.lang.String rating, java.lang.String formFactor, double compPrice, java.lang.String compType) {
        pcpickerinventory.PcpickerWebserviceForDesktop_Service service = new pcpickerinventory.PcpickerWebserviceForDesktop_Service();
        pcpickerinventory.PcpickerWebserviceForDesktop port = service.getPcpickerWebserviceForDesktopPort();
        return port.addPowerSupply(compId, compManufacturer, compName, wattage, rating, formFactor, compPrice, compType);
    }
}