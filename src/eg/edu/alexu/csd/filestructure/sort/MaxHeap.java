package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
import java.util.Collection;

public class MaxHeap<T extends Comparable<T>> implements IHeap<T> {
    INode[] elements = null;
    int MAX = 1000000;
    int heapSize = 0;

    MaxHeap() {
        elements = new INode[MAX];
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
        INode<T> root = getRoot();
        INode<T> last = lastElement();
        T value = last.getValue();


        /*Swap the value of the root with the last element in the heap*/
        T temp = getRoot().getValue();
        root.setValue(last.getValue());
        last.setValue(temp);

        /*Remove the last element from the heap */
        heapify(getRoot());

        return value;
    }

    @Override
    public void insert(T element) {
        heapSize++;

    }

    @Override
    public void build(Collection<T> unordered) {

    }

    /*Helping methods */

    private INode<T> lastElement() {

        if (empty())
            return null;
        return elements[heapSize + 1];
    }

    private boolean empty() {
        return heapSize == 0;
    }

}
