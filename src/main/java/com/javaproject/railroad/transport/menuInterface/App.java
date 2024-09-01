package com.javaproject.railroad.transport.menuInterface;

import com.javaproject.railroad.transport.trains.PassengerTrain;
import com.javaproject.railroad.transport.trains.Train;

public class App {
    public static void main(String[] args) {
        Train train = TrainCreator.createNewTrain();
        if (train instanceof PassengerTrain) {
            PassengerTrainCreator passengerTrainCreator = new PassengerTrainCreator(train);
            passengerTrainCreator.callPassengerTrainMenu();
        }
    }
}


