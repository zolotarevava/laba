package collections;

import checker.IChecker;
import entity.Person;

public abstract class AbstractRepository<T extends  Comparable<T>> implements IRepository<T> {

    private T[] repository;
    private int capacity;


    @Override
    public int getCapacity() {

        return this.capacity;
    }

    @Override
    public T[] getRepository() {

        return this.repository;
    }

    public void setCapacity(int capacity) {

        this.capacity = capacity;
    }

    public void setRepository(T[] repository) {

        this.repository = repository;
    }

    @Override
    public void add(T t) {
        if(capacity ==0)
        {
            this.repository = new [1];
            this.repository[0]=t;
            this.capacity++;
        }
        else
        {   T[] temp = new T[this.capacity+1];
            System.arraycopy(this.repository,0,temp,0,this.capacity);
            temp[this.capacity]=t;
            this.repository = temp;
            this.capacity++;

        }
    }

    @Override
    public void remove(int i) {
        T [] temp = new T[this.capacity -1];
        System.arraycopy(this.repository,0,temp,0, i);
        System.arraycopy(this.repository,i+1,temp,i,this.capacity -i-1);
        this.repository = temp;
        this.capacity--;
    }

    public IRepository<T> search(T t, IRepository<T> repository, IChecker<T> checker) {

        IRepository<T> result  = new PersonRepository();
        for (int i = 0; i < repository.getRepository().length; i++) {
            if(checker.check(t, (Person) repository.getRepository()[i])){
                result.add((Person) repository.getRepository()[i]);
            }
        }
        return result;
    }
}
