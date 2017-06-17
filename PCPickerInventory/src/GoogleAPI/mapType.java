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
public class mapType {
    private String mapTypeName = "&maptype=";
    private String mapTypeType = "";
    
    public mapType(){
        
    }
    public mapType(String _type){
        mapTypeType = _type;
    }
    
    public String name(){
        return mapTypeName;
    }
    public void name(String _name){
        mapTypeName = _name;
    }
    public String type(){
        return mapTypeType;
    }
    public void type(String _type){//thi
        mapTypeType = _type;
    }
    public String value(){
        return this.name() + this.type();
    }
}
