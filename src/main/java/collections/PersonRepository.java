package collections;

import checker.IChecker;
import checker.PersonCheckByAge;
import checker.PersonCheckById;
import checker.PersonCheckBySurname;
import comparator.PersonAgeComparator;
import comparator.PersonIdComparator;
import comparator.PersonSurnameComparator;
import entity.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sort.IMySort;
import sort.SortConfigurator;

import java.io.IOException;

public class PersonRepository extends AbstractRepository<Person> {

    private static Logger log = LogManager.getLogger();

    /** Сортировка по фамилии
     *
     */
    public void sortBySurname(){
        try {
            log.info("sort by surname");
            IMySort sorter =  SortConfigurator.getInstance().getSorter();
            sorter.sort(super.getRepository(),new PersonSurnameComparator());

        } catch (IOException ex) {
            ex.printStackTrace();
            log.info(ex);
        }

    }

    /** Сортировка по ID
     *
     */
    public void sortById(){
        try {
            log.info("sort by id");
            IMySort sorter =  SortConfigurator.getInstance().getSorter();
            sorter.sort(super.getRepository(),new PersonIdComparator());

        } catch (IOException e) {
            e.printStackTrace();
            log.catching(e);
        }

    }

    /** Сортировка по возрасту
     *
     */
    public void sortByAge(){
        try {
            log.info("sort by Age");
            IMySort sorter =  SortConfigurator.getInstance().getSorter();
            sorter.sort(super.getRepository(),new PersonAgeComparator());

        } catch (IOException e) {
            e.printStackTrace();
            log.catching(e);
        }

    }

    public IRepository<Person> search(Object o, IRepository<Person> repository, IChecker<Person> checker) {

        IRepository<Person> result  = new PersonRepository();
        for (int i = 0; i < repository.getRepository().length; i++) {
            if(checker.check(o, (Person) repository.getRepository()[i])){
                result.add((Person) repository.getRepository()[i]);
            }
        }
        return result;
    }

    /**
     * поиск по фамилии
     * @param name
     * @return
     */
    public IRepository<Person> searchBySurname(String name){

        return  search(name, this, new PersonCheckBySurname());

    }

    /**
     * поиск по id
     * @param id
     * @return
     */
    public IRepository<Person> searchById(int id){

        return  search(id,this, new PersonCheckById());
    }

    /**
     * поиск по возрасту
     * @param age
     * @return
     */
    public IRepository<Person> searchByAge(int age){

        return search(age, this, new PersonCheckByAge());
    }

}
