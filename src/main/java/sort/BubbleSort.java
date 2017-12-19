package sort;

import java.util.Comparator;

public class BubbleSort implements IMySort {

    public Object[] sort(Object[] objects, Comparator comparator) {
        Object tmp;
        for (int i = 0; i < objects.length - 1; i++) {
            for (int j = i + 1; j < objects.length; j++) {
                if (comparator.compare(objects[i], objects[j]) > 0) {
                    tmp = objects[i];
                    objects[i] = objects[j];
                    objects[j] = tmp;
                }
            }
        }
        return objects;
    }
}
