package org.recycling.chainOfResponsibility;

import org.recycling.visitor.IRecyclable;

public interface ISeparationProcess {
    void separate(IRecyclable recyclable);
}
