package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;

public class SortingTechnique<T extends Comparable<T>> implements ISort<T> {
    @Override
    public IHeap<T> heapSort(ArrayList<T> unordered) {
        return null;
    }

    @Override
    public void sortSlow(ArrayList<T> unordered) {
        // bubble sort
    }

    @Override
    public void sortFast(ArrayList<T> unordered) {
            // quick sort
    }
}
