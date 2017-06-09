package pcpicker;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.*;
import javax.jws.*;

/**
 *
 * @author PD
 */
@WebService(serviceName = "pcpicker_webservice")
public class Pcpicker_webservice
{
    String user="root";
    String pass="1825";
    
    @WebMethod(operationName = "getProcessorList")
    public ArrayList<Processor> getProcessorList() {
        ArrayList<Processor> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call get_processor_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new Processor()); ////////////////////////////////////////////

                a.get(last).setComp_id(rs.getString(1));/////////////////////////////
                a.get(last).setComp_type(rs.getString(2));//////////////////
                a.get(last).setComp_manufacturer(rs.getString(3));////////////////
                a.get(last).setComp_name(rs.getString(4));///////////////
                a.get(last).setComp_price(rs.getDouble(5));////////////////
                //*****************************************nadoble comp_id
                a.get(last).setCore_clock(rs.getString(7));/////////////////
                a.get(last).setCore_num(rs.getInt(8));/////////////////
                a.get(last).setThread_num(rs.getInt(9));////////////////////
                a.get(last).setSocket_(rs.getString(10));////////////////
                a.get(last).setTdp(rs.getInt(11));/////////////////////
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    @WebMethod(operationName = "getCoolerList")
    public ArrayList<Cooler> getCoolerList() {
        ArrayList<Cooler> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call get_Cooler_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new Cooler()); ////////////////////////////////////////////

                a.get(last).setComp_id(rs.getString(1));/////////////////////////////
                a.get(last).setComp_type(rs.getString(2));//////////////////
                a.get(last).setComp_manufacturer(rs.getString(3));////////////////
                a.get(last).setComp_name(rs.getString(4));///////////////
                a.get(last).setComp_price(rs.getDouble(5));////////////////
                //*****************************************nadoble comp_id
                a.get(last).setSupported_sockets(rs.getString(7));/////////////////
                a.get(last).setLiquid_cooling(rs.getBoolean(8));/////////////////
                a.get(last).setRated_tdp(rs.getInt(9));////////////////////
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    @WebMethod(operationName = "getGraphicsCardList")
    public ArrayList<GraphicsCard> getGraphicsCardList() {
        ArrayList<GraphicsCard> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call get_graphicscard_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new GraphicsCard()); ////////////////////////////////////////////

                a.get(last).setComp_id(rs.getString(1));/////////////////////////////
                a.get(last).setComp_type(rs.getString(2));//////////////////
                a.get(last).setComp_manufacturer(rs.getString(3));////////////////
                a.get(last).setComp_name(rs.getString(4));///////////////
                a.get(last).setComp_price(rs.getDouble(5));////////////////
                //*****************************************nadoble comp_id
                a.get(last).setCore_clock(rs.getInt(7));/////////////////
                a.get(last).setMem_ddr(rs.getString(8));/////////////////
                a.get(last).setMem_capacity(rs.getString(9));////////////////////
                a.get(last).setMem_clock(rs.getInt(10));/////////////////////
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    @WebMethod(operationName = "getKeyboardList")
    public ArrayList<Keyboard> getKeyboardList() {
        ArrayList<Keyboard> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call get_keyboard_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new Keyboard()); ////////////////////////////////////////////

                a.get(last).setComp_id(rs.getString(1));/////////////////////////////
                a.get(last).setComp_type(rs.getString(2));//////////////////
                a.get(last).setComp_manufacturer(rs.getString(3));////////////////
                a.get(last).setComp_name(rs.getString(4));///////////////
                a.get(last).setComp_price(rs.getDouble(5));////////////////
                //*****************************************nadoble comp_id
                a.get(last).setBacklit(rs.getBoolean(7));/////////////////
                a.get(last).setType_(rs.getString(8));/////////////////
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    @WebMethod(operationName = "getMemoryList")
    public ArrayList<Memory> getMemoryList() {
        ArrayList<Memory> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call get_Memory_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new Memory()); ////////////////////////////////////////////

                a.get(last).setComp_id(rs.getString(1));/////////////////////////////
                a.get(last).setComp_type(rs.getString(2));//////////////////
                a.get(last).setComp_manufacturer(rs.getString(3));////////////////
                a.get(last).setComp_name(rs.getString(4));///////////////
                a.get(last).setComp_price(rs.getDouble(5));////////////////
                //*****************************************nadoble comp_id
                a.get(last).setMem_capacity(rs.getInt(7));/////////////////
                a.get(last).setMem_ddr(rs.getString(8));/////////////////
                a.get(last).setMem_clock(rs.getInt(9));////////////////////
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    @WebMethod(operationName = "getMonitorList")
    public ArrayList<Monitor> getMonitorList() {
        ArrayList<Monitor> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call get_Memory_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new Monitor()); ////////////////////////////////////////////

