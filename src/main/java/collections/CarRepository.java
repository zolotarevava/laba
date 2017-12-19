package collections;

import checker.*;
import comparator.CarBrandComparator;
import comparator.CarIdComparator;
import comparator.CarModelComparator;
import entity.Car;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sort.IMySort;
import sort.SortConfigurator;

import java.io.IOException;

public class CarRepository extends AbstractRepository<Car> {

    private static Logger log = LogManager.getLogger();

    /**
     * Сортировка по бренду
     */
    public void sortByBrand(){
        try {
            log.info("sort by brand");
            IMySort sorter =  SortConfigurator.getInstance().getSorter();
            sorter.sort(super.getRepository(),new CarBrandComparator());


        } catch (IOException e) {
            e.printStackTrace();
            log.catching(e);
        }
    }

    /**
     * Сортировка по фамилии
     */
    public void sortByModel(){
        try {
            log.info("sort by model");
            IMySort sorter =  SortConfigurator.getInstance().getSorter();
            sorter.sort(super.getRepository(),new CarModelComparator());

        } catch (IOException e) {
            e.printStackTrace();
            log.info(e);
        }

    }

    /**
     * Сортировка по ID
     */
    public void sortById(){
        try {
            log.info("sort by id");
            IMySort sorter =  SortConfigurator.getInstance().getSorter();
            sorter.sort(super.getRepository(),new CarIdComparator());

        } catch (IOException e) {
            e.printStackTrace();
            log.catching(e);
        }

    }


    public IRepository<Car> search(Object o, IRepository<Car> repository, IChecker<Car> checker) {
        IRepository<Car> result  = new CarRepository();
        for (int i = 0; i < repository.getRepository().length; i++) {
            if(checker.check(o, (Car) repository.getRepository()[i])){
                result.add((Car) repository.getRepository()[i]);
            }
        }
        return result;
    }



    /**
     * поиск по бренду
     * @param brand
     * @return
     */
    public IRepository<Car> searchByBrand(String brand){

        return  search(brand, this, new CarCheckByBrand());

    }

    /**
     * поиск по модели
     * @param model
     * @return
     */
    public IRepository<Car>  searchByModel(String model){

        return  search(model,this, new CarCheckByModel());
    }

    /**
     * поиск по id
     * @param id
     * @return
     */
    public IRepository<Car>  searchById(int id){
        return  search(id, this, new CarCheckById());
    }

    /**
     * поиск по серийному номеру
     * @param serialnumber
     * @return
     */
    public IRepository<Car> searchBySerialNumber(int serialnumber){
        return search(serialnumber, this, new CarCheckBySerialNumber());
    }


}