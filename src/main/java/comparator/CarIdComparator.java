package comparator;

import entity.Car;

import java.util.Comparator;

public class CarIdComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        return (o1.getId() - o2.getId());
    }
}
