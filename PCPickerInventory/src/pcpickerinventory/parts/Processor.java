/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpickerinventory.parts;

import pcpickerinventory.lib.Parts;
import javax.sql.*;

/**
 *
 * @author CS183P-AC1-16
 */

/*
create procedure add_processor
(
    comp_id varchar(25),
    comp_manufacturer varchar(50),
    comp_name varchar(50),
    core_clock varchar(20),
    core_num int,
    thread_num int,
    socket_ varchar(50),
    tdp int, 
    comp_price double,
    comp_type varchar(50)
)
*/

public class Processor extends pcpickerinventory.lib.PCPart {
    
    // Default Constructor
    public Processor()
    {}
    
    // Constructor Parameters
    public Processor(int _id, String _name, String _description, String _manufacturer, String _branch, int _quantity, double _price)
    {
        super(_id, _name, _description, _manufacturer, _branch, _quantity, _price);
        super.Type(Parts.Type.Processor);
    }
}
