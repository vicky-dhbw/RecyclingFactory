package org.recycling.visitor;

import org.recycling.observer.Sensor;

import java.util.ArrayList;
import java.util.List;

public class Box implements IBox {
    private int capacity;
    private Sensor sensor;
    private final List<IRecyclable> recyclables;

    public Box(){
        capacity=0;
        sensor=new Sensor(this.hashCode());
        recyclables=new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }


    public void setCapacity(int capacity){
        this.capacity=capacity;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public List<IRecyclable> getRecyclables() {
        return recyclables;
    }

    public void setSensor(Sensor sensor){
        this.sensor=sensor;
    }
    @Override
    public void visit(IRecyclable recyclable) {
        capacity++;
        System.out.println("{ recyclable of type "+ recyclable.getType().toString()+" dropped into box....}");
    }
}
