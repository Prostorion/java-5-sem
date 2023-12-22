package lab.O6sixth.trains.implementations;

import lab.O6sixth.trains.Locomotive;
import lab.O6sixth.trains.Train;
import lab.O6sixth.trains.TrainCar;

import java.util.Arrays;
import java.util.Objects;

public class PeopleTrain implements Train {
    private final Locomotive locomotive;
    private TrainCar[] trainCars;

    public PeopleTrain(Locomotive locomotive, TrainCar[] trainCars) {
        if (!isValid(trainCars, locomotive.getCarryingCapacity())) throw new IllegalArgumentException();
        this.locomotive = locomotive;
        this.trainCars = trainCars;
    }

    public PeopleTrain(int carryingCapacity, TrainCar[] trainCars) {
        if (!isValid(trainCars, carryingCapacity)) throw new IllegalArgumentException();
        this.locomotive = new Locomotive(carryingCapacity);
        this.trainCars = trainCars;
    }

    private boolean isValid(TrainCar[] trainCars, int carryingCapacity) {
        int totalCapacity = 0;
        for (TrainCar trainCar : trainCars) {
            if (trainCar.getType() == TrainCar.TYPE.CARGO) {
                return false;
            }
            totalCapacity += trainCar.getCapacity();
        }
        return totalCapacity <= carryingCapacity;
    }

    public PeopleTrain(int carryingCapacityLocomotive, TrainCar.TYPE type, int numberOfTrainCars, int carryingCapacityTrainCars) {
        if (type == TrainCar.TYPE.CARGO || carryingCapacityLocomotive < numberOfTrainCars * carryingCapacityTrainCars)
            throw new IllegalArgumentException();
        this.locomotive = new Locomotive(carryingCapacityLocomotive);
        this.trainCars = new TrainCar[numberOfTrainCars];
        for (int i = 0; i < numberOfTrainCars; i++) {
            this.trainCars[i] = new TrainCar(type, carryingCapacityTrainCars);
        }
    }

    @Override
    public Locomotive getLocomotive() {
        return locomotive;
    }

    @Override
    public TrainCar[] getTrainCars() {
        return trainCars;
    }

    public void setTrainCars(TrainCar[] trainCars) {
        this.trainCars = trainCars;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("      ____\n" +
                " _____|\uD83D\uDE00| PEOPLE TRAIN\n" +
                "[" + String.format("%8d", this.locomotive.getCarryingCapacity()) + "]");
        for (TrainCar trainCar : this.trainCars) {
            str.append("-[").append(trainCar.getType()).append(" ").append(trainCar.getCarryingCapacity()).append("]");
        }
        return str.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeopleTrain that = (PeopleTrain) o;
        return Objects.equals(locomotive, that.locomotive) && Arrays.equals(trainCars, that.trainCars);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(locomotive);
        result = 31 * result + Arrays.hashCode(trainCars);
        return result;
    }
}
