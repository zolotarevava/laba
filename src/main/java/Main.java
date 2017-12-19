import collections.CarRepository;
import collections.PersonRepository;
import comparator.PersonAgeComparator;
import entity.Car;
import entity.Person;

import org.joda.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sort.BubbleSort;

public class Main {

    private static final Logger log = LogManager.getLogger(Main.class.getName());

    public static void main( String[] args){

        PersonRepository personRepository = new PersonRepository();

        Person p1 = new Person("Petrov", new LocalDate(1990, 06,5));
        Person p2 = new Person("Ivanov", new LocalDate(1995,10,16));
        Person p3 = new Person("Sidorov", new LocalDate(1997,12,10));

        personRepository.add(p1);
        personRepository.add(p2);
        personRepository.add(p3);

        personRepository.sortBySurname();

        personRepository.searchById(1).getRepository();

        /*for (Object p: personRepository.getRepository()) {
            log.info(p.toString());
        }*/

        CarRepository carRepository = new CarRepository();

        Car c1 = new Car("Toyota","corolla",123);
        Car c2 = new Car("Toyota","camry", 456);
        Car c3 = new Car("Hyundai","solaris", 789);

        carRepository.add(c1);
        carRepository.add(c2);
        carRepository.add(c3);

        carRepository.sortById();

        for (Object c: carRepository.getRepository()) {
           log.info(c.toString());
        }

    }
}
