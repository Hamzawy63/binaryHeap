package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort<E extends Comparable<E>> {
    private ArrayList<E> arr;
    private int n;

    BubbleSort(ArrayList<E> arr) {
        this.arr = arr;
        this.n = arr.size();
    }

    public void sort() {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr.get(i).compareTo(arr.get(j)) > 1) {
                    Collections.swap(arr, i, j);
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i).toString() + " ");
        }
        System.out.println();
    }


}
