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
    
    // Clear Parameters
    public static void clearParameters(
            JTextField _param1,
            JTextField _param2,
            JTextField _param3,
            JTextField _param4,
            JTextField _param5
    )
    {
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
    
    //
    // Set Paramater Types
    //
    public static void setParameters(
            String typeSetter,
            JLabel lblParam1,
            JTextField txtParam1,
            JLabel lblParam2,
            JTextField txtParam2,
            JLabel lblParam3,
            JTextField txtParam3,
            JLabel lblParam4,
            JTextField txtParam4,
            JLabel lblParam5,
            JTextField txtParam5
    )
    {
        if (typeSetter.equals(Parts.Type.Processor.toString().replaceAll("_", " ")))
        {
            // Core Clock, Core Number, Core Threads, Core Sockets, TDP
            clearParameters(txtParam1, txtParam2, txtParam3, txtParam4, txtParam5);
            lblParam1.setText("Core Clock");
            txtParam1.setEnabled(true);
            lblParam2.setText("Core Number");
            txtParam2.setEnabled(true);
            lblParam3.setText("Core Threads");
            txtParam3.setEnabled(true);
            lblParam4.setText("Core Sockets");
            txtParam4.setEnabled(true);
            lblParam5.setText("TDP");
            txtParam5.setEnabled(true);
        }
        else if (typeSetter.equals(Parts.Type.Graphics_Card.toString().replaceAll("_", " ")))
        {
            // Core Clock, Memory DDR, Memory Capacity, Memory Clock
            clearParameters(txtParam1, txtParam2, txtParam3, txtParam4, txtParam5);
            lblParam1.setText("Core Clock");
            txtParam1.setEnabled(true);
            lblParam2.setText("Memory DDR");
            txtParam2.setEnabled(true);
            lblParam3.setText("Memory Capacity");
            txtParam3.setEnabled(true);
            lblParam4.setText("Memory Clock");
            txtParam4.setEnabled(true);
            lblParam5.setText("--");
            txtParam5.setEnabled(false);
        }
        else if (typeSetter.equals(Parts.Type.Memory.toString().replaceAll("_", " ")))
        {
            // Memory Capacity, Memory DDR, Memory Clock
            clearParameters(txtParam1, txtParam2, txtParam3, txtParam4, txtParam5);
            lblParam1.setText("Memory Capacity");
            txtParam1.setEnabled(true);
            lblParam2.setText("Memory DDR");
            txtParam2.setEnabled(true);
            lblParam3.setText("Memory Clock");
            txtParam3.setEnabled(true);
            lblParam4.setText("--");
            txtParam4.setEnabled(false);
            lblParam5.setText("--");
            txtParam5.setEnabled(false);
        }
        else if (typeSetter.equals(Parts.Type.Power_Supply.toString().replaceAll("_", " ")))
        {
            // Wattage, Rating, Form Factor
            clearParameters(txtParam1, txtParam2, txtParam3, txtParam4, txtParam5);
            lblParam1.setText("Wattage");
            txtParam1.setEnabled(true);
            lblParam2.setText("Rating");
            txtParam2.setEnabled(true);
            lblParam3.setText("Form Factor");
            txtParam3.setEnabled(true);
            lblParam4.setText("--");
            txtParam4.setEnabled(false);
            lblParam5.setText("--");
            txtParam5.setEnabled(false);
        }
        else
        {
            clearParameters(txtParam1, txtParam2, txtParam3, txtParam4, txtParam5);
            lblParam1.setText("--");
            txtParam1.setEnabled(false);
            lblParam2.setText("--");
            txtParam2.setEnabled(false);
            lblParam3.setText("--");
            txtParam3.setEnabled(false);
            lblParam4.setText("--");
            txtParam4.setEnabled(false);
            lblParam5.setText("--");
            txtParam5.setEnabled(false);
        }
    }
}
