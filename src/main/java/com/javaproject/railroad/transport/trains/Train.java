package com.javaproject.railroad.transport.trains;

import com.javaproject.railroad.transport.locomotives.Locomotive;

public class Train {
    private Locomotive locomotive;
    private int numberOfWagons;
    private double maxTrainWeightInTons;

    public Locomotive getLocomotive() {
        return locomotive;
    }

    public int getNumberOfWagons() {
        return numberOfWagons;
    }

    public double getMaxTrainWeightInTons() {
        return maxTrainWeightInTons;
    }

    public Locomotive getLocomotives() {
        return locomotive;
    }

    public void setLocomotive(Locomotive locomotive) {
        this.locomotive = locomotive;
    }

    public void setNumberOfWagons(int numberOfWagons) {
        this.numberOfWagons = numberOfWagons;
    }

    public void setMaxTrainWeightInTons(double maxTrainWeightInTons) {
        this.maxTrainWeightInTons = maxTrainWeightInTons;
    }


    public boolean ifLocomotiveCanPullThisNumberOfWagons () {

        return locomotive.getLocomotivesType().getLoadCapacityInTons() > maxTrainWeightInTons;

    }

    @Override
    public String toString() {
        return "YourTrain:" + locomotive
                ;
    }
}
