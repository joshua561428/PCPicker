/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GoogleAPI;

/**
 *
 * @author appbenigno
 */
public class mapSpecific {
    private String specificName = "center=";
    private String specificLocation = "";
    
    public mapSpecific(){
        
    }
    public mapSpecific(String _location){
        specificLocation = _location;
    }
    
    public String name(){
        return specificName;
    }
    public void name(String _name){
        specificName = _name;
    }
    public String location(){
        return specificLocation;
    }
    public void location(String _location){
        specificLocation = _location;
    }
    public String value(){
        return this.name() + this.location().replaceAll(" ", "");
    }
}
