package com.javaproject.railroad.transport.trains;

import com.javaproject.railroad.transport.wagons.PassengerWagon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class PassengerTrain extends Train {

    private ArrayList<PassengerWagon> wagons = new ArrayList<>();

    public ArrayList<PassengerWagon> getWagons() {
        return wagons;
    }

    public int getTotalNumberOfPassengers (ArrayList<PassengerWagon> wagons) {
        int totalNumberOfPassengers = 0;
        for (PassengerWagon wagon: wagons) {
            totalNumberOfPassengers = totalNumberOfPassengers + wagon.getPassengerWagonsType().getNumberOfPassengers();
        }
        return totalNumberOfPassengers;
    }
    public int getTotalWeightOfBaggageInKilo (ArrayList<PassengerWagon> wagons) {
        int totalWeightOfBaggageInKilo = 0;
        for (PassengerWagon wagon: wagons) {
            totalWeightOfBaggageInKilo = totalWeightOfBaggageInKilo +
                    (wagon.getPassengerWagonsType().getWeightOfBaggageForPassenger()*
                            wagon.getPassengerWagonsType().getNumberOfPassengers());
        }
        return totalWeightOfBaggageInKilo;
    }

    public int getTotalWeightOfAllWagons (ArrayList<PassengerWagon> wagons) {
        int totalWeightOfAllWagons = 0;
        for (PassengerWagon wagon: wagons) {
            totalWeightOfAllWagons = totalWeightOfAllWagons +
                    wagon.getPassengerWagonsType().getMaxWeightOfWagonInTons();
        }
        return totalWeightOfAllWagons;
    }

    public ArrayList<PassengerWagon> sortWagonsByComfortClass (ArrayList<PassengerWagon> wagons) {
        return (ArrayList<PassengerWagon>) wagons.stream().sorted(Comparator.comparing(w -> w.getPassengerWagonsType()
                                                                    .getLevelOfComfort())).collect(Collectors.toList());
    }



    public boolean ifLocomotiveCanPullThisNumberOfWagons () {

        return getLocomotive().getLocomotivesType().getLoadCapacityInTons() > getTotalWeightOfAllWagons(wagons);

    }

    @Override
    public String toString() {
        return super.toString() + '{' +
                "wagons=" + wagons +
                '}';
    }
}
