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
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.*;
import java.net.URL;
import java.util.logging.Logger;
import javax.swing.*;
import java.util.Scanner;
import javax.swing.border.EmptyBorder;

public class GoogleMapsGui extends JFrame {

    final Logger log = Logger.getLogger(GoogleMapsGui.class.getName());
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GoogleMapsGui frame = new GoogleMapsGui();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public GoogleMapsGui() {
        setTitle("Map");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 592, 352);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JFrame test = new JFrame("Google Maps");

        try {
            // String latitude = "-25.9994652";
            // String longitude = "28.3112051";
            String location = JOptionPane
                    .showInputDialog(" please enter the desired loccation");// get
                                                                            // the
                                                                            // location
                                                                            // for
                                                                            // geo
                                                                            // coding
            Scanner sc = new Scanner(location);
            Scanner sc2 = new Scanner(location);
            String marker = "";
            String path = JOptionPane
                    .showInputDialog("what is your destination?");
            String zoom = JOptionPane
                    .showInputDialog("how far in do you want to zoom?\n"
                            + "12(zoomed out) - 20 (zoomed in)");

            String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?";
            while (sc.hasNext()) {// add location to imageUrl
                imageUrl = imageUrl + sc.next();
            }
            marker = "&markers=color:red|";
            while (sc2.hasNext()) {// add marker location to marker
                marker = marker + sc2.next() + ",";

            }
            marker = marker.substring(0, marker.length() - 1);

            imageUrl = imageUrl + "&size=630x600&scale=2&maptype=roadmap" //hybrid, roadmap
                    + marker;
            //
            log.info("Generated url");
            System.out.println(imageUrl);

            String destinationFile = "image.jpg";

            // read the map image from Google
            // then save it to a local file: image.jpg
            //
            URL url = new URL(imageUrl);
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(destinationFile);

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }
            log.info("Created image.jpg");

            is.close();
            os.close();
            sc.close();
            sc2.close();
            log.info("Closed util's");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
            log.severe("Could not create image.jpg");
        }// fin getting and storing image

        ImageIcon imageIcon = new ImageIcon((new ImageIcon("image.jpg"))
                .getImage().getScaledInstance(630, 600,
                        java.awt.Image.SCALE_SMOOTH));
        contentPane.setLayout(null);
        JLabel imgMap = new JLabel(imageIcon);
        imgMap.setBounds(5, 5, 571, 308);
        contentPane.add(imgMap);
    }
}