                a.get(last).setComp_id(rs.getString(1));/////////////////////////////
                a.get(last).setComp_type(rs.getString(2));//////////////////
                a.get(last).setComp_manufacturer(rs.getString(3));////////////////
                a.get(last).setComp_name(rs.getString(4));///////////////
                a.get(last).setComp_price(rs.getDouble(5));////////////////
                //*****************************************nadoble comp_id
                a.get(last).setAspect_ratio(rs.getString(7));/////////////////
                a.get(last).setScreen_size(rs.getInt(8));/////////////////
                a.get(last).setMax_resolution(rs.getString(9));////////////////////
                a.get(last).setRefresh_rate(rs.getInt(10));////////////////
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    @WebMethod(operationName = "getMotherboardList")
    public ArrayList<Motherboard> getMotherboardList() {
        ArrayList<Motherboard> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call get_Motherboard_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new Motherboard()); ////////////////////////////////////////////

                a.get(last).setComp_id(rs.getString(1));/////////////////////////////
                a.get(last).setComp_type(rs.getString(2));//////////////////
                a.get(last).setComp_manufacturer(rs.getString(3));////////////////
                a.get(last).setComp_name(rs.getString(4));///////////////
                a.get(last).setComp_price(rs.getDouble(5));////////////////
                //*****************************************nadoble comp_id
                a.get(last).setSocket(rs.getString(7));/////////////////
                a.get(last).setMem_slots(rs.getInt(8));/////////////////
                a.get(last).setForm_factor(rs.getString(9));////////////////////
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    @WebMethod(operationName = "getMouseList")
    public ArrayList<Mouse> getMouseList() {
        ArrayList<Mouse> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call get_Mouse_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new Mouse()); ////////////////////////////////////////////

                a.get(last).setComp_id(rs.getString(1));/////////////////////////////
                a.get(last).setComp_type(rs.getString(2));//////////////////
                a.get(last).setComp_manufacturer(rs.getString(3));////////////////
                a.get(last).setComp_name(rs.getString(4));///////////////
                a.get(last).setComp_price(rs.getDouble(5));////////////////
                //*****************************************nadoble comp_id
                a.get(last).setDpi(rs.getInt(7));/////////////////
                a.get(last).setConnection_(rs.getString(8));/////////////////
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    @WebMethod(operationName = "getStorageList")
    public ArrayList<Storage> getStorageList() {
        ArrayList<Storage> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call get_storage_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new Storage()); ////////////////////////////////////////////

                a.get(last).setComp_id(rs.getString(1));/////////////////////////////
                a.get(last).setComp_type(rs.getString(2));//////////////////
                a.get(last).setComp_manufacturer(rs.getString(3));////////////////
                a.get(last).setComp_name(rs.getString(4));///////////////
                a.get(last).setComp_price(rs.getDouble(5));////////////////
                //*****************************************nadoble comp_id
                a.get(last).setType_(rs.getString(7));/////////////////
                a.get(last).setCapacity(rs.getInt(8));/////////////////
                a.get(last).setInterface_(rs.getString(8));
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    @WebMethod(operationName = "getPowerSupplyList")
    public ArrayList<PowerSupply> getPowerSupplyList() {
        ArrayList<PowerSupply> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call get_PowerSupply_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new PowerSupply()); ////////////////////////////////////////////

                a.get(last).setComp_id(rs.getString(1));/////////////////////////////
                a.get(last).setComp_type(rs.getString(2));//////////////////
                a.get(last).setComp_manufacturer(rs.getString(3));////////////////
                a.get(last).setComp_name(rs.getString(4));///////////////
                a.get(last).setComp_price(rs.getDouble(5));////////////////
                //*****************************************nadoble comp_id
                a.get(last).setWattage(rs.getInt(7));/////////////////
                a.get(last).setRating(rs.getString(8));/////////////////
                a.get(last).setForm_factor(rs.getString(8));
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    @WebMethod(operationName = "getBranchesList")
    public ArrayList<Branch> getBranchesList() {
        ArrayList<Branch> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call get_Branch_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new Branch()); ////////////////////////////////////////////

