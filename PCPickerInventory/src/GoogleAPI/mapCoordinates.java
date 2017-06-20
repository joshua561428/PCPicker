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
public class mapCoordinates {
    private String coordName = "center=";
    private String coordLongitude = "";
    private String coordLatitude = "";
    
    
    public mapCoordinates(){
    }
    
    public mapCoordinates(String _Name, String _latitude, String _longitude)
    {
        coordName = _Name;
        coordLongitude = _longitude; // X-axis
        coordLatitude = _latitude; // Y-axis
    }
    
    public String name()
    {
        return coordName;
    }
    public void name(String _Name)
    {
        coordName = _Name;
    }
    public String X()
    {
        return coordLongitude;
    }
    public String longitude()
    {
        return coordLongitude;
    }
    public void longitude(String _longitude)
    {
        coordLongitude = _longitude;
    }
    public String Y()
    {
        return coordLatitude;
    }
    public String latitude(){
        return coordLatitude;
    }
    public void latitude(String _latitude)
    {
        coordLatitude = _latitude;
    }
    public String value(){
        return this.name() + this.longitude() + "," + this.latitude();
    }
}
