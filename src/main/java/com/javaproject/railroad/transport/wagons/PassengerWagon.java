package com.javaproject.railroad.transport.wagons;

public class PassengerWagon {

    private PassengerWagonsTypes passengerWagonsType;
    public PassengerWagon(String passengerWagonType) {
        this.passengerWagonsType = PassengerWagonsTypes.valueOf(passengerWagonType);
    }
    public PassengerWagonsTypes getPassengerWagonsType() {
        return passengerWagonsType;
    }

    @Override
    public String toString() {
        return "[" +
                passengerWagonsType.name() +
                ']';
    }
}
