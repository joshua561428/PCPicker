/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpickerinventory.parts;

import pcpickerinventory.lib.Parts;
import javax.sql.*;
import pcpickerinventory.service;

/**
 *
 * @author CS183P-AC1-16
 */


public class Processor extends pcpickerinventory.lib.PCPart {
    
    // Default Constructor
    public Processor()
    {
        
    }
    
    // Constructor Parameters
    /*
    private static String addCPU(java.lang.String compId, java.lang.String compManufacturer, java.lang.String compName, int coreClock, int coreNum, int threadNum, java.lang.String socket, int tdp, double compPrice, java.lang.String compType) {
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service service = new pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service();
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop port = service.getPcpickerWebserviceForDesktopPort();
        return port.addCPU(compId, compManufacturer, compName, coreClock, coreNum, threadNum, socket, tdp, compPrice, compType);
    }*/
}
