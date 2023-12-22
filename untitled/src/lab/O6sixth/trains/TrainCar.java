package lab.O6sixth.trains;

import java.util.Objects;

public class TrainCar {
    public enum TYPE {
        COMPARTMENT,
        REVERSED_SEAT,
        CARGO

    }

    private final TYPE type;
    private final int capacity;
    private final int carryingCapacity;


    public TrainCar(TYPE type, int carryingCapacity) {
        if (type == TYPE.CARGO) {
            this.type = type;
            this.carryingCapacity = carryingCapacity;
            this.capacity = 0;
        } else {
            this.type = type;
            this.capacity = carryingCapacity / 120;
            this.carryingCapacity = carryingCapacity;
        }
    }

    public TYPE getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrainCar trainCar = (TrainCar) o;
        return capacity == trainCar.capacity && carryingCapacity == trainCar.carryingCapacity && type == trainCar.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, capacity, carryingCapacity);
    }
}
