package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
import java.util.Collections;

public class QuickSort<E extends Comparable<E>>{
    /**
     * Implementation of quick sort using the middle  element as the pivot
     */
    private ArrayList<E> arr ;
    private int size;

    QuickSort(ArrayList<E> arr) {

        this.arr = arr;
        this.size = arr.size();

    }

    public void sort() {
        quickSort(0, size - 1);
    }

    private void quickSort(int l, int r) {
        if (l < r) {
            int pivotIndex = partition(l, r);
            quickSort(l, pivotIndex - 1);
            quickSort(pivotIndex + 1, r);
        }
    }
    private int partition(int l, int r) {
        /*
         Swapping the middle element with the last element guarantee better performence when taking the last element as a pivot
         NOTE : you can remove the following swap in line '27' and you will get a stack overflow if the array is sorted and its size is 100000
         */
//        int mid = l + (r - l ) /2;
//
//        if (arr.get(l).compareTo(arr.get(r)) > 0)
//            swap(l,r);
//        if (arr.get(r).compareTo(arr.get(mid)) > 0)
//            swap(r,mid);
//        if (arr.get(l).compareTo(arr.get(r)) > 0)
//            swap(l,r);
        swap(l + (r - l ) /2 , r);
        E pivot = arr.get(r);

//        E pivot = arr.get(r);
        int i = l - 1, j = r - 1;
        while (j != i){
            if (arr.get(j).compareTo(pivot) < 0 ) {
                i ++;
                swap(i , j );
            } else j--;
        }
        swap(i+1 , r);
        return i+1 ;
    }
    private void swap(int i, int j) {
        Collections.swap(arr , i , j);
    }

    public void print(){
        for(int i = 0 ; i < size ; i++) {
            System.out.print(arr.get(i).toString()+ " ");
        }
        System.out.println();
    }
}
