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
    private String partID = "";
    private String partName = "";
    private String partType = "";
    private String partManufacturer = "";
    private double partPrice = 0.0;
    private String partParam1 = "";
    private String partParam2 = "";
    private String partParam3 = "";
    private String partParam4 = "";
    private String partParam5 = "";
    
    public PCPart()
    {}
    
    public PCPart(String _id)
    {
        
    }

    @Override
    public String ID() {
        return partID;
    }

    @Override
    public void ID(String _id) {
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
        return partType;
    }

    @Override
    public void Type(Parts.Type _type) {
        partType = _type.toString();
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
    public double Price() {
        return partPrice;
    }

    @Override
    public void Price(double _price) {
        partPrice = _price;
    }

    @Override
    public String Parameter1() {
        return partParam1;
    }

    @Override
    public void Parameter1(String _param1) {
        partParam1 = _param1;
    }

    @Override
    public String Parameter2() {
        return partParam2;
    }

    @Override
    public void Parameter2(String _param2) {
        partParam2 = _param2;
    }

    @Override
    public String Parameter3() {
        return partParam3;
    }

    @Override
    public void Parameter3(String _param3) {
        partParam3 = _param3;
    }

    @Override
    public String Parameter4() {
        return partParam4;
    }

    @Override
    public void Parameter4(String _param4) {
        partParam4 = _param4;
    }

    @Override
    public String Parameter5() {
        return partParam5;
    }

    @Override
    public void Parameter5(String _param5) {
        partParam5 = _param5;
    }

}
