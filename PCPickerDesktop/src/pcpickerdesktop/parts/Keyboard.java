/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpickerdesktop.parts;

/**
 *
 * @author appbenigno
 */
public class Keyboard extends pcpickerdesktop.lib.PCPart {
    private String partType = "Keyboard";
    
    public Keyboard()
    {}
    
    public Keyboard(int _id, String _name, String _description, String _manufacturer, String _branch, int _quantity)
    {
        super(_id, _name, _description, _manufacturer, _branch, _quantity);
    }
}
