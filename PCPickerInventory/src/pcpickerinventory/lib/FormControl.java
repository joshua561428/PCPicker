/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpickerinventory.lib;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author appbenigno
 */
public class FormControl {
    // Clear All
    public static void clearAll(
            JTextField _id, 
            JTextField _name, 
            JTextField _price, 
            JTextField _manufacturer, 
            JComboBox _type,
            JTextField _param1,
            JTextField _param2,
            JTextField _param3,
            JTextField _param4,
            JTextField _param5
    )
    {
        _id.setText("");
        _name.setText("");
        _price.setText("");
        _manufacturer.setText("");
        _type.setSelectedIndex(0);
        _param1.setText("");
        _param2.setText("");
        _param3.setText("");
        _param4.setText("");
        _param5.setText("");
    }
    
    //
    // Get Component Types
    //
    public static void getParts(JComboBox _partsCombo)
    {
        ComboBoxModel cMod = new DefaultComboBoxModel();
        _partsCombo.setModel(cMod);
        List<Parts.Type> myParts = Arrays.asList(Parts.Type.values());
        int counter = myParts.size();
        try {
            for (int x = 0;x < counter;x++)
            {
                _partsCombo.addItem(myParts.get(x).toString().replaceAll("_", " "));
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Range out of bounds: " + e.getMessage());
        }
    }
    
    public static void getParts(JList _partsList)
    {
        ListModel lMod = _partsList.getModel();
        DefaultListModel modeller = new DefaultListModel();
        _partsList.setModel(lMod);
        List<Parts.Type> myParts = Arrays.asList(Parts.Type.values());
        int counter = myParts.size();
        try {
            for (int x = 0; x < counter;x++)
            {
                modeller.addElement(myParts.get(x).toString().replaceAll("_", " "));
            }
            lMod = (ListModel)modeller;
            _partsList.setModel(lMod);
        } catch (Exception e) {
        }
    }
}
