package comparator;

import entity.Car;

import java.util.Comparator;

public class CarSerialNumberComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return o1.getSerialNumber() - o2.getSerialNumber();
    }
}
