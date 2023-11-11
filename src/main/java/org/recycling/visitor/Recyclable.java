package org.recycling.visitor;

public class Recyclable implements IRecyclable {
    private RecyclableType type;
    @Override
    public void accept(Box box) {
        box.visit(this);
        System.out.println("Box has ID: "+box.hashCode());
    }

    public RecyclableType getType() {
        return type;
    }

    public void setType(RecyclableType type) {
        this.type = type;
    }


}
