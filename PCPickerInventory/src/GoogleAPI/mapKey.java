/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GoogleAPI;

/**
 *
 * @author appbenigno
 */
public class mapKey {
    private String keyName = "&key=";
    private String keyCode = "";
    
    public mapKey(){
    }
    public mapKey(String _code){
        keyCode = _code;
    }
    
    public String name()
    {
        return keyName;
    }
    public void name(String _name)
    {
        keyName = _name;
    }
    public String code()
    {
        return keyCode;
    }
    public void code(String _code)
    {
        keyCode = _code;
    }
    public String value()
    {
        return this.name() + this.code();
    }
}
