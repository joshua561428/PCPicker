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
        Processor,
        Graphics_Card,
        Memory,
        Power_Supply,
        Mouse,
        Keyboard,
        Cooler,
        Monitor,
        Motherboard,
        Storage,
        Heatsink
    }
    
    //
    // PC Manufacturers
    //
    public enum Manufactuter
    {
        Acer,
        Aerocool,
        AMD,
        ASUS,
        Corsair,
        Crucial,
        Dell,
        Gigabyte,
        Kingston,
        Lenovo,
        Logitech,
        Memorex,
        Microsoft,
        MSI,
        Nvidia,
        Redragon,
        Toshiba,
        Thermaltake,
        Samsung,
        Seagate,
        Sony,
        Western_Digital
    }
}
