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
public class mapMarker {
    //https://maps.googleapis.com/maps/api/staticmap?alabangtowncenter&size=630x600&scale=2&maptype=roadmap&markers=color:red|alabang,town,center
    //https://maps.googleapis.com/maps/api/staticmap?center=Brooklyn+Bridge,New+York,NY&zoom=13&size=600x300&maptype=roadmap&markers=color:blue%7Clabel:S%7C40.702147,-74.015794&markers=color:green%7Clabel:G%7C40.711614,-74.012318&markers=color:red%7Clabel:C%7C40.718217,-73.998284&key=YOUR_API_KEY
    private String markerName = "&markers=color:";
    private String markerColor = "";
    private List<String> markerColors = new ArrayList<>();
    private String markerLocation = "";
    private List<String> positions = new ArrayList<>();
    
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
    public void addColor(String _color){
        markerColors.add(_color);
    }
    public void removeColor(String _color){
        if (markerColors.contains(_color)){
            markerColors.remove(_color);
        }
    }
    public List<String> getColors(){
        return markerColors;
    }
    public String location(){
        return markerLocation;
    }
    public void location(String _location){
        markerLocation = _location;
    }
    public String value() throws UnsupportedEncodingException{
        //String q = "random word £500 bank $";
        //String url = "http://example.com/query?q=" + URLEncoder.encode(q, "UTF-8");
        return this.name() + this.color() + "|" + URLEncoder.encode(this.location(), "UTF-8");
    }
    public List<String> getPositions(){
        return positions;
    }
    public void addPosition(String _position){
        if (!positions.contains(_position)){
            positions.add(_position);
        }
    }
    public void addPosition(List<String> _locatons){
        positions.clear();
        for (int x = 0; x < positions.size();x++){
            positions.add(_locatons.get(x));
        }
    }
    public void removePosition(String _position){
        if (positions.contains(_position)){
            positions.remove(_position);
        }
    }
    public String values() throws UnsupportedEncodingException{
        int counter = positions.size();
        String loc = "";
        for (int x=0;x < counter;x++){
            if (x == counter -1){
                loc += this.name() + this.getColors().get(x) + "|" + URLEncoder.encode(positions.get(x), "UTF-8");
            }
            else{
                loc += this.name() + this.getColors().get(x) + "|" + URLEncoder.encode(positions.get(x), "UTF-8") + ",";
            }
        }
        return loc;
    }
}
