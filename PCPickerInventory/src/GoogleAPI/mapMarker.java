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
public class mapMarker {
    private String markerName = "&markers=color:";
    private String markerColor = "";
    private String markerLocation = "";
    public mapMarker(){
        
    }
    public mapMarker(String _color, String _location){
        markerColor = _color;
        markerLocation = _location;
    }
    public String name(){
        return markerName;
    }
    public void name(String _name){
        markerName = _name;
    }
    public String color(){
        return markerColor;
    }
    public void color(String _color){
        markerColor = _color;
    }
    public String location(){
        return markerLocation;
    }
    public void location(String _location){
        markerLocation = _location;
    }
    public String value(){
        return this.name() + this.color() + "|" + this.location().replaceAll(" ", ",");
    }
}
