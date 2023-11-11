package org.recycling.visitor;

import java.util.Random;

public enum RecyclableType {
    P,
    M,
    S;

    public static RecyclableType generateRandomType() {
        RecyclableType[] values = RecyclableType.values();
        int length = values.length;
        int randIndex = new Random().nextInt(length);
        return values[randIndex];
    }
}
