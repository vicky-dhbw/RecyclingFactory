package org.recycling;

import org.recycling.chainOfResponsibility.SeparationProcess;
import org.recycling.visitor.Box;
import org.recycling.observer.ISensorListener;

import java.util.List;

public class FactoryWorker {

    public void installNewBox(List<SeparationProcess>separationProcesses, int boxID, ISensorListener listener){
        for(SeparationProcess process:separationProcesses){
            if(process.getBox().hashCode()==boxID){
                Box box=new Box();
                box.getSensor().addListener(listener);
                System.out.println("box capacity: "+process.getBox().getCapacity());
                process.setBox(box);
                System.out.println("worker replaced filled box with ID: "+boxID+" , with a new box with ID: "+box.hashCode()+" at process unit: "+process.hashCode());

                System.out.println();

            }
        }
    }
}
