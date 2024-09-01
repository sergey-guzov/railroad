package com.javaproject.railroad.transport.locomotives;

public class Locomotive {
    private LocomotivesTypes locomotivesType;

    public Locomotive(LocomotivesTypes locomotivesType) {
        this.locomotivesType = locomotivesType;
    }

    public LocomotivesTypes getLocomotivesType() {
        return locomotivesType;
    }

    @Override
    public String toString() {
        return "Locomotive{" + locomotivesType +
                '}';
    }
}
