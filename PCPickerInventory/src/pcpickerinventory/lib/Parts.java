/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpickerinventory.lib;

/**
 *
 * @author appbenigno
 */
public class Parts {
    //
    // Global Variables
    //
    public static String partID = "";
    public static String partName = "";
    public static double partPrice = 0.0;
    public static String partManufacturer = "";
    public static String partType = "";
    
    //
    // PC Parts
    //
    public enum Type
    {
        CPU,
        MEMORY,
        POWER_SUPPLY,
        GRAPHICS_CARD,
        MOUSE,
        KEYBOARD,
        COOLER,
        MOTHERBOARD,
        STORAGE,
        MONITOR
    }
    
    //
    // PC Manufacturers
    //
    public enum Manufactuter
    {
        Generic,
        ASUS,
        Dell,
        Lenovo,
        Logitech,
        Memorex,
        Microsoft,
        MSI,
        Toshiba,
        Samsung,
        Sony
    }
}
