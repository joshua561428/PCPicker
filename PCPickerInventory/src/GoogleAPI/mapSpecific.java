/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GoogleAPI;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

/**
 *
 * @author appbenigno
 */
public class mapSpecific {
    private String specificName = "center=";
    private String specificLocation = "";
    private List<String> specificLocations = new ArrayList<>();
    
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
    public String value() throws UnsupportedEncodingException{
        //String q = "random word £500 bank $";
        //String url = "http://example.com/query?q=" + URLEncoder.encode(q, "UTF-8");
        return this.name() + URLEncoder.encode(this.location(), "UTF-8");
    }
    public List<String> getLocations(){
        return specificLocations;
    }
    public void addLocation(String _location){
        if (!specificLocations.contains(_location)){
            specificLocations.add(_location);
        }
    }
    public void addLocation(List<String> _locations){
        specificLocations.clear();
        for (int x=0;x < _locations.size();x++){
            specificLocations.add(_locations.get(x));
        }
    }
    public void removeLocation(String _location){
        if (specificLocations.contains(_location)){
            specificLocations.remove(_location);
        }
    }
    public String values() throws UnsupportedEncodingException{
        int counter = specificLocations.size();
        String loc = this.name();
        for (int x=0;x < counter;x++){
            if (x == counter -1){
                loc += URLEncoder.encode(this.specificLocations.get(x), "UTF-8");
                
            }
            else {
                loc +=  URLEncoder.encode(this.specificLocations.get(x), "UTF-8") + ",";
            }
        }
        return loc;
    }
}
