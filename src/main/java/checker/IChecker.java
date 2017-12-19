package checker;

public interface IChecker<T> {
    boolean check(Object o, T t);
}
