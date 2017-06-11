package pcpicker;

import javax.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Order_Parts")
public class Order_Parts 
{

    /**
     * @return the order_id
     */
    public int getOrder_id() {
        return order_id;
    }

    /**
     * @param order_id the order_id to set
     */
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    /**
     * @return the part_id
     */
    public String getComp_id() {
        return part_id;
    }

    /**
     * @param part_id the part_id to set
     */
    public void setComp_id(String part_id) {
        this.part_id = part_id;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @XmlElement(name = "order_id")
    private int order_id;    
    @XmlElement(name = "part_id")
    private String part_id;    
    @XmlElement(name = "quantity")
    private int quantity;
}