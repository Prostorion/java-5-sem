package lab.O7seventh;

import lab.O6sixth.trains.Train;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TrainList implements List<Train> {

    private static class Node {
        private Node next;
        private Node prev;

        private Train value;

        public Node(Node prev, Train value) {
            this.prev = prev;
            this.value = value;
        }

        public Train getValue() {
            return value;
        }

        public void setValue(Train value) {
            this.value = value;
        }


        public Node(Train value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }

    private Node root;
    private int size;

    public TrainList() {
        size = 0;
    }

    public TrainList(Train train) {
        root = new Node(root, train);
        root.setNext(root);
        size = 1;
    }

    public TrainList(Train[] trains) {
        size = trains.length;
        root = new Node(trains[0]);
        Node currentNode = root;
        for (int i = 1; i < trains.length; i++) {
            currentNode.setNext(new Node(currentNode, trains[i]));
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(root);
        root.setPrev(currentNode);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        Node currentNode = root;
        if (currentNode.getValue().equals(o)) {
            return true;
        }
        currentNode = currentNode.getNext();
        while (currentNode != null && currentNode != root) {
            if (currentNode.getValue().equals(o)) {
                return true;
            }
            currentNode = currentNode.getNext();
        }
        return false;
    }

    @Override
    public Iterator<Train> iterator() {
        return new Iterator<>() {
            Node currentNode = root;

            @Override
            public boolean hasNext() {
                return currentNode.getNext() != root;
            }

            @Override
            public Train next() {
                Node prev = currentNode;
                currentNode = currentNode.getNext();
                return prev.getValue();
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] trains = new Object[size];
        Node currentNode = root;
        for (int i = 0; i < size; i++) {
            trains[i] = currentNode.getValue();
            currentNode = currentNode.getNext();
        }
        return trains;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length > size) {
            Node currentNode = root;
            for (int i = 0; i < size; i++) {
                a[i] = (T) currentNode.getValue();
                currentNode = currentNode.getNext();
            }
        }
        return (T[]) this.toArray();
    }

    @Override
    public boolean add(Train train) {
        size++;
        Node lastNode = root.getPrev();
        Node newNode = new Node(lastNode, train);
        lastNode.setNext(newNode);
        newNode.setNext(root);
        root.setPrev(newNode);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (size > 1) {
            Node currentNode = root;
            while (currentNode != null && currentNode.getNext() != root) {
                if (currentNode.getValue().equals(o)) {
                    if (currentNode.equals(root)) root = currentNode.getNext();
                    Node prev = currentNode.getPrev();
                    Node next = currentNode.getNext();
                    prev.setNext(next);
                    next.setPrev(prev);
                    size--;
                    return true;
                }
                currentNode = currentNode.getNext();
            }
        } else if (size == 1) {
            root = null;
            size--;
            return true;
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (var obj : c) {
            if (!this.contains(obj)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Train> c) {
        return addAll(size, c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends Train> c) {
        if (index < 0) return false;
        TrainList trains = new TrainList(c.toArray(new Train[0]));
        Node chain = trains.root;
        Node currentNode = root;
        if (index > 0) {
            currentNode = currentNode.getNext();
            for (int i = 0; i < index - 1; i++) {
                if (currentNode.equals(root)) {
                    return false;
                }
                currentNode = currentNode.getNext();
            }
        }

        Node next = currentNode;
        Node prev = currentNode.getPrev();
        next.setPrev(chain.getPrev());
        chain.getPrev().setNext(next);
        prev.setNext(chain);
        chain.setPrev(prev);

        size += trains.size();
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public Train get(int index) {
        if (index == 0) return root.getValue();
        Node currentNode = root.getNext();
        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.getNext();
            if (currentNode == root) throw new IndexOutOfBoundsException();
        }
        return currentNode.getValue();
    }

    @Override
    public Train set(int index, Train element) {
        if (index == 0) {
            Train prevTrain = root.getValue();
            root.setValue(element);
            return prevTrain;
        }
        Node currentNode = root.getNext();
        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.getNext();
            if (currentNode == root) throw new IndexOutOfBoundsException();
        }
        Train prevTrain = currentNode.getValue();
        currentNode.setValue(element);
        return prevTrain;
    }

    @Override
    public void add(int index, Train element) {


    }

    @Override
    public Train remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Train> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Train> listIterator(int index) {
        return null;
    }

    @Override
    public List<Train> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Train list{\n");
        Node currentNode = root;
        while (currentNode != null && currentNode.getNext() != root) {
            str.append(currentNode.getValue()).append("\n");
            currentNode = currentNode.getNext();
        }
        if (size != 0) {
            str.append(currentNode.getValue()).append("\n");
        }
        str.append("}");
        return str.toString();
    }
}
