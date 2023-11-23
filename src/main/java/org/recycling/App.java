package org.recycling;

import org.recycling.chainOfResponsibility.SeparationProcess;
import org.recycling.visitor.Box;

public class App {
    public static void main(String[] args){

        RecyclingFactory recyclingFactory=new RecyclingFactory();
        FactoryWorker worker=new FactoryWorker();

        recyclingFactory.installSeparationProcesses();
        recyclingFactory.setControlRoom(recyclingFactory.getConveyor().getSeparationProcesses());
        recyclingFactory.getControlRoom().setWorker(worker);
        recyclingFactory.installSensors();

        Configuration.INSTANCE.setNumberOfRecyclablesOnConveyor(5000); //just a comment

        recyclingFactory.getConveyor().setRecyclables(RecyclablesGenerator.generateRandomPaperRecyclables());
        recyclingFactory.startConveyor();

        System.out.println();
        for(Box box:recyclingFactory.getFilledBoxes()){
            System.out.println("Box with ID: "+box.hashCode()+" has capacity: "+box.getCapacity());
        }

        for(SeparationProcess separationProcess:recyclingFactory.getConveyor().getSeparationProcesses()){
            System.out.println("Box with ID: "+separationProcess.getBox().hashCode()+" has capacity: "+separationProcess.getBox().getCapacity());
        }

    }
}
