package org.recycling;

import org.recycling.chainOfResponsibility.MetalSeparation;
import org.recycling.chainOfResponsibility.PaperSeparation;
import org.recycling.chainOfResponsibility.SeparationProcess;
import org.recycling.visitor.IRecyclable;

import java.util.ArrayList;
import java.util.List;

public class Conveyor {

    private List<IRecyclable> recyclables;
    private List<SeparationProcess> separationProcesses;

    public Conveyor(){
        recyclables=new ArrayList<>();
        separationProcesses=new ArrayList<>();

    }

    public List<IRecyclable> getRecyclables() {
        return recyclables;
    }
    public void setRecyclables(List<IRecyclable> recyclables){
        this.recyclables=recyclables;
    }

    public List<SeparationProcess> getSeparationProcesses() {
        return separationProcesses;
    }

    public void setSeparationProcesses(List<SeparationProcess> separationProcesses) {
        this.separationProcesses = separationProcesses;
    }
    public SeparationProcess getMetalSeparationProcess(){
        for(SeparationProcess separationProcess:separationProcesses){
            if(separationProcess instanceof MetalSeparation){
                return separationProcess;
            }
        }
        return null;
    }
    public SeparationProcess getPaperSeparationProcess(){
        for(SeparationProcess separationProcess:separationProcesses){
            if(separationProcess instanceof PaperSeparation){
                return separationProcess;
            }
        }
        return null;
    }
}
