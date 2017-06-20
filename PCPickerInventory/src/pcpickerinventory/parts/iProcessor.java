/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpickerdesktop.parts;

/**
 *
 * @author CS183P-AC1-16
 */
public interface iProcessor {
    public int CoreClock();
    public void CoreClock(int _coreClock);
    public int CoreNum();
    public void CoreNum(int _coreNum);
    public int Thread();
    public void Thread(int _thread);
    public int Socket();
    public void Socket(int _socket);
    public int TDP();
    public void TDP(int _tdp);
}