                a.get(last).setBranch_id(rs.getInt(1));/////////////////////////////
                a.get(last).setCity(rs.getString(2));//////////////////
                a.get(last).setAddress(rs.getString(3));////////////////
                a.get(last).setZip_code(rs.getInt(4));///////////////
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    @WebMethod(operationName = "getInventoryList")
    public ArrayList<Inventory> getInventoryList() {
        ArrayList<Inventory> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call get_Inventory_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new Inventory()); ////////////////////////////////////////////

                a.get(last).setComp_id(rs.getInt(1));/////////////////////////////
                a.get(last).setDate_acquired(rs.getString(2));//////////////////
                a.get(last).setBranch_id(rs.getInt(3));////////////////
                a.get(last).setQuantity(rs.getInt(4));///////////////
            
                a.get(last).setComp_name(rs.getString(6));
                a.get(last).setComp_price(rs.getDouble(7));
                a.get(last).setComp_manufacturer(rs.getString(8));
                a.get(last).setComp_type(rs.getString(9));
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    @WebMethod(operationName = "getCustomerList")
    public ArrayList<Customer> getCustomerList() {
        ArrayList<Customer> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call get_Customer_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new Customer()); ////////////////////////////////////////////

                a.get(last).setCust_id(rs.getInt(1));/////////////////////////////
                a.get(last).setUsername(rs.getString(2));//////////////////
                a.get(last).setPassword(rs.getString(3));////////////////
                a.get(last).setAddress(rs.getString(4));///////////////
                a.get(last).setCity(rs.getString(5));////////////////
                a.get(last).setZip_code(rs.getInt(6));/////////////////
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    @WebMethod(operationName = "getOrderList")
    public ArrayList<Order> getOrderList() {
        ArrayList<Order> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call get_Order_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new Order()); ////////////////////////////////////////////

                a.get(last).setOrder_id(rs.getInt(1));/////////////////////////////
                a.get(last).setCust_id(rs.getInt(2));//////////////////
                a.get(last).setDate_created(rs.getString(3));////////////////
                a.get(last).setPayment_type(rs.getString(4));///////////////
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    @WebMethod(operationName = "getOrder_componentList")
    public ArrayList<Order_component> getOrder_componentList() {
        ArrayList<Order_component> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call get_Order_component_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new Order_component()); ////////////////////////////////////////////

                a.get(last).setOrder_id(rs.getInt(1));/////////////////////////////
                a.get(last).setComp_id(rs.getString(2));//////////////////
                a.get(last).setQuantity(rs.getInt(3));////////////////
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    @WebMethod(operationName = "getDeliveryList")
    public ArrayList<Delivery> getDeliveryList() {
        ArrayList<Delivery> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call get_Delivery_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new Delivery()); ////////////////////////////////////////////

