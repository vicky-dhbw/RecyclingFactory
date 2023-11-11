package org.recycling.observer;

import java.util.ArrayList;
import java.util.List;

public class Sensor {

    private final int boxID;
    private final List<ISensorListener> listeners;
    public Sensor(int boxID){
        this.boxID=boxID;
        listeners=new ArrayList<>();
    }
    public void addListener(ISensorListener listener){
        listeners.add(listener);
    }
    public void removeListener(ISensorListener listener){
        listeners.remove(listener);
    }
    public List<ISensorListener> getListeners() {
        return listeners;
    }
    public void setAlarm(){
        for(ISensorListener listener:listeners){
            listener.boxIsFull(boxID);
        }
    }

    public int getBoxID() {
        return boxID;
    }
}
