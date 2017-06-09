/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpicker;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author admin
 */
import javax.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Component")
public class Component {
    @XmlElement(name = "comp_id")
    protected String comp_id;    
    @XmlElement(name = "comp_manufacturer")
    protected String comp_manufacturer;    
    @XmlElement(name = "comp_name")
    protected String comp_name;
    @XmlElement(name = "comp_price")
    protected double comp_price;    
    @XmlElement(name = "comp_type")
    protected String comp_type;
    
    public String getComp_id() {
        return comp_id;
    }

    /**
     * @param comp_id the comp_id to set
     */
    public void setComp_id(String comp_id) {
        this.comp_id = comp_id;
    }

    /**
     * @return the comp_manufacturer
     */
    public String getComp_manufacturer() {
        return comp_manufacturer;
    }

    /**
     * @param comp_manufacturer the comp_manufacturer to set
     */
    public void setComp_manufacturer(String comp_manufacturer) {
        this.comp_manufacturer = comp_manufacturer;
    }

    public double getComp_price() {
        return comp_price;
    }

    /**
     * @param comp_price the comp_price to set
     */
    public void setComp_price(double comp_price) {
        this.comp_price = comp_price;
    }

    /**
     * @return the comp_type
     */
    public String getComp_type() {
        return comp_type;
    }

    /**
     * @param comp_type the comp_type to set
     */
    public void setComp_type(String comp_type) {
        this.comp_type = comp_type;
    }
    
    public String getComp_name() {
        return comp_name;
    }

    /**
     * @param comp_name the comp_name to set
     */
    public void setComp_name(String comp_name) {
        this.comp_name = comp_name;
    }
}
