/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpickerdesktop;
import javax.naming.PartialResultException;
import pcpickerdesktop.parts.*;

/**
 *
 * @author appbenigno
 */
public class PCPickerDesktop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        WinForms.MainForm().setVisible(true);
        
        Mouse myKeyboard = new Mouse(0, "Dell Mouse Standard", "nothing out of ordinary", "Dell", "Makati", 30, 100.00);
        System.out.println("ID: " + myKeyboard.ID());
        System.out.println("Name: " + myKeyboard.Name());
        System.out.println("Type: " + myKeyboard.Type());
        System.out.println("Description: " + myKeyboard.Description());
        System.out.println("Manufacturer: " + myKeyboard.Manufacturer());
        System.out.println("Branch: " + myKeyboard.Branch());
        System.out.println("Quantity: " + myKeyboard.Quantity());
        System.out.println("Price: " + myKeyboard.Price());
    }
}
