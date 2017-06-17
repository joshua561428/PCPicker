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
public class mapScale {
    private String scaleName = "&scale=";
    private String scaleSize = "";
    
    public mapScale(){
        
    }
    public mapScale(String _scale){
        scaleSize = _scale;
    }
    
    public String name(){
        return scaleName;
    }
    public void name(String _name){
        scaleName = _name;
    }
    public String size(){
        return scaleSize;
    }
    public void size(String _size){
        scaleSize = _size;
    }
    public String value(){
        return this.name() + this.size();
    }
}
