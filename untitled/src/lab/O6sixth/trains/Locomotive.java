package lab.O6sixth.trains;

import java.util.Objects;

public class Locomotive {
    private final int carryingCapacity;

    public Locomotive(int carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locomotive that = (Locomotive) o;
        return carryingCapacity == that.carryingCapacity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(carryingCapacity);
    }
}
