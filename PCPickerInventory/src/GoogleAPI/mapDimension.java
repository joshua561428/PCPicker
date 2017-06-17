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
public class mapDimension {
    private String dimensionName = "&size=";
    private String dimensionLength = "";
    private String dimensionHeight = "";
    public mapDimension(){
        
    }
    public mapDimension(String _length, String _height){
        dimensionLength = _length;
        dimensionHeight = _height;
    }
    public String name(){
        return dimensionName;
    }
    public void name(String _name){
        dimensionName = _name;
    }
    public String length(){
        return  dimensionLength;
    }
    public void length(String _length){
        dimensionLength = _length;
    }
    public String height(){
        return dimensionHeight;
    }
    public void height(String _height){
        dimensionHeight = _height;
    }
    public String value(){
        return this.name() + this.length() + "x" + this.height();
    }
}
