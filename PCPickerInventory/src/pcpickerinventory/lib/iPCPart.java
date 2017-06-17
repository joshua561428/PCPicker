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
    public String ID();
    public void ID(String _id);
    public String Name();
    public void Name(String _name);
    public String Type();
    public void Type(Parts.Type _type);
    public String Manufacturer();
    public void Manufacturer(String _manufacturer);
    public double Price();
    public void Price(double _price);
    
    public String Parameter1();
    public void Parameter1(String _param1);
    public String Parameter2();
    public void Parameter2(String _param2);
    public String Parameter3();
    public void Parameter3(String _param3);
    public String Parameter4();
    public void Parameter4(String _param4);
    public String Parameter5();
    public void Parameter5(String _param5);
}
