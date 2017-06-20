/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpickerinventory;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author appbenigno
 */
public class flags {
    private List<String> flaggers = new ArrayList<>();
    
    public flags(){
        
    }
    
    public boolean isRaised(String _flagString){
        boolean result = false;
        if (flaggers.contains(_flagString)){
            result = true;
        }
        else{
            result = false;
        }
        return result;
    }
    public void Raise(String _flagString){
        if (!flaggers.contains(_flagString)){
            flaggers.add(_flagString);
        }
    }
    public void Destroy(String _flagString){
        if (flaggers.contains(_flagString)){
            flaggers.remove(_flagString);
        }
    }
    public void Clear(){
        flaggers.clear();
    }
}
