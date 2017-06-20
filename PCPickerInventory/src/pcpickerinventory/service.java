/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpickerinventory;
import java.awt.Color;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import pcpicker_webservicefordesktop.Inventory;
import pcpicker_webservicefordesktop.InventoryItem;
import pcpicker_webservicefordesktop.Order;
import pcpickerinventory.lib.Parts;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

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
    public static flags flag = new flags();
    private static final DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    // systemLog(Exception, String)
    public static void systemLog(Exception ex, String systemMessage)
    {
        sysLog.append("(System):  <" + ex.getClass().getSimpleName() + "> -- " + systemMessage + "\n");
    }

    // systemLog(String)
    public static void systemLog(String systemMessage)
    {
        sysLog.append("(System): <!> -- " + systemMessage + "\n");
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
    
    // addInventory(String, Date, int, int)
    public static void insert_BranchInventory(String _ComponentID, String _DateAcquired, int _BranchID, int _Quantity){
        addInventory(_ComponentID, _DateAcquired, _BranchID, _Quantity);
    }
    
    public static String dater(){
        Date date = new Date();
        return sdf.format(date);
    }
    
    public static void getMasterInventory(JTable targetTable)
    {
        DefaultTableModel myTable = (DefaultTableModel)targetTable.getModel();
        myTable.setRowCount(0);
        targetTable.setModel(myTable);
        DefaultTableModel mdl = (DefaultTableModel)targetTable.getModel();
        pcpicker_webservicefordesktop.Inventory inv = getInventoryList();
        List<InventoryItem> lister = inv.getItems();
        for (int x = 0;x < lister.size();x++)
        {
            Object row[] = new Object[5];
            row[0] = inv.getItems().get(x).getPart().getPartId();
            row[1] = inv.getItems().get(x).getPart().getPartName();
            row[2] = inv.getItems().get(x).getPart().getPartType();
            row[3] = inv.getItems().get(x).getPart().getPartManufacturer();
            row[4] = inv.getItems().get(x).getPart().getPartPrice();
            mdl.addRow(row);
        }
        targetTable.setModel(mdl);
    }
    
    public static void getDeliveries(JTable targetTable, int _branchID){
        DefaultTableModel myTable = (DefaultTableModel)targetTable.getModel();
        myTable.setRowCount(0);
        targetTable.setModel(myTable);
        DefaultTableModel mdl = (DefaultTableModel)targetTable.getModel();
        List<pcpicker_webservicefordesktop.Order> orders = getActivePendingOrderList(_branchID);
        for (int x = 0;x < getActivePendingOrderList(_branchID).size();x++)
        {
            Object row[] = new Object[4];
            row[0] = orders.get(x).getOrderId();
            row[1] = orders.get(x).getDeliveryAddress();
            row[2] = orders.get(x).getNearestBranchRequest();
            row[3] = orders.get(x).getDeliveryDate();
            mdl.addRow(row);
        }
        targetTable.setModel(mdl);
    }
    
    public static void getAcceptedOrders(JTable targetTable, int _branchID){
        DefaultTableModel myTable = (DefaultTableModel)targetTable.getModel();
        myTable.setRowCount(0);
        targetTable.setModel(myTable);
        DefaultTableModel mdl = (DefaultTableModel)targetTable.getModel();
        List<pcpicker_webservicefordesktop.Order> orders = getAcceptedOrders();
        for (int x = 0;x < getAcceptedOrders().size();x++)
        {
            Object row[] = new Object[4];
            row[0] = orders.get(x).getOrderId();
            row[1] = orders.get(x).getDeliveryAddress();
            row[2] = orders.get(x).getNearestBranchRequest();
            row[3] = orders.get(x).getDeliveryDate();
            mdl.addRow(row);
        }
        targetTable.setModel(mdl);
    }
    
    public static void getBranchID(JTable targetTable){
        DefaultTableModel myTable = (DefaultTableModel)targetTable.getModel();
        myTable.setRowCount(0);
        targetTable.setModel(myTable);
        DefaultTableModel mdl = (DefaultTableModel)targetTable.getModel();
        List<pcpicker_webservicefordesktop.Branch> branches = getBranchesList();
        for (int x = 0;x < getBranchesList().size();x++)
        {
            Object row[] = new Object[3];
            row[0] = branches.get(x).getBranchId();
            row[1] = branches.get(x).getName();
            row[2] = branches.get(x).getAddress();
            mdl.addRow(row);
        }
        targetTable.setModel(mdl);
    }
    
    // Filter by type
    public static void filter(String filterName, JTable targetTable)
    {
        DefaultTableModel myTable = (DefaultTableModel)targetTable.getModel();
        myTable.setRowCount(0);
        targetTable.setModel(myTable);
        DefaultTableModel mdl = (DefaultTableModel)targetTable.getModel();
        pcpicker_webservicefordesktop.Inventory inv = getInventoryList();
        List<InventoryItem> lister = inv.getItems();
        for (int x = 0;x < lister.size();x++)
        {
            Object row[] = new Object[5];
            row[0] = inv.getItems().get(x).getPart().getPartId();
            row[1] = inv.getItems().get(x).getPart().getPartName();
            row[2] = inv.getItems().get(x).getPart().getPartType();
            row[3] = inv.getItems().get(x).getPart().getPartManufacturer();
            row[4] = inv.getItems().get(x).getPart().getPartPrice();
            if (row[2].toString().equals(filterName))
            {
                mdl.addRow(row);
            }
        }
        targetTable.setModel(mdl);
        systemLog("Filter by: " + filterName);
    }
    
    //
    // Web Services
    //

    private static Inventory getInventoryList() {
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service service = new pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service();
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop port = service.getPcpickerWebserviceForDesktopPort();
        return port.getInventoryList();
    }

    private static java.util.List<pcpicker_webservicefordesktop.Customer> getCustomerList() {
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service service = new pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service();
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop port = service.getPcpickerWebserviceForDesktopPort();
        return port.getCustomerList();
    }

    private static Order getOrder(int orderId) {
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service service = new pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service();
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop port = service.getPcpickerWebserviceForDesktopPort();
        return port.getOrder(orderId);
    }

    private static java.util.List<pcpicker_webservicefordesktop.Order> getActivePendingOrderList(int branchId) {
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service service = new pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service();
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop port = service.getPcpickerWebserviceForDesktopPort();
        return port.getActivePendingOrderList(branchId);
    }

    private static java.util.List<pcpicker_webservicefordesktop.Branch> getBranchesList() {
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service service = new pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service();
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop port = service.getPcpickerWebserviceForDesktopPort();
        return port.getBranchesList();
    }

    private static String addCPU(java.lang.String compId, java.lang.String compManufacturer, java.lang.String compName, int coreClock, int coreNum, int threadNum, java.lang.String socket, int tdp, double compPrice, java.lang.String compType) {
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service service = new pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service();
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop port = service.getPcpickerWebserviceForDesktopPort();
        return port.addCPU(compId, compManufacturer, compName, coreClock, coreNum, threadNum, socket, tdp, compPrice, compType);
    }

    private static String addGPU(java.lang.String compId, java.lang.String compManufacturer, java.lang.String compName, int coreClock, java.lang.String memDdr, java.lang.String memCapacity, int memClock, double compPrice, java.lang.String compType) {
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service service = new pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service();
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop port = service.getPcpickerWebserviceForDesktopPort();
        return port.addGPU(compId, compManufacturer, compName, coreClock, memDdr, memCapacity, memClock, compPrice, compType);
    }

    private static String addMemory(java.lang.String compId, java.lang.String compManufacturer, java.lang.String compName, int memCapacity, java.lang.String memDdr, int memClock, double compPrice, java.lang.String compType) {
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service service = new pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service();
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop port = service.getPcpickerWebserviceForDesktopPort();
        return port.addMemory(compId, compManufacturer, compName, memCapacity, memDdr, memClock, compPrice, compType);
    }

    private static String addPowerSupply(java.lang.String compId, java.lang.String compManufacturer, java.lang.String compName, int wattage, java.lang.String rating, java.lang.String formFactor, double compPrice, java.lang.String compType) {
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service service = new pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service();
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop port = service.getPcpickerWebserviceForDesktopPort();
        return port.addPowerSupply(compId, compManufacturer, compName, wattage, rating, formFactor, compPrice, compType);
    }

    private static String addInventory(java.lang.String compId, java.lang.String dateAcquired, int branchId, int quantity) {
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service service = new pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service();
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop port = service.getPcpickerWebserviceForDesktopPort();
        return port.addInventory(compId, dateAcquired, branchId, quantity);
    }

    private static java.util.List<pcpicker_webservicefordesktop.Order> getAcceptedOrders() {
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service service = new pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop_Service();
        pcpicker_webservicefordesktop.PcpickerWebserviceForDesktop port = service.getPcpickerWebserviceForDesktopPort();
        return port.getAcceptedOrders();
    }

}
