package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
import java.util.Collections;

public class BubbleSort<E extends Comparable<E>> {
    private ArrayList<E> arr;
    private int size;

    BubbleSort(ArrayList<E> arr) {

        this.arr = arr;
        this.size = arr.size();

    }

    public void sort() {

        int counter = 0; boolean sorted = false;
        while (!sorted){
            sorted = true; counter++;
            for (int j = 0; j < size - counter; j++) {
                if (arr.get(j).compareTo(arr.get(j+1)) > 0) {
                    Collections.swap(arr, j, j+1);
                    sorted = false;
                }
            }
        }

    }

    public void print() {

        for (int i = 0; i < size; i++) {
            System.out.print(arr.get(i).toString() + " ");
        }
        System.out.println();

    }


}
