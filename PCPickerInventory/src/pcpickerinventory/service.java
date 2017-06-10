/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpickerinventory;

/**
 *
 * @author appbenigno
 */
public class service {

    //
    // Service Methods
    //
    
    // addCPU(String, String, String, int, int, int, String, int, Double, String)
    public static void insert_CPU(String ID, String manufacturer, String name, int coreClock, int coreNum, int threads, String socket, int tdp, double price, String type)
    {
        addCPU(ID, manufacturer, name, coreClock, coreNum, threads, socket, tdp, price, type);
    }
    
    // addGPU(String, String, String, int, String, String, int, double, String)
    public static void insert_GPU(String ID, String manufacturer, String name, int coreClock, String memDDR, String memCapacity, int memClock, double price, String type)
    {    
        addGPU(ID, manufacturer, name, coreClock, memDDR, memCapacity, memClock, price, type);
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

    private static java.util.List<pcpickerinventory.Branch> getBranchesList() {
        pcpickerinventory.PcpickerWebserviceForDesktop_Service service = new pcpickerinventory.PcpickerWebserviceForDesktop_Service();
        pcpickerinventory.PcpickerWebserviceForDesktop port = service.getPcpickerWebserviceForDesktopPort();
        return port.getBranchesList();
    }

    private static java.util.List<pcpickerinventory.Customer> getCustomerList() {
        pcpickerinventory.PcpickerWebserviceForDesktop_Service service = new pcpickerinventory.PcpickerWebserviceForDesktop_Service();
        pcpickerinventory.PcpickerWebserviceForDesktop port = service.getPcpickerWebserviceForDesktopPort();
        return port.getCustomerList();
    }

    private static java.util.List<pcpickerinventory.Delivery> getDeliveryList() {
        pcpickerinventory.PcpickerWebserviceForDesktop_Service service = new pcpickerinventory.PcpickerWebserviceForDesktop_Service();
        pcpickerinventory.PcpickerWebserviceForDesktop port = service.getPcpickerWebserviceForDesktopPort();
        return port.getDeliveryList();
    }

    private static java.util.List<pcpickerinventory.Inventory> getInventoryList() {
        pcpickerinventory.PcpickerWebserviceForDesktop_Service service = new pcpickerinventory.PcpickerWebserviceForDesktop_Service();
        pcpickerinventory.PcpickerWebserviceForDesktop port = service.getPcpickerWebserviceForDesktopPort();
        return port.getInventoryList();
    }

    private static java.util.List<pcpickerinventory.Order> getOrderList() {
        pcpickerinventory.PcpickerWebserviceForDesktop_Service service = new pcpickerinventory.PcpickerWebserviceForDesktop_Service();
        pcpickerinventory.PcpickerWebserviceForDesktop port = service.getPcpickerWebserviceForDesktopPort();
        return port.getOrderList();
    }

    private static java.util.List<pcpickerinventory.OrderComponent> getOrderComponentList() {
        pcpickerinventory.PcpickerWebserviceForDesktop_Service service = new pcpickerinventory.PcpickerWebserviceForDesktop_Service();
        pcpickerinventory.PcpickerWebserviceForDesktop port = service.getPcpickerWebserviceForDesktopPort();
        return port.getOrderComponentList();
    }

    
}
