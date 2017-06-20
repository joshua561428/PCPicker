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
public class mapZoom {
    private String zoomName = "&zoom=";
    private String zoomSize = "";
    
    public mapZoom(){
        
    }
    public mapZoom(String _zoomSize){
        zoomSize = _zoomSize;
    }
    
    public String name(){
        return zoomName;
    }
    public void name(String _name){
        zoomName = _name;
    }
    public String size(){
        return zoomSize;
    } 
    public void size(String _size){
        zoomSize = _size;
    }
    public String value(){
        return this.name() + this.size();
    }
}
