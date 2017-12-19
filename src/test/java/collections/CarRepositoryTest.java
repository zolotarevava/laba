package collections;

import entity.Car;
import entity.Person;
import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

public class CarRepositoryTest {

    @Test
    public void addCar() throws Exception {

        CarRepository carRepository = new CarRepository();

        Car car1 = new Car("Toyota","corolla",123);
        Car car2 = new Car("Toyota","camry", 456);
        Car car3 = new Car("Hyundai","solaris", 789);

        carRepository.add(car1);
        carRepository.add(car2);
        carRepository.add(car3);

        Assert.assertEquals("ErrorTestAdd",carRepository.getRepository()[0],car1);
    }

    @Test
    public void removeCar() throws Exception{

        CarRepository carRepository = new CarRepository();

        Car car1 = new Car("Toyota","corolla",123);
        Car car2 = new Car("Toyota","camry", 456);
        Car car3 = new Car("Hyundai","solaris", 789);

        carRepository.add(car1);
        carRepository.add(car2);
        carRepository.add(car3);

        carRepository.remove(0);

        Assert.assertEquals("ErrorTestRemove",carRepository.getRepository()[0],car2);
    }

    @Test
    public void sortById() throws Exception {

        CarRepository carRepository  = new CarRepository();

        Car car1 = new Car("Toyota","corolla",123);
        Car car2 = new Car("Toyota","camry", 456);
        Car car3 = new Car("Hyundai","solaris", 789);

        carRepository.add(car1);
        carRepository.add(car2);
        carRepository.add(car3);

        CarRepository repoSorted = new CarRepository();

        repoSorted.add(car1);
        repoSorted.add(car2);
        repoSorted.add(car3);

        carRepository.sortById();

        Assert.assertArrayEquals("Error sort by id!",carRepository.getRepository(),repoSorted.getRepository());

    }

    @Test
    public void sortByBrand() throws Exception {

        CarRepository carRepository  = new CarRepository();

        Car car1 = new Car("Toyota","corolla",123);
        Car car2 = new Car("Toyota","camry", 456);
        Car car3 = new Car("Hyundai","solaris", 789);

        carRepository.add(car1);
        carRepository.add(car2);
        carRepository.add(car3);

        CarRepository repoSorted = new CarRepository();

        repoSorted.add(car3);
        repoSorted.add(car2);
        repoSorted.add(car1);

        carRepository.sortByBrand();

        Assert.assertArrayEquals("Error sort by age!",carRepository.getRepository(),repoSorted.getRepository());

    }

    @Test
    public void searchById() throws Exception{

        CarRepository carRepository  = new CarRepository();

        Car car1 = new Car("Toyota","corolla",123);
        Car car2 = new Car("Toyota","camry", 456);
        Car car3 = new Car("Hyundai","solaris", 789);

        carRepository.add(car1);
        carRepository.add(car2);
        carRepository.add(car3);

        carRepository.searchById(1);

        Assert.assertEquals("Error search by id",carRepository.getRepository()[0].toString(),"ID: 1" + "\nBrand: Toyota" + "\nModel: corolla" + "\nSerial number: 123");

    }


}
