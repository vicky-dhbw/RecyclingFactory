package org.recycling;

import org.recycling.chainOfResponsibility.MetalSeparation;
import org.recycling.chainOfResponsibility.PaperSeparation;
import org.recycling.chainOfResponsibility.PlasticSeparation;
import org.recycling.chainOfResponsibility.SeparationProcess;
import org.recycling.observer.ControlRoom;
import org.recycling.visitor.Box;
import org.recycling.visitor.IRecyclable;

import java.util.ArrayList;
import java.util.List;

public class RecyclingFactory {
    private final Conveyor conveyor;
    private final List<Box> filledBoxes;

    private ControlRoom controlRoom;
    public RecyclingFactory(){
        conveyor=new Conveyor();
        filledBoxes=new ArrayList<>();
    }

    public Conveyor getConveyor() {
        return conveyor;
    }

    public List<Box> getFilledBoxes() {
        return filledBoxes;
    }

    public void installSeparationProcesses(){
        SeparationProcess paperSeparationProcess=new PaperSeparation();
        SeparationProcess plasticSeparationProcess=new PlasticSeparation(paperSeparationProcess);
        SeparationProcess metalSeparationProcess=new MetalSeparation(plasticSeparationProcess);

        conveyor.getSeparationProcesses().add(paperSeparationProcess);
        conveyor.getSeparationProcesses().add(plasticSeparationProcess);
        conveyor.getSeparationProcesses().add(metalSeparationProcess);
    }

    public ControlRoom getControlRoom() {
        return controlRoom;
    }
    public void installSensors(){
        for(SeparationProcess separationProcess: conveyor.getSeparationProcesses()){
            separationProcess.getBox().getSensor().addListener(controlRoom);
        }
    }

    public void startConveyor(){
        for(IRecyclable recyclable: conveyor.getRecyclables()){
            for(SeparationProcess process: conveyor.getSeparationProcesses()){

                Box box=process.getBox();

                if(box.getCapacity()==Configuration.INSTANCE.numberOfRecyclablesInBox){
                    box.getSensor().setAlarm();
                    filledBoxes.add(box);
                }
            }
            conveyor.getMetalSeparationProcess().separate(recyclable);
            System.out.println("--------------------------------------------------");

        }
    }

    public void setControlRoom(List<SeparationProcess> separationProcesses) {
        controlRoom=new ControlRoom(separationProcesses);
    }
}
