package com.javaproject.railroad.transport.menuInterface;

import com.javaproject.railroad.transport.trains.CargoTrain;
import com.javaproject.railroad.transport.trains.PassengerTrain;
import com.javaproject.railroad.transport.trains.Train;

import java.util.Scanner;

public class TrainCreator {

    public static Train createNewTrain () {
        Scanner sc = new Scanner(System.in);
        int userSelection;
        System.out.println("Hello, welcome to the RailRoad transport creator!");
        do {
            System.out.println("""
                    What type of train do you want to create?
                     1. Passenger train
                     2. Cargo train
                     3. Exit""");

            userSelection = sc.nextInt();
            System.out.println(userSelection);
            if (userSelection < 1 || userSelection > 3) {
                System.out.println("Incorrect task number selected: " + userSelection + "\nTry again!" );
            }
        } while (userSelection < 1 || userSelection > 3);

        switch (userSelection) {
            case 1 -> {
                return new PassengerTrain();
            }
            case 2 -> {
                System.out.println("Cargo trains creation not implemented yet. Follow feature updates!");
                System.out.println("Exiting the program...");
                sc.close();
                System.exit(0);
            }
            case 3 -> {
                System.out.println("Exiting the program...");
                sc.close();
                System.exit(0);
            }
        }
        return null;
    }
}
