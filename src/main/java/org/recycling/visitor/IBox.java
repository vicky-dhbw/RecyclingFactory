package org.recycling.visitor;

import org.recycling.visitor.IRecyclable;

public interface IBox {
    void visit(IRecyclable recyclable);
}
