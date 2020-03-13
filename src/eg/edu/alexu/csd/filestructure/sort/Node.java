package eg.edu.alexu.csd.filestructure.sort;

public class Node<E extends Comparable<E>> implements INode<E> {
    private MaxHeap<E> heap ;
    private E val = null ;
    private int index  ;
    @Override
    public INode<E> getLeftChild()
    {
        return null;
    }

    @Override
    public INode<E> getRightChild() {
        return null;
    }

    @Override
    public INode<E> getParent() {
        return null;
    }

    @Override
    public E getValue() {
        return val;
    }

    @Override
    public void setValue(E value) {
        val = value ;
    }
}
