package collections;

import checker.IChecker;

public interface IRepository<T extends Comparable<T>> {
    T [] getRepository();
    int getCapacity();
    void add(T t);
    void remove(int i);
    IRepository<T> search(T t, IRepository<T> repository, IChecker<T> checker);
}
