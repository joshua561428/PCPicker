/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GoogleAPI;
import java.io.*;
import java.net.URL;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.*;
import org.w3c.dom.*;
/**
 *
 * @author appbenigno
 */
public class GoogleMapLocator {
    // [Sample Format]
    // https://maps.googleapis.com/maps/api/staticmap?center=Berkeley,CA&zoom=14&size=400x400&key=YOUR_API_KEY
    
    final String mapURL = "https://maps.googleapis.com/maps/api/staticmap?";
    public String mapFile = "image.jpg";
    final String geodataURL = "https://maps.googleapis.com/maps/api/directions/xml?origin=";
    public String geodataFile = "url.xml";
    
    public mapSpecific mSpecific = new mapSpecific(); 
    public mapCoordinates mCoordinate = new mapCoordinates();
    public mapDimension mDimension = new mapDimension("640", "640");
    public mapMarker mMarker = new mapMarker();
    public mapScale mScale = new mapScale();
    public mapZoom mZoom = new mapZoom();
    public mapType mType = new mapType();
    public mapKey mKey = new mapKey("AIzaSyA9GSrFDlDtDCRlcZzB9alI1X86VBLXsqA");
    
    private JPanel contentPane;    
    
    //
    // Default Constructor
    //
    public GoogleMapLocator() {
    }
    
    //
    // Parametered Constructor
    //
    public GoogleMapLocator(String _LocationName, String _Zoom, String _Scale, String _MapType, String _MarkerColor)
    {
        mSpecific = new mapSpecific(_LocationName);
        mZoom = new mapZoom(_Zoom);
        mScale = new mapScale(_Scale);
        mType = new mapType(_MapType);
        mMarker = new mapMarker(_MarkerColor, _LocationName);
        mapFile = "mapdata_" + _LocationName.replaceAll(" ", "") + ".png";
        geodataFile = "geodata_" + _LocationName.replaceAll(" ", "") + ".xml";
    }
    
    public void echoSpecific()
    {
        pcpickerinventory.service.systemLog("URL by name: " + mapURL + mSpecific.value() + mZoom.value() + mDimension.value() + mScale.value() + mType.value() + mMarker.value() + mKey.value());
        System.out.println(mapURL + mSpecific.value() + mZoom.value() + mDimension.value() + mScale.value() + mType.value() + mMarker.value() + mKey.value());
    }
    
    public String getMarkedPosition()
    {
        //https://maps.googleapis.com/maps/api/staticmap?alabangtowncenter&size=630x600&scale=2&maptype=roadmap&markers=color:red|alabang,town,center
        return mapURL + mSpecific.value() + mZoom.value() + mDimension.value() + mScale.value() + mType.value() + mMarker.value() + mKey.value();
    }
    
    public void echoCoordinates()
    {
        pcpickerinventory.service.systemLog("URL by coordinates: " + mapURL + mCoordinate.value() + mZoom.value() + mDimension.value() + mScale.value() + mType.value() + mMarker.value() + mKey.value());
        System.out.println(mapURL + mCoordinate.value() + mZoom.value() + mDimension.value() + mScale.value() + mType.value() + mMarker.value() + mKey.value());
    }
    
    public void generateMap()
    {
        System.out.println(getMarkedPosition());
        try
        {
            URL url = new URL(getMarkedPosition());
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(mapFile);

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }
            pcpickerinventory.service.systemLog("Created " + mapFile);
            is.close();
            os.close();
            pcpickerinventory.service.systemLog("Closed util's");
        } catch (IOException e) {
            pcpickerinventory.service.systemLog(e,"Could not create " + mapFile);
            System.exit(1);
        }// fin getting and storing image
    }
    
    public void getCoordinates(String _currentLocation, String _destinationLocation){
        String thisLine;
        
        BufferedReader theHTML = null;
        FileWriter fStream = null;
        BufferedWriter out = null;
        try {
            // https://maps.googleapis.com/maps/api/directions/json?origin=mapua+unversity+makati&destination=mapua+university+intramuros
            URL url = new URL("https://maps.googleapis.com/maps/api/directions/xml?origin=" + _currentLocation.replaceAll(" ", "+") + "&destination=" + _destinationLocation.replaceAll(" ", "+") + mKey.value());
            theHTML = new BufferedReader(new InputStreamReader(url.openStream()));
            fStream = new FileWriter(geodataFile);
            out = new BufferedWriter(fStream);
            while ((thisLine = theHTML.readLine()) != null){
                out.write(thisLine);
            }
        } 
        catch (Exception e) {
            pcpickerinventory.service.systemLog(e, e.getMessage());
            System.err.println(e.getMessage());
        }
        finally{
            try {
                out.close();
            } catch (Exception e) {
                pcpickerinventory.service.systemLog(e, e.getMessage());
                System.err.println(e.getMessage());
            }
        }
    }
    public void retrieveCoordinates(JFormattedTextField _latitudeTextField, JFormattedTextField _longitudeTextField){
        try {
            File file = new File(geodataFile);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nl = doc.getElementsByTagName("status");
            Element n = (Element)nl.item(0);
            String st = n.getFirstChild().getNodeValue();
            
            String st1, st2;

            if (st.equals("OK"))
            {
                NodeList n2a = doc.getElementsByTagName("lat");
                NodeList n2b = doc.getElementsByTagName("lng");
                Element nn1 = (Element)n2a.item(0);
                Element nn2 = (Element)n2b.item(0);
                st1 = nn1.getFirstChild().getNodeValue();
                st2 = nn2.getFirstChild().getNodeValue();
                _latitudeTextField.setText(st1);
                _longitudeTextField.setText(st2);
                pcpickerinventory.service.systemLog("Coordinates Retrieved: (" + st1 + "," + st2 + ")");
            }
        } catch (Exception e) {
            pcpickerinventory.service.systemLog(e, e.getMessage());
            System.err.println(e.getMessage());
        }
    }
    public void displayMap(JInternalFrame targetIFrame)
    {
        targetIFrame.setTitle("Customer Location");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        JLabel imgMap = new JLabel(mapIcon());
        imgMap.setBounds(5, 5, 600, 600);
        targetIFrame.getContentPane().removeAll();
        targetIFrame.getContentPane().add(imgMap);
        targetIFrame.revalidate();
    }
    public ImageIcon mapIcon()
    {
        ImageIcon imageIcon = new ImageIcon((new ImageIcon(mapFile))
                .getImage().getScaledInstance(600, 600,
                        java.awt.Image.SCALE_SMOOTH));
        return imageIcon;
    }
}
