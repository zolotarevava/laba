package checker;

import entity.Car;

public class CarCheckByBrand extends CarChecker {
    @Override
    public boolean check(Object o, Car car) {

        return o.equals(car.getBrand());
    }
}
