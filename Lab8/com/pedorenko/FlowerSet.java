package com.pedorenko;

import com.pedorenko.flowers.Flower;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by andrew on 15.05.17.
 */
public class FlowerSet implements Set<Flower>, Serializable {
    private Flower[] elements = new Flower[15];
    private int size = 0;

    public FlowerSet() {}

    public FlowerSet(Flower fl) {
        add(fl);
    }

    public FlowerSet(Collection<? extends Flower> c) {
        addAll(c);
    }

    /*enlarge if elements[] overloaded*/
    private void enlarge() {
        Flower temp[] = elements;
        elements = new Flower[(int) (elements.length * 1.3)];

        for(int i = 0; i < temp.length; ++i){
            elements[i] = temp[i];
        }
    }

    /*sorts flowers by freshness*/
    public void sort(){
        for (int i = 0; i < size - 1; ++i) {
            for (int j = i + 1; j < size; ++j) {
                if (elements[i].getFreshness() > elements[j].getFreshness()){
                    Flower flower = elements[i];
                    elements[i] = elements[j];
                    elements[j] = flower;
                }
            }
        }
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
        for (int i = 0; i < size; ++i) {
            if (elements[i].equals(o)) return true;
        }
        return false;
    }

    @Override
    public Iterator<Flower> iterator() {
        return new FlowerIterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[]{elements};
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Flower flower) {
        if(elements.length > size){
            if (!contains(flower)) {
                elements[size] = flower;
                ++size;
                return true;
            }
            return false;
        }
        else{
            enlarge();
            if (!contains(flower)) {
                elements[size] = flower;
                ++size;
                return true;
            }
            return false;
        }
    }

    @Override
    public boolean remove(Object o) {
        int removeID = -1;
        for (int i = 0; i < size; ++i) {
            if (elements[i].equals(0)) {
                removeID = i;
                break;
            }
        }
        if (removeID != -1) {
            for (int i = removeID; i < size - 1; ++i) {
                elements[i] = elements[i - 1];
            }
            size--;
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object elem : c){
            if (!contains(elem)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Flower> c) {
        for (Flower elem : c) {
            add(elem);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        for (int i = 0; i < size; ++i) {
            if (!c.contains(elements[i])) {
                remove(elements[i]);
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object elem : c){
            remove(elem);
        }
        return true;
    }

    @Override
    public void clear() {
        size = 0;
        elements = new Flower[15];
    }

    private class FlowerIterator implements Iterator<Flower> {
        private int i = 0;
        @Override
        public boolean hasNext() {
            return i < size;
        }

        @Override
        public Flower next() {
            return elements[i++];
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; ++i) {
            sb.append(elements[i].toString());
            sb.append('\n');
        }
        return sb.toString();
    }
}
