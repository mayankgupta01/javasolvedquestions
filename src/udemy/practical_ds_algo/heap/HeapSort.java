package udemy.practical_ds_algo.heap;

/**
 * Created by mayank.gupta on 20/03/17.
 *
 * http://codereview.stackexchange.com/questions/111529/min-heap-sort-using-generics
 */
import java.util.ArrayList;

final class Heap<T extends Comparable<T>> {
    private final ArrayList<T> heapArray = new ArrayList<>();

    public Heap() {

    }

    public Heap(T[] objects) {
        for (T object : objects) {
            add(object);
        }
    }


    public void add(T newObject) {
        heapArray.add(newObject);
        int currentIndex = heapArray.size() - 1;

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;

            if (heapArray.get(currentIndex).compareTo(heapArray.get(parentIndex)) > 0) {
                T temp = heapArray.get(currentIndex);
                heapArray.set(currentIndex, heapArray.get(parentIndex));
                heapArray.set(parentIndex, temp);
            } else {
                break;
            }

            currentIndex = parentIndex;
        }
    }

    public T remove() {
        if (heapArray.isEmpty()) {
            return null;
        }

        T removedObject = heapArray.get(0);
        heapArray.set(0, heapArray.get(heapArray.size() - 1));
        heapArray.remove(heapArray.size() - 1);

        int currentIndex = 0;
        while (currentIndex < heapArray.size()) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            if (leftChildIndex >= heapArray.size()) {
                break;
            }

            int maxIndex = leftChildIndex;

            if (rightChildIndex < heapArray.size()) {
                if (heapArray.get(maxIndex).compareTo(heapArray.get(rightChildIndex)) < 0) {
                    maxIndex = rightChildIndex;
                }
            }

            if (heapArray.get(currentIndex).compareTo(heapArray.get(maxIndex)) < 0) {
                T temp = heapArray.get(maxIndex);
                heapArray.set(maxIndex, heapArray.get(currentIndex));
                heapArray.set(currentIndex, temp);
                currentIndex = maxIndex;
            } else {
                break;
            }
        }

        return removedObject;

    }

    public int getSize() {
        return heapArray.size();
    }
}

public class HeapSort {

    public static <T extends Comparable<T>> void heapSort(T[] list) {

        Heap<T> heap = new Heap<>();

        for (T list1 : list) {
            heap.add(list1);
        }

        for (int i = list.length - 1; i >= 0; i--) {
            list[i] = heap.remove();
        }

    }

    public static void main(String[] args) {

        Integer[] Test1 = {9, 7, 6, 3, 4, 6, 5, 1, 2, 3};
        heapSort(Test1);

        for (Integer Test11 : Test1) {
            System.out.print(Test11 + " ");
        }

        System.out.println();

        Character[] Test2 = {'L', 'F', 'G', 'S', 'V', 'B', 'S', 'M', 'H', 'T'};
        heapSort(Test2);

        for (Character Test21 : Test2) {
            System.out.print(Test21 + " ");
        }

    }
}
