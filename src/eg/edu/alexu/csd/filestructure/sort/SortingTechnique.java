package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
import java.util.Collections;

public class SortingTechnique<T extends Comparable<T>> implements ISort<T> {
    @Override
    public IHeap<T> heapSort(ArrayList<T> unordered) {
        if (unordered == null || unordered.size() == 0) return new MaxHeap<>(1);
        IHeap<T> heap = new MaxHeap<>();
        return null;
    }

    @Override
    public void sortSlow(ArrayList<T> unordered) {
        if (unordered == null || unordered.size() == 0) return;
        BubbleSort<T> bubbleSort = new BubbleSort<>(unordered);
        bubbleSort.sort();
    }

    @Override
    public void sortFast(ArrayList<T> unordered) {
        if (unordered == null || unordered.size() == 0) return;
        QuickSort<T> quickSort = new QuickSort<>(unordered);
        quickSort.sort();
        // quick sort
    }
}
