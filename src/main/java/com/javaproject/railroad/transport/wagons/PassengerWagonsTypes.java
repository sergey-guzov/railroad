package com.javaproject.railroad.transport.wagons;
public enum PassengerWagonsTypes {
    SV (18, 100, 47, "FIRST"),
    KUPE(36, 50,50,"SECOND"),
    PLASCART(54,40,52,"THIRD"),
    SIT_PLACE (64, 30,46, "FOURTH");


    private final int numberOfPassengers;
    private final int weightOfBaggageForPassenger;
    private final int maxWeightOfWagonInTons;
    private final LevelOfComfort levelOfComfort;



    public enum LevelOfComfort {
        FIRST,SECOND,THIRD, FOURTH
    }

    PassengerWagonsTypes (int numberOfPassengers, int weightOfBaggageForPassenger, int maxWeightOfWagonInTons, String comfortLevel) {
        this.numberOfPassengers = numberOfPassengers;
        this.weightOfBaggageForPassenger = weightOfBaggageForPassenger;
        this.maxWeightOfWagonInTons = maxWeightOfWagonInTons;
        this.levelOfComfort = LevelOfComfort.valueOf(comfortLevel);

    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public int getWeightOfBaggageForPassenger() {
        return weightOfBaggageForPassenger;
    }

    public int getMaxWeightOfWagonInTons() {
        return maxWeightOfWagonInTons;
    }
    public LevelOfComfort getLevelOfComfort() {
        return levelOfComfort;
    }


}
