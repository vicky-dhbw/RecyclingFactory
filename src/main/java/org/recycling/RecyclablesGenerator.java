package org.recycling;

import org.recycling.visitor.IRecyclable;
import org.recycling.visitor.Recyclable;
import org.recycling.visitor.RecyclableType;

import java.util.ArrayList;
import java.util.List;

public class RecyclablesGenerator {

    public static List<IRecyclable> generateRandomRecyclables(){
        List<IRecyclable> recyclables=new ArrayList<>();

        for(int i=0;i<Configuration.INSTANCE.numberOfRecyclablesOnConveyor;i++){
            IRecyclable recyclable=new Recyclable();
            recyclable.setType(RecyclableType.generateRandomType());
            recyclables.add(recyclable);

        }

        return recyclables;
    }

    public static List<IRecyclable> generateRandomPaperRecyclables(){
        List<IRecyclable> recyclablesPapers=new ArrayList<>();

        for(int i=0;i<Configuration.INSTANCE.numberOfRecyclablesOnConveyor;i++){
            IRecyclable paper=new Recyclable();
            paper.setType(RecyclableType.P);
            recyclablesPapers.add(paper);

        }

        return recyclablesPapers;
    }
    public static List<IRecyclable> generateRandomPlasticRecyclables(){
        List<IRecyclable> recyclablesPlastics=new ArrayList<>();

        for(int i=0;i<Configuration.INSTANCE.numberOfRecyclablesOnConveyor;i++){
            IRecyclable plastic=new Recyclable();
            plastic.setType(RecyclableType.M);
            recyclablesPlastics.add(plastic);

        }

        return recyclablesPlastics;
    }

    public static List<IRecyclable> generateRandomMetalRecyclables(){
        List<IRecyclable> recyclablesMetals=new ArrayList<>();

        for(int i=0;i<Configuration.INSTANCE.numberOfRecyclablesOnConveyor;i++){
            IRecyclable metal=new Recyclable();
            metal.setType(RecyclableType.S);
            recyclablesMetals.add(metal);

        }

        return recyclablesMetals;
    }
}
