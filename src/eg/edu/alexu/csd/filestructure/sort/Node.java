package eg.edu.alexu.csd.filestructure.sort;

public class Node<E extends Comparable<E>> implements INode<E> {
    private MaxHeap<E> heap;
    private E val = null;
    private int index;

    public Node(MaxHeap<E> maxHeap, int index , E val ) {
        heap = maxHeap;
        this.index = index;
        this.val = val ;
    }

    @Override
    public INode<E> getLeftChild() {
        return heap.get(2 * index);
    }

    @Override
    public INode<E> getRightChild() {
        return heap.get(2 * index + 1);
    }

    @Override
    public INode<E> getParent() {
        return heap.get(index / 2);
    }

    @Override
    public E getValue() {
        return val;
    }

    @Override
    public void setValue(E value) {
        this.val = value;
    }

    @Override
    public String toString() {
        return this.val.toString() ;
    }
}
