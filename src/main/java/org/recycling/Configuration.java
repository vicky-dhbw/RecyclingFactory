package org.recycling;

public enum Configuration {
    INSTANCE;

    public final int numberOfRecyclablesInBox=1000;

    public int getNumberOfRecyclablesOnConveyor() {
        return numberOfRecyclablesOnConveyor;
    }

    public void setNumberOfRecyclablesOnConveyor(int numberOfRecyclablesOnConveyor) {
        this.numberOfRecyclablesOnConveyor = numberOfRecyclablesOnConveyor;
    }

    public int numberOfRecyclablesOnConveyor;

}
