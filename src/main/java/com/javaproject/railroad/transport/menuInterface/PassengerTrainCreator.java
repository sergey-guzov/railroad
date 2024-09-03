package com.javaproject.railroad.transport.menuInterface;

import com.javaproject.railroad.transport.locomotives.Locomotive;
import com.javaproject.railroad.transport.locomotives.LocomotivesTypes;
import com.javaproject.railroad.transport.trains.PassengerTrain;
import com.javaproject.railroad.transport.trains.Train;
import com.javaproject.railroad.transport.wagons.PassengerWagon;
import com.javaproject.railroad.transport.wagons.PassengerWagonsTypes;

import java.util.Scanner;

import static java.lang.System.*;

public class PassengerTrainCreator {
    PassengerTrain passengerTrain;

    public PassengerTrainCreator(Train train) {
        this.passengerTrain = (PassengerTrain) train;
    }

    static Scanner sc = new Scanner(in);

    public void callPassengerTrainWagonsMenu () {
        int userInput;
        do { out.println("""
               What do you want to do next?
                        1. Add another wagon
                        2. Get locomotive information
                        3. Get train scheme
                        4. Get total number of passengers
                        5. Get total baggage weight
                        6. Get number of wagons
                        7. Sort wagons by class of comfort
                        8. Remove wagon
                        9. Finish creation""");
            userInput = sc.nextInt();
            if (userInput < 1 || userInput > 9) {
                System.out.println("Incorrect task number selected: " + userInput + "\nTry again!" );
            }
        } while (userInput < 1 || userInput > 9);
        switch (userInput) {
            case 1 -> addWagon();
            case 2 -> out.println( passengerTrain.getLocomotive().getLocomotivesType().name() + " " +
                      passengerTrain.getLocomotive().getLocomotivesType().getLoadCapacityInTons() + " tons");
            case 3 -> out.println(passengerTrain);
            case 4 -> out.println(passengerTrain.getTotalNumberOfPassengers(passengerTrain.getWagons()));
            case 5 -> out.println(passengerTrain.getTotalWeightOfBaggageInKilo(passengerTrain.getWagons()));
            case 6 -> out.println(passengerTrain.getWagons().size());
            case 7 -> out.println(passengerTrain.sortWagonsByComfortClass(passengerTrain.getWagons()));
            case 8 -> removeWagon();
            case 9 -> {
                System.out.println("Exiting the program...");
                sc.close();
                System.exit(0);
            }
        }
    }

    public void callPassengerTrainNoWagonsMenu () {
        int userInput;
        do { out.println("""
                What do you want to do next?
                1. Add wagon
                2. Get locomotive information
                3. Get train scheme""");
            userInput = sc.nextInt();
            if (userInput < 1 || userInput > 3) {
                System.out.println("Incorrect task number selected: " + userInput + "\nTry again!" );
            }
        } while (userInput < 1 || userInput > 3);
        switch (userInput) {
            case 1 -> addWagon();
            case 2 -> out.println( passengerTrain.getLocomotive().getLocomotivesType().name() + " " +
                      passengerTrain.getLocomotive().getLocomotivesType().getLoadCapacityInTons() + " tons");
            case 3 -> out.println(passengerTrain);
        }
    }


    public void callPassengerTrainMenu () {
        addLocomotive();
        do {
            if (passengerTrain.getWagons().isEmpty()) {
                callPassengerTrainNoWagonsMenu();
            } else {
                callPassengerTrainWagonsMenu();
            }

        } while (true);

    }

    public boolean isInvalidLocomotive (String locomotiveName) {
        for (LocomotivesTypes locomotive : LocomotivesTypes.values()) {
            if (locomotive.name().equals(locomotiveName)) {
                return false;
            }
        }
        return true;
    }

    public boolean isInvalidWagon (String wagonName) {
        for (PassengerWagonsTypes wagon : PassengerWagonsTypes.values()) {
            if (wagon.name().equals(wagonName)) {
                return false;
            }
        }
        return true;
    }

    public void addLocomotive () {
        out.println("What type of train do you want to create? Enter name of the locomotive");
        for (LocomotivesTypes locomotivesTypes : LocomotivesTypes.values()) {
            System.out.println("Model: " + locomotivesTypes.name() + ", MaxCapacity: " + locomotivesTypes.getLoadCapacityInTons());
        }
        String userInput;
        do {
            userInput = sc.next().toUpperCase();
            if (isInvalidLocomotive(userInput)) {
                out.println("Incorrect locomotive name input, please try again!");
            }
        } while (isInvalidLocomotive(userInput));
        passengerTrain.setLocomotive(new Locomotive(LocomotivesTypes.valueOf(userInput)));
    }

    public void addWagon () {
        out.println("What type of wagon do you want to add? Type name of wagon. Enter name of the locomotive");
        for (PassengerWagonsTypes passengerWagonsTypes : PassengerWagonsTypes.values()) {
            System.out.println("Type: " + passengerWagonsTypes.name() + ", "
                    + " Number of passengers: " + passengerWagonsTypes.getNumberOfPassengers()+ ", "
                    + " Weight of baggage for passenger: " + passengerWagonsTypes.getWeightOfBaggageForPassenger()+ ", "
                    + " Comfort class: " + passengerWagonsTypes.getLevelOfComfort()+ ", "
                    + " Max total weight: " + passengerWagonsTypes.getMaxWeightOfWagonInTons());
        }
        String userInput;
        do {
            userInput = sc.next().toUpperCase();
            if (isInvalidWagon(userInput)) {
                out.println("Incorrect wagon name input, please try again!");
            }
        } while (isInvalidWagon(userInput));
        passengerTrain.getWagons().add(new PassengerWagon(userInput));
        if (!passengerTrain.ifLocomotiveCanPullThisNumberOfWagons()){
            out.println("Can't add new wagon, because total weight of all wagons will be "
                    + passengerTrain.getTotalWeightOfAllWagons(passengerTrain.getWagons())
                    + "Locomotive total capacity is "
                    + passengerTrain.getLocomotive().getLocomotivesType().getLoadCapacityInTons());
            passengerTrain.getWagons().remove(passengerTrain.getWagons().size()-1);
        }
    }

    public void removeWagon () {
        int userInput;

        do {
            out.println("Enter number of wagon you want to remove");
            for (PassengerWagon wagon:passengerTrain.getWagons()) {
                out.print("[" + passengerTrain.getWagons().indexOf(wagon) + " " + wagon.getPassengerWagonsType().name()+ "]");
            }
            userInput = sc.nextInt();
            if (userInput < 0 || userInput > passengerTrain.getWagons().size()-1){
                out.println("Selected wagon doesn't exist");
            }
        } while (userInput < 0 || userInput > passengerTrain.getWagons().size()-1);

        passengerTrain.getWagons().remove(userInput);
    }
}
