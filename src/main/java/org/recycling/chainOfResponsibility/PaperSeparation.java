package org.recycling.chainOfResponsibility;

import org.recycling.visitor.Box;
import org.recycling.visitor.IRecyclable;
import org.recycling.visitor.RecyclableType;

public class PaperSeparation extends SeparationProcess {

    @Override
    public void separate(IRecyclable recyclable) {
        if(canSeparateRecyclable(recyclable)){
            System.out.println("separating paper......");
            System.out.println("process carried out at separation unit ID: "+this.hashCode());
            recyclable.accept(getBox());
            getBox().getRecyclables().add(recyclable);
        }
        else {
            super.separate(recyclable);
        }

    }


    public Box getBox() {
        return super.getBox();
    }

    public void setBox(Box box) {
       super.setBox(box);
    }
    public boolean canSeparateRecyclable(IRecyclable recyclable){
        return recyclable.getType()== RecyclableType.P;
    }
}
