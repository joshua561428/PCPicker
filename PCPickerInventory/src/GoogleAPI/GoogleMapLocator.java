/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GoogleAPI;
import java.awt.EventQueue;
import java.io.*;
import java.net.URL;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author appbenigno
 */
public class GoogleMapLocator {
    //
    // https://maps.googleapis.com/maps/api/staticmap?center=Berkeley,CA&zoom=14&size=400x400&key=YOUR_API_KEY
    //
    
    public String imageURL = "https://maps.googleapis.com/maps/api/staticmap?";
    public String destinationFile = "image.jpg";
    
    public mapSpecific mSpecific = new mapSpecific(); 
    public mapCoordinates mCoordinate = new mapCoordinates();
    public mapDimension mDimension = new mapDimension("640", "640");
    public mapMarker mMarker = new mapMarker();
    public mapScale mScale = new mapScale();
    public mapZoom mZoom = new mapZoom();
    public mapType mType = new mapType();
    public mapKey mKey = new mapKey();
    

    /*
    public double latitude = 0.0;
    public double longitude = 0.0;
    public String locationSpecific; 
    public String locationCoordinates; 
    public String scale = "&scale="; // 1=(multiplier x1)  2=(multiplier x2)
    public String scaleValue = "";
    public String zoom = "&zoom="; // 1=(World) 5=(Landmass) 10=(City) 15=(Streets) 20=(Buildings)
    public String zoomValue = "";
    public int dimensionLength = 640;
    public int dimensionHeight = 640;
    public String dimension = "&size=";
    public String dimensionValue = dimensionLength + "x" + dimensionHeight;
    public String mapType = "&maptype="; // roadmap, satellite, terrain, hybrid
    public String mapTypeValue = "";
    public String markerColor = ""; // black, brown, green, purple, yellow, blue, gray, orange, red, white
    public String marker = "&markers=color:";
    public String markerValue = markerColor + "|";
    public String key = "&key=";
    public String keyValue = "AIzaSyBt5syC_GlqrOA2Y3w0pU-rXXMlbg5ZTvk";
    */
    

    public GoogleMapLocator() {
    }
    public GoogleMapLocator(String _LocationName, String _Zoom, String _Scale, String _MapType, String _MarkerColor)
    {
        mSpecific = new mapSpecific(_LocationName);
        mZoom = new mapZoom(_Zoom);
        mScale = new mapScale(_Scale);
        mType = new mapType(_MapType);
        mMarker = new mapMarker(_MarkerColor, _LocationName);
    }
    
    public void displayName()
    {
        System.out.println(imageURL + mSpecific.value() + mZoom.value() + mDimension.value() + mType.value() + mMarker.value());
    }
    
    public String getMarkedPosition()
    {
        //https://maps.googleapis.com/maps/api/staticmap?alabangtowncenter&size=630x600&scale=2&maptype=roadmap&markers=color:red|alabang,town,center
        return imageURL + mSpecific.value() + mZoom.value() + mDimension.value() + mScale.value() + mType.value() + mMarker.value();
    }
    
    public void displayCoordinates()
    {
        System.out.println(imageURL + mCoordinate.value() + mZoom.value() + mDimension.value() + mType.value() + mMarker.value());
    }
    
    public void generateMap()
    {
        try
        {
            URL url = new URL(getMarkedPosition());
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(destinationFile);

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }
            pcpickerinventory.service.systemLog("Created image.jpg");

            is.close();
            os.close();
            pcpickerinventory.service.systemLog("Closed util's");
        } catch (IOException e) {
            pcpickerinventory.service.systemLog(e,"Could not create image.jpg");
            System.exit(1);
        }// fin getting and storing image
    }
}
