package org.recycling.chainOfResponsibility;

import org.recycling.visitor.Box;
import org.recycling.visitor.IRecyclable;

public class SeparationProcess implements ISeparationProcess {
    private SeparationProcess successor;
    private Box box;

    public SeparationProcess getSuccessor() {
        return successor;
    }

    public SeparationProcess(){
        box=new Box();
    }

    public void setSuccessor(SeparationProcess successor) {
        this.successor = successor;
    }

    @Override
    public void separate(IRecyclable recyclable) {
        if(getSuccessor()!=null){
            getSuccessor().separate(recyclable);
        }
    }

    public boolean canSeparateRecyclable(IRecyclable recyclable){
        return false;
    }

    public Box getBox() {
        return box;
    }

    public void setBox(Box box) {
        this.box = box;
    }
}
