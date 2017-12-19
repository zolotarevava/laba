package collections;

import org.junit.Assert;
import org.junit.Test;
import entity.Person;

import org.joda.time.LocalDate;

public class PersonRepositoryTest {

    @Test
    public void addPerson() throws Exception {

        PersonRepository personRepository = new PersonRepository();

        Person person = new Person("Sidorov", new LocalDate(1997,12,10));
        Person person1 = new Person("Popov", new LocalDate(1987,10,18));

        personRepository.add(person);
        personRepository.add(person1);

        Assert.assertEquals("ErrorTestAdd",personRepository.getRepository()[0],person);
    }

    @Test
    public void removePerson() throws Exception{

        PersonRepository personRepository = new PersonRepository();

        Person person = new Person("Sidorov", new LocalDate(1997,12,10));
        Person person1 = new Person("Petrov", new LocalDate(1995,11,8));

        personRepository.add(person);
        personRepository.add(person1);

        personRepository.remove(0);

        Assert.assertEquals("ErrorTestRemove",personRepository.getRepository()[0],person1);
    }

    @Test
    public void sortBySurname() throws Exception {

        PersonRepository personRepository = new PersonRepository();

        Person person = new Person("Sidorov", new LocalDate(1997,12,10));
        Person person1 = new Person("Petrov", new LocalDate(1995,11,8));

        personRepository.add(person);
        personRepository.add(person1);

        PersonRepository repoSorted = new PersonRepository();

        repoSorted.add(person1);
        repoSorted.add(person);

        personRepository.sortBySurname();

        Assert.assertArrayEquals("Error sort by surname!", personRepository.getRepository(),repoSorted.getRepository());

    }

    @Test
    public void sortById() throws Exception {

        PersonRepository personRepository  = new PersonRepository();

        Person person = new Person("Sidorov", new LocalDate(1997,12,10));
        Person person1 = new Person("Petrov", new LocalDate(1995,11,8));

        personRepository.add(person);
        personRepository.add(person1);

        PersonRepository repoSorted = new PersonRepository();

        repoSorted.add(person);
        repoSorted.add(person1);

        personRepository.sortById();

        Assert.assertArrayEquals("Error sort by id!",personRepository.getRepository(),repoSorted.getRepository());

    }

    @Test
    public void sortByAge() throws Exception {

        PersonRepository personRepository  = new PersonRepository();

        Person person = new Person("Sidorov", new LocalDate(1997,12,10));
        Person person1 = new Person("Petrov", new LocalDate(1995,11,8));

        personRepository.add(person);
        personRepository.add(person1);

        PersonRepository repoSorted = new PersonRepository();

        repoSorted.add(person1);
        repoSorted.add(person);

        personRepository.sortByAge();

        Assert.assertArrayEquals("Error sort by age!",personRepository.getRepository(),repoSorted.getRepository());

    }

    @Test
    public void searchById() throws Exception{
        PersonRepository personRepository = new PersonRepository();

        Person person = new Person("Sidorov", new LocalDate(1997,12,10));
        Person person1 = new Person("Petrov", new LocalDate(1995,11,8));

        personRepository.add(person);
        personRepository.add(person1);

        personRepository.searchById(1);

        Assert.assertEquals("Error search by id",personRepository.getRepository()[0].toString(),"ID: 1" + "\nSurname: Sidorov"+"\nDate of birthday: 1997-12-10");

    }

}