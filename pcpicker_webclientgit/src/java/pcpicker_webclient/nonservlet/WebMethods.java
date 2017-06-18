/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpicker_webclient.nonservlet;
import pcpicker.*;
import pcpicker.PcpickerWebservice_Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.xml.ws.WebServiceRef;
/**
 *
 * @author admin
 */
public class WebMethods {
   // @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/192.168.119.185_8080/pcpicker_webserver/pcpicker_webservice.wsdl")
   
    
    
    public static java.util.List<java.lang.String> getManufacturers_1(java.lang.String type) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        pcpicker.PcpickerWebservice_Service service = new pcpicker.PcpickerWebservice_Service();
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        return port.getManufacturers(type);
    }

    public static java.util.List<java.lang.String> getMaxResolutions_1() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        pcpicker.PcpickerWebservice_Service service = new pcpicker.PcpickerWebservice_Service();
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        return port.getMaxResolutions();
    }

    public static java.util.List<java.lang.String> getMemoryTypes_1() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        pcpicker.PcpickerWebservice_Service service = new pcpicker.PcpickerWebservice_Service();
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        return port.getMemoryTypes();
    }

    public static java.util.List<java.lang.String> getGPUMemoryTypes() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        pcpicker.PcpickerWebservice_Service service = new pcpicker.PcpickerWebservice_Service();
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        return port.getGPUMemoryTypes();
    }

    
    public static Part getPart(java.lang.String partId) {
      pcpicker.PcpickerWebservice_Service service = new pcpicker.PcpickerWebservice_Service();
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        return port.getPart(partId);
    }

   

    public static String login(java.lang.String username, java.lang.String password) {
        pcpicker.PcpickerWebservice_Service service = new pcpicker.PcpickerWebservice_Service();
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        return port.login(username, password);
    }

   
    public static java.util.List<pcpicker.Order> getOrderList(int custId) {
        pcpicker.PcpickerWebservice_Service service = new pcpicker.PcpickerWebservice_Service();
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        return port.getOrderList(custId);
    }

    public static Boolean addCustomer(java.lang.String username, java.lang.String password, java.lang.String address, java.lang.String city, int zipCode, java.lang.String firstname, java.lang.String lastname) {
        pcpicker.PcpickerWebservice_Service service = new pcpicker.PcpickerWebservice_Service();
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        return port.addCustomer(username, password, address, city, zipCode, firstname, lastname);
    }

    public static String cancelOrder(int orderId) {
        pcpicker.PcpickerWebservice_Service service = new pcpicker.PcpickerWebservice_Service();
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        return port.cancelOrder(orderId);
    }

    public static java.util.List<pcpicker.Order> getOrderHistoryList(int custId) {
        pcpicker.PcpickerWebservice_Service service = new pcpicker.PcpickerWebservice_Service();
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        return port.getOrderHistoryList(custId);
    }

    public static java.util.List<pcpicker.Processor> getProcessorList(java.lang.String search, java.lang.String manufacturer, java.lang.Integer minPrice, java.lang.Integer maxPrice) {
        pcpicker.PcpickerWebservice_Service service = new pcpicker.PcpickerWebservice_Service();
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        return port.getProcessorList(search, manufacturer, minPrice, maxPrice);
    }

    public static java.util.List<pcpicker.Storage> getStorageList(java.lang.String search, java.lang.String manufacturer, java.lang.Integer minPrice, java.lang.Integer maxPrice) {
        pcpicker.PcpickerWebservice_Service service = new pcpicker.PcpickerWebservice_Service();
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        return port.getStorageList(search, manufacturer, minPrice, maxPrice);
    }

    public static java.util.List<pcpicker.PowerSupply> getPowerSupplyList(java.lang.String search, java.lang.String manufacturer, java.lang.Integer minPrice, java.lang.Integer maxPrice) {
        pcpicker.PcpickerWebservice_Service service = new pcpicker.PcpickerWebservice_Service();
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        return port.getPowerSupplyList(search, manufacturer, minPrice, maxPrice);
    }

    public static java.util.List<pcpicker.Mouse> getMouseList(java.lang.String search, java.lang.String manufacturer, java.lang.Integer minPrice, java.lang.Integer maxPrice) {
        pcpicker.PcpickerWebservice_Service service = new pcpicker.PcpickerWebservice_Service();
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        return port.getMouseList(search, manufacturer, minPrice, maxPrice);
    }

    public static java.util.List<pcpicker.Motherboard> getMotherboardList(java.lang.String search, java.lang.String manufacturer, java.lang.Integer minPrice, java.lang.Integer maxPrice) {
        pcpicker.PcpickerWebservice_Service service = new pcpicker.PcpickerWebservice_Service();
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        return port.getMotherboardList(search, manufacturer, minPrice, maxPrice);
    }

    public static java.util.List<pcpicker.Monitor> getMonitorList(java.lang.String search, java.lang.String manufacturer, java.lang.Integer minPrice, java.lang.Integer maxPrice) {
        pcpicker.PcpickerWebservice_Service service = new pcpicker.PcpickerWebservice_Service();
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        return port.getMonitorList(search, manufacturer, minPrice, maxPrice);
    }

    public static java.util.List<pcpicker.Memory> getMemoryList(java.lang.String search, java.lang.String manufacturer, java.lang.Integer minPrice, java.lang.Integer maxPrice) {
        pcpicker.PcpickerWebservice_Service service = new pcpicker.PcpickerWebservice_Service();
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        return port.getMemoryList(search, manufacturer, minPrice, maxPrice);
    }

    public static java.util.List<pcpicker.Keyboard> getKeyboardList(java.lang.String search, java.lang.String manufacturer, java.lang.Integer minPrice, java.lang.Integer maxPrice) {
        pcpicker.PcpickerWebservice_Service service = new pcpicker.PcpickerWebservice_Service();
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        return port.getKeyboardList(search, manufacturer, minPrice, maxPrice);
    }

    public static java.util.List<pcpicker.GraphicsCard> getGraphicsCardList(java.lang.String search, java.lang.String manufacturer, java.lang.Integer minPrice, java.lang.Integer maxPrice) {
        pcpicker.PcpickerWebservice_Service service = new pcpicker.PcpickerWebservice_Service();
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        return port.getGraphicsCardList(search, manufacturer, minPrice, maxPrice);
    }

    public static java.util.List<pcpicker.Cooler> getCoolerList(java.lang.String search, java.lang.String manufacturer, java.lang.Integer minPrice, java.lang.Integer maxPrice) {
        pcpicker.PcpickerWebservice_Service service = new pcpicker.PcpickerWebservice_Service();
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        return port.getCoolerList(search, manufacturer, minPrice, maxPrice);
    }

    public static double getMaxPrice(java.lang.String compType) {
        pcpicker.PcpickerWebservice_Service service = new pcpicker.PcpickerWebservice_Service();
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        return port.getMaxPrice(compType);
    }

    public static int addOrder(int custId, java.util.List<java.lang.String> partIds, java.util.List<java.lang.Integer> quantity, java.lang.String paymentType, java.lang.String deliveryAddress) {
        pcpicker.PcpickerWebservice_Service service = new pcpicker.PcpickerWebservice_Service();
        pcpicker.PcpickerWebservice port = service.getPcpickerWebservicePort();
        return port.addOrder(custId, partIds, quantity, paymentType, deliveryAddress);
    }

  


}
