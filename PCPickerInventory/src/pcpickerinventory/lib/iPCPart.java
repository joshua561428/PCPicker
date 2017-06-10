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
public interface iPCPart {
    public int ID();
    public void ID(int _id);
    public String Name();
    public void Name(String _name);
    public String Type();
    public void Type(Parts.Type _type);
    public String Description();
    public void Description(String _description);
    public String Manufacturer();
    public void Manufacturer(String _manufacturer);
    public String Branch();
    public void Branch(String _branch);
    public int Quantity();
    public void Quantity(int _quantity);
    public double Price();
    public void Price(double _price);
}
