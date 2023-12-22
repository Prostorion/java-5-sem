package lab.O6sixth;


    /*
    variant 20
    C13 = 7
    Визначити ієрархію рухомого складу залізничного транспорту.
    Створити пасажирський потяг. Порахувати загальну чисельність пасажирів і багажу в потязі.
    Провести сортування вагонів потягу за рівнем комфортності.
    Знайти вагон в потязі, що відповідає заданому діапазону кількості пасажирів.

     */

import lab.O6sixth.trains.Train;
import lab.O6sixth.trains.TrainCar;
import lab.O6sixth.trains.implementations.CombinedTrain;

import java.util.*;

public class SixthLabClass {
    public static void main(String[] args) {
        List<TrainCar> trainCars = new ArrayList<>();
        trainCars.addAll(Arrays.stream(trainCarsGenerator(TrainCar.TYPE.COMPARTMENT, 2)).toList());
        trainCars.addAll(Arrays.stream(trainCarsGenerator(TrainCar.TYPE.REVERSED_SEAT, 2)).toList());
        trainCars.addAll(Arrays.stream(trainCarsGenerator(TrainCar.TYPE.CARGO, 2)).toList());
        trainCars.addAll(Arrays.stream(trainCarsGenerator(TrainCar.TYPE.COMPARTMENT, 2)).toList());
        trainCars.addAll(Arrays.stream(trainCarsGenerator(TrainCar.TYPE.REVERSED_SEAT, 2)).toList());
        trainCars.addAll(Arrays.stream(trainCarsGenerator(TrainCar.TYPE.CARGO, 2)).toList());
        int locomotiveCapacity = trainCars.stream().mapToInt(TrainCar::getCarryingCapacity).sum() / 100 * 100 + 500;
        Train combinedTrain = new CombinedTrain(locomotiveCapacity, trainCars.toArray(new TrainCar[0]));
        System.out.println(combinedTrain);
        sortTrainCars(combinedTrain.getTrainCars());
        System.out.println(combinedTrain);
    }

    public static TrainCar[] trainCarsGenerator(TrainCar.TYPE type, int numberOfTrainCars) {
        TrainCar[] trainCars = new TrainCar[numberOfTrainCars];
        Random random = new Random();
        for (int i = 0; i < trainCars.length; i++) {
            trainCars[i] = new TrainCar(type, 500 + random.nextInt(10000));
        }
        return trainCars;
    }

    private static void sortTrainCars(TrainCar[] trainCars) {
        Arrays.sort(trainCars, Comparator.<TrainCar, Integer>comparing(tc -> {
            if (tc.getType() == TrainCar.TYPE.COMPARTMENT) return 0;
            if (tc.getType() == TrainCar.TYPE.REVERSED_SEAT) return 1;
            return 2;
        }).thenComparing(TrainCar::getCarryingCapacity));
    }


}
