package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class MaxHeap<T extends Comparable<T>> implements IHeap<T> {
    INode[] elements = null;
    int MAX = 1000005;
    int heapSize = 0;

    public INode get(int index) {
        if (index > heapSize) return null;
        return elements[index];
    }

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
    private void buildMaxHeap(){
        for(int i = heapSize/2 ; i >= 1 ; i--) {
            heapify(elements[i]);
        }
    }

    @Override
    public void build(Collection<T> unordered) {
        heapSize = unordered.size() ;
        int index = 1;
        for (Iterator<T> iterator = unordered.iterator(); iterator.hasNext(); ) {
            elements[index] = new Node(this, index, iterator.next());
            index++;
        }
        buildMaxHeap() ;
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
        for(int i = 1 ; i< heapSize ; i++ ) {
            System.out.println(elements[i].toString()) ;
        }
    }


//    public static void main(String[] args) {
//        MaxHeap<Integer> heaph5a = new MaxHeap<>() ;
//        ArrayList<Integer> sample = new ArrayList<>(Arrays.asList(1,2,3,4,5,4,4,5,5,2,4,5,1,2,5,4,7,8,9)) ;
//        heaph5a.build(sample) ;
//       heaph5a.print();
//    }

}
