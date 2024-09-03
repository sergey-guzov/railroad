**Task.** Create a console application that meets the following requirements:
- Each class should have a meaningful name and informative composition.
- Use OOP capabilities: classes, inheritance, polymorphism, encapsulation.
- Inheritance should be used only when it makes sense.
- When coding, code conventions should be used.
- Classes should be correctly laid out in packages. The console menu should be minimal. Files can be used to store initialization parameters.

Task topic: transport
- Define the hierarchy of rolling stock of railway transport.
- Create a passenger train. Calculate the total number of passengers and baggage.
- Sort train cars based on comfort level.
- Find cars in the train that correspond to the given range of parameters for the number of passengers.

> [!NOTE]
> Passengers trains logic was implemented only for now. Logic for Cargo trains (out of required scope) will be implemented later.

The app is a simple creator of the Passenger and Cargo trains. User can select locomotives for thier train from the list. Every locomotive has it's own max load capacity in tons - it's a max weight that locomotive can pull. Every wagon has their own max weight. So sum of all wagons weights must be less that max load capacity of train. All wagon are separated on two types: CargoWagons and PassengerWagons. One locomotive can has wagons of only one type (no way to create train with cargo and passenger wagons). During creation a user can get characteristics about wagons, locomotives, total wagons wight, etc. User can add/remove wagons in any order. 

> [!NOTE]
> Programm starts in the `App` class of the **menuInterface** package

**App structure**

All classes are located in different packages based on common logic:
- Package **menuInterface** contains classes, which purpose is realization of the programm console interface
   - `App` class is used to start the app and create firs object TrainCreator
   - `TrainCreator` is a class of the menuInterface package where triggered first menu interface - a user get ability to select what train type they want to create. Based on their selection Passaenger/Cargo train will be created
   - `PassengerTrainCreator` is a class of the menuInterface package where triggered second menu interface - Creation of the Passenger train. Menu here has 3 states. 1st state - train is created, but no locomotives created. 2d state - user selected locomotive but no any wagons added. 3d state - at least one wagon added to the train. In this class a user gets various options for Passenger train creation/editing
-  Package **locomotives** contains classes, which purpose is store the data about available locomotives
   - Enum `LocomotiveTypes` contains all possible models of locomotives available. Every model store has own characteristics, affected their max load capacity
   - Class `Locomotive` is used to create instanse of the specific locomotive type for user's train
-  Package **wagons** contains classes, which purpose is store the data about available wagons
   - Enum `PassengerWagonsTypes` contains all possible types of passenger wagons available. Every model store has own characteristics - number of passengers, max baggage for passenger, level of comfort, max weight. These characteristics are used for max load capacity checks and different filters
   - Class `PassengerWagon` is used to create instanse of the specific wagon type for user's train
-  Package **trains** contains classes, which purpose is store the data about available created trains (locomotive + wagons)
   - SuperClass `Train` contains base characterisctics of the train common both for Cargo and Passenger trains: locomotive, number of wagons plus base implementation of the method of check if it's available to add new wagon without overhead of max capacity
   - Class `PassengerTrain` extends `Train` and add parameterized list PassengerWagon as property (to avoid adding Cargo wagons) and implemets different filter and overrride check for max capacity from super class.
