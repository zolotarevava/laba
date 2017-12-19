package sort;

import java.util.Comparator;

public class InsertSort implements IMySort {

    public  Object[] sort(Object[] objects, Comparator comp) {
        int i, j;
        Object tmp;
        for (i = 1; i < objects.length; i++) {
            j = i;
            while (j > 0 && comp.compare(objects[j - 1], objects[j]) > 0) {
                tmp = objects[j];
                objects[j] = objects[j - 1];
                objects[j - 1] = tmp;
                j--;
            }
        }
        return objects;

    }

}
