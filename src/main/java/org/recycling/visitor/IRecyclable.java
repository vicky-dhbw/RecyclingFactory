package org.recycling.visitor;

public interface IRecyclable {
    void accept(Box box);
    RecyclableType getType();
    void setType(RecyclableType type);
}
