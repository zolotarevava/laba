package checker;

import entity.Car;

public class CarCheckById extends CarChecker {
    @Override
    public boolean check(Object o, Car car) {
        return o.equals(car.getId());
    }
}
