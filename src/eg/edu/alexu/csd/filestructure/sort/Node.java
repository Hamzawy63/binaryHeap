package eg.edu.alexu.csd.filestructure.sort;

public class Node<E extends Comparable<E>> implements INode<E> {
    @Override
    public INode<E> getLeftChild() {
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
        return null;
    }

    @Override
    public void setValue(E value) {

    }
}
