package com.javaproject.railroad.transport.locomotives;

public enum LocomotivesTypes {
    DF1(400, 100);

    private final double maxLoadCapacityInTons;
    private final double locomotiveWeight;

    LocomotivesTypes(double maxLoadCapacityInTons, double locomotiveWeight) {
        this.maxLoadCapacityInTons = maxLoadCapacityInTons;
        this.locomotiveWeight = locomotiveWeight;
    }

    public double getLoadCapacityInTons() {
        return maxLoadCapacityInTons - locomotiveWeight;
    }

}