                a.get(last).setDelivery_num(rs.getInt(1));/////////////////////////////
                a.get(last).setOrder_id(rs.getInt(2));//////////////////
                a.get(last).setDate_delivery(rs.getString(3));////////////////
                a.get(last).setAccepted_by(rs.getString(4));///////////////
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    @WebMethod(operationName = "getImageList")
    public ArrayList<Image> getImageList() {
        ArrayList<Image> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call get_Image_list()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
                int last = a.size();
                a.add(new Image()); ////////////////////////////////////////////

                a.get(last).setComp_id(rs.getString(1));/////////////////////////////
                a.get(last).setImageclass(rs.getString(2));//////////////////
                a.get(last).setImagepath(rs.getString(3));////////////////
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addCPU")
    @Oneway
    public void addCPU(@WebParam(name = "comp_id") String comp_id, @WebParam(name = "comp_manufacturer") String comp_manufacturer, @WebParam(name = "comp_name") String comp_name, @WebParam(name = "core_clock") int core_clock, @WebParam(name = "core_num") int core_num, @WebParam(name = "thread_num") int thread_num, @WebParam(name = "socket_") String socket_, @WebParam(name = "tdp") int tdp, @WebParam(name = "comp_price") double comp_price, @WebParam(name = "comp_type") String comp_type) {
      try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call add_processor(?,?,?,?,?,?,?,?,?,?)}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            callableStatement.setString(1, comp_id);
            callableStatement.setString(2, comp_manufacturer);
            callableStatement.setString(3, comp_name);
            callableStatement.setInt(4, core_clock);
            callableStatement.setInt(5, core_num);
            callableStatement.setInt(6, thread_num);
            callableStatement.setString(7, socket_);
            callableStatement.setInt(8, tdp);
            callableStatement.setDouble(9, comp_price);
            callableStatement.setString(10, comp_type);
            
            
            
            callableStatement.executeUpdate();

            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
      
    
    
    
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addMemory")
    @Oneway
    public void addMemory(@WebParam(name = "comp_id") String comp_id, @WebParam(name = "comp_manufacturer") String comp_manufacturer, @WebParam(name = "comp_name") String comp_name, @WebParam(name = "mem_capacity") int mem_capacity, @WebParam(name = "mem_ddr") String mem_ddr, @WebParam(name = "mem_clock") int mem_clock, @WebParam(name = "comp_price") double comp_price, @WebParam(name = "comp_type") String comp_type) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call add_memory(?,?,?,?,?,?,?,?,?,?)}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            callableStatement.setString(1, comp_id);
            callableStatement.setString(2, comp_manufacturer);
            callableStatement.setString(3, comp_name);
            callableStatement.setInt(4, mem_capacity);
            callableStatement.setString(5, mem_ddr);
            callableStatement.setInt(6, mem_clock);
            callableStatement.setDouble(7, comp_price);
            callableStatement.setString(8, comp_type);
            
            
            
            
            callableStatement.executeUpdate();

            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addPowerSupply")
    @Oneway
    public void addPowerSupply(@WebParam(name = "comp_id") String comp_id, @WebParam(name = "comp_manufacturer") String comp_manufacturer, @WebParam(name = "comp_name") String comp_name, @WebParam(name = "wattage") int wattage, @WebParam(name = "rating") String rating, @WebParam(name = "form_factor") String form_factor, @WebParam(name = "comp_price") double comp_price, @WebParam(name = "comp_type") String comp_type) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call add_powersupply(?,?,?,?,?,?,?,?,?,?)}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            callableStatement.setString(1, comp_id);
            callableStatement.setString(2, comp_manufacturer);
            callableStatement.setString(3, comp_name);
            callableStatement.setInt(4, wattage);
            callableStatement.setString(5, rating);
            callableStatement.setString(6, form_factor);
            callableStatement.setDouble(7, comp_price);
            callableStatement.setString(8, comp_type);
            
            
            
            
            callableStatement.executeUpdate();

            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addGPU")
    @Oneway
    public void addGPU(@WebParam(name = "comp_id") String comp_id, @WebParam(name = "comp_manufacturer") String comp_manufacturer, @WebParam(name = "comp_name") String comp_name, @WebParam(name = "core_clock") int core_clock, @WebParam(name = "mem_ddr") String mem_ddr, @WebParam(name = "mem_capacity") String mem_capacity, @WebParam(name = "mem_clock") int mem_clock, @WebParam(name = "comp_price") double comp_price, @WebParam(name = "comp_type") String comp_type) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);
            String ql2 = "{call add_graphicscard(1,2,3,4,5,6,7,8,9)}";
            String sql = "{call add_graphicscard(?,?,?,?,?,?,?,?,?)}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            callableStatement.setString(1, comp_id);
            callableStatement.setString(2, comp_manufacturer);
            callableStatement.setString(3, comp_name);
            callableStatement.setInt(4, core_clock);
            callableStatement.setString(5, mem_ddr);
            callableStatement.setString(6, mem_capacity);
            callableStatement.setInt(7, mem_clock);
            callableStatement.setDouble(8, comp_price);
            callableStatement.setString(9, comp_type);

            callableStatement.executeUpdate();

            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getManufacturers")
    public ArrayList<String> getManufacturers(@WebParam(name = "type") String type) {
          ArrayList<String> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call getManufacturers(?)}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            callableStatement.setString(1, type);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
              
                a.add(rs.getString(1)); ////////////////////////////////////////////

           
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getMemoryTypes")
    public ArrayList<String> getMemoryTypes() {
         ArrayList<String> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call getMemoryTypes()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
              
                a.add(rs.getString(1)); ////////////////////////////////////////////

           
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getGPUMemoryTypes")
    public ArrayList<String> getGPUMemoryTypes() {
         ArrayList<String> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call getGPUMemoryTypes()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
              
                a.add(rs.getString(1)); ////////////////////////////////////////////

           
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getMaxResolutions")
    public ArrayList<String> getMaxResolutions() {
        ArrayList<String> a = new ArrayList(); ///////////////////////////////
        int i = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pcpicker", user, pass);

            String sql = "{call getMaxResolutions()}"; ////////////////////////////////
            CallableStatement callableStatement = conn.prepareCall(sql);
            ResultSet rs = callableStatement.executeQuery();

            while (rs.next()) {
              
                a.add(rs.getString(1)); ////////////////////////////////////////////

           
            }
            callableStatement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return a;
    }
    


}
