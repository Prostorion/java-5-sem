package lab.O7seventh;

import lab.O6sixth.trains.Train;
import lab.O6sixth.trains.TrainCar;
import lab.O6sixth.trains.implementations.CargoTrain;
import lab.O6sixth.trains.implementations.PeopleTrain;

import java.util.Arrays;
import java.util.Random;

import static lab.O6sixth.SixthLabClass.trainCarsGenerator;

public class SeventhLabClass {
    /*
    variant 20
    C2 = 0 -> List
    C3 = 2 -> Двозв’язний список
     */
    public static void main(String[] args) {
        Train[] trains = trainsGenerator(3);
        TrainList list = new TrainList(trains);
        System.out.println("GET (1): \n" + list.get(1));
        System.out.println("SET (1)): prev:\n" + list.set(1, trainGenerator(2)));
        System.out.println("curr:\n" + list.get(1));
    }

    private static Train[] trainsGenerator(int numberOfTrains) {
        Random random = new Random();
        Train[] trains = new Train[numberOfTrains];
        for (int i = 0; i < numberOfTrains; i++) {
            trains[i] = trainGenerator(random.nextInt(8) + 1);
        }
        return trains;
    }

    private static Train trainGenerator(int numberOfTrainCars) {
        Random random = new Random();
        int typeNumber = random.nextInt(3);
        TrainCar.TYPE type;
        if (typeNumber == 0) {
            type = TrainCar.TYPE.CARGO;
        } else if (typeNumber == 1) {
            type = TrainCar.TYPE.COMPARTMENT;
        } else {
            type = TrainCar.TYPE.REVERSED_SEAT;
        }
        TrainCar[] trainCars = trainCarsGenerator(type, numberOfTrainCars);
        int locomotiveCapacity = Arrays.stream(trainCars).mapToInt(TrainCar::getCarryingCapacity).sum() / 100 * 100 + 500;
        return typeNumber == 0 ? new CargoTrain(locomotiveCapacity, trainCars) : new PeopleTrain(locomotiveCapacity, trainCars);
    }


}
