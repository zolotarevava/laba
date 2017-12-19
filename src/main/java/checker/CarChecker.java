package checker;

import entity.Car;

public abstract class CarChecker implements IChecker<Car> {
    public abstract boolean check(Object o, Car car);
}
