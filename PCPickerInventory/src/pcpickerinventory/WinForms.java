/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpickerinventory;
import javax.swing.*;

/**
 *
 * @author appbenigno
 */
public class WinForms {
    
    //
    // Calls the System Log Form
    //
    
    private static JFrame sysLog;
    public static JFrame SysLog()
    {
        if (sysLog == null)
        {
            sysLog = new frmSystemLog();
        }
        return sysLog;
    }
    
    //
    // Calls the Main Form
    //
    private static JFrame mainForm;
    public static JFrame MainForm()
    {
        if (mainForm == null)
        {
            mainForm = new frmMain();
        }
        return mainForm;
    }
    
    //
    // Calls the Branches Form
    //
    private static JFrame branches;
    public static JFrame Branches()
    {
        if (branches == null)
        {
            branches = new frmBranches();
        }
        return branches;
    }
    
    //
    // Calls the Inventory Form
    //
    private static JFrame inventory;
    public static JFrame Inventory()
    {
        if (inventory == null)
        {
            inventory = new frmInventory();
        }
        return inventory;
    }
}
