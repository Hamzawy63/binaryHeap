package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class MaxHeap<T extends Comparable<T>> implements IHeap<T> {
    INode[] elements ;
    int MAX = (int)2e7 ;
    int heapSize = 0;

    public INode get(int index) {
        if (index > heapSize) return null;
        return elements[index];
    }

    MaxHeap() {
        elements = new INode[MAX];
    }

    MaxHeap(int max) {
        elements = new INode[max];
    }

    @Override
    public INode<T> getRoot() {
        if (empty()) return null;
        return elements[1];
    }

    @Override
    public int size() {
        return heapSize;
    }

    @Override
    public void heapify(INode<T> node) {
        if(node == null ) return;
        INode<T> largest = node;
        INode<T> left = node.getLeftChild();
        INode<T> right = node.getRightChild();
        if (left != null && left.getValue().compareTo(largest.getValue()) > 0) {
            largest = left;
        }
        if (right != null && right.getValue().compareTo(largest.getValue()) > 0) {
            largest = right;
        }
        if (largest != node) {
            T temp = node.getValue();
            node.setValue(largest.getValue());
            largest.setValue(temp);
            heapify(largest);
        }
    }

    @Override
    public T extract() {
        if(heapSize == 0 ) return  null ;
        INode<T> root = getRoot();
        INode<T> last = lastElement();
        T value = last.getValue();


        /*Swap the value of the root with the last element in the heap*/
        T temp = getRoot().getValue();
        root.setValue(last.getValue());
        last.setValue(temp);

        /*Remove the last element from the heap */
        elements[heapSize] = null;
        heapSize--;
        heapify(getRoot());

        return value;
    }

    @Override
    public void insert(T element) {
        if(element == null ) return;
        heapSize++;
        elements[heapSize] = new Node(this, heapSize, element);

        INode<T> parent = elements[heapSize].getParent();
        INode<T> cur = elements[heapSize];
        while (parent != null && cur.getValue().compareTo(parent.getValue()) > 0) {
            swap(parent, cur);
            INode<T> temp = parent;
            parent = parent.getParent();
            cur = temp;
        }


    }

    private void buildMaxHeap() {
        for (int i = heapSize / 2; i >= 1; i--) {
            heapify(elements[i]);
        }
    }

    @Override
    public void build(Collection<T> unordered) {
        if(unordered == null || unordered.size() == 0 ) return;
        heapSize = unordered.size();
        int index = 1;
        for (Iterator<T> iterator = unordered.iterator(); iterator.hasNext(); ) {
            elements[index] = new Node(this, index, iterator.next());
            index++;
        }
        buildMaxHeap();
    }

    /*Helping methods */

    private INode<T> lastElement() {
        if (empty())
            return null;
        return elements[heapSize];
    }

    private boolean empty() {
        return heapSize == 0;
    }

    private void print() {
        for (int i = 1; i <= heapSize; i++) {
            System.out.print(elements[i].toString() + " ");
        }
        System.out.println();
    }

    private void swap(INode<T> first, INode<T> second) {
        T tempValue = first.getValue();
        first.setValue(second.getValue());
        second.setValue(tempValue);
    }

    //========================================================================================
    public static void main(String[] args) {
        MaxHeap<Integer> heaph5a = new MaxHeap<>(100);
        ArrayList<Integer> sample = new ArrayList<>(Arrays.asList(1, 2, 3, 4,5,6,7,8,9));
        heaph5a.build(sample);
        INode<Integer> root = heaph5a.getRoot();
        while(root != null ) {
            System.out.print(root.getValue() + " ");
        }
        System.out.println();
        heaph5a.print();

    }


}
