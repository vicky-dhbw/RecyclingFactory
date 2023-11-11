package org.recycling.observer;

import org.recycling.FactoryWorker;
import org.recycling.chainOfResponsibility.SeparationProcess;

import java.util.List;

public class ControlRoom implements ISensorListener {
    private FactoryWorker worker;
    private List<SeparationProcess> separationProcesses;

    public ControlRoom(List<SeparationProcess> separationProcesses) {
        this.separationProcesses = separationProcesses;
    }

    @Override
    public void boxIsFull(int boxID) {
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("ALARM !!!!!!! BOX with ID " + boxID + " is full.....");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------");

        worker.installNewBox(separationProcesses, boxID, this);

    }

    public FactoryWorker getWorker() {
        return worker;
    }

    public void setWorker(FactoryWorker worker) {
        this.worker = worker;
    }

    public List<SeparationProcess> getSeparationProcesses() {
        return separationProcesses;
    }

    public void setSeparationProcesses(List<SeparationProcess> separationProcesses) {
        this.separationProcesses = separationProcesses;
    }

}
