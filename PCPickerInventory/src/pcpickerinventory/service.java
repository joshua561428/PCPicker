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
    private static void addCPU(java.lang.String compId, java.lang.String compManufacturer, java.lang.String compName, int coreClock, int coreNum, int threadNum, java.lang.String socket, int tdp, double compPrice, java.lang.String compType) {
        pcpicker.PcpickerWebservice_Service service = new pcpicker.PcpickerWebservice_Service();
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        port.addCPU(compId, compManufacturer, compName, coreClock, coreNum, threadNum, socket, tdp, compPrice, compType);
    }

    private static void addGPU(java.lang.String compId, java.lang.String compManufacturer, java.lang.String compName, int coreClock, java.lang.String memDdr, java.lang.String memCapacity, int memClock, double compPrice, java.lang.String compType) {
        pcpicker.PcpickerWebservice_Service service = new pcpicker.PcpickerWebservice_Service();
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        port.addGPU(compId, compManufacturer, compName, coreClock, memDdr, memCapacity, memClock, compPrice, compType);
    }
}
