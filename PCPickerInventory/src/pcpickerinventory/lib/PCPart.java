/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpickerinventory.lib;

/**
 *
 * @author appbenigno
 */
public class PCPart implements iPCPart {
    private int partID = 0;
    private String partName = "";
    private Parts.Type partType = Parts.Type.Generic;
    private String partDescription = "";
    private String partManufacturer = "";
    private String partBranch = "";
    private int partQuantity = 0;
    private double partPrice = 0.0;
    
    public PCPart()
    {}
    
    public PCPart(int id, String name, String description, String manufacturer, String branch, int quantity, double price)
    {
        partID = id;
        partName = name;
        partDescription = description;
        partManufacturer = manufacturer;
        partBranch = branch;
        partQuantity = quantity;
        partPrice = price;
    }

    @Override
    public int ID() {
        return partID;
    }

    @Override
    public void ID(int _id) {
        partID = _id;
    }

    @Override
    public String Name() {
        return partName;
    }

    @Override
    public void Name(String _name) {
        partName = _name;
    }

    @Override
    public String Type() {
        return partType.toString();
    }

    @Override
    public void Type(Parts.Type _type) {
        partType = _type;
    }

    @Override
    public String Description() {
        return partDescription;
    }

    @Override
    public void Description(String _description) {
        partDescription = _description;
    }

    @Override
    public String Manufacturer() {
        return partManufacturer;
    }

    @Override
    public void Manufacturer(String _manufacturer) {
        partManufacturer = _manufacturer;
    }

    @Override
    public String Branch() {
        return partBranch;
    }

    @Override
    public void Branch(String _branch) {
        partBranch = _branch;
    }

    @Override
    public int Quantity() {
        return partQuantity;
    }

    @Override
    public void Quantity(int _quantity) {
        partQuantity = _quantity;
    }

    @Override
    public double Price() {
        return partPrice;
    }

    @Override
    public void Price(double _price) {
        partPrice = _price;
    }
    
    
}
