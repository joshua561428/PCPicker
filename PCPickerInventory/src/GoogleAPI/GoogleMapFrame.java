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
public class GoogleMapFrame {
    private JPanel contentPane;    
    
    public void display(JInternalFrame targetIFrame)
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
        ImageIcon imageIcon = new ImageIcon((new ImageIcon("image.jpg"))
                .getImage().getScaledInstance(600, 600,
                        java.awt.Image.SCALE_SMOOTH));
        return imageIcon;
    }
}
