package br.com.cwi.crescer.complex;
import java.util.List;

public interface ILinkedList<T> {

    public void addFirst(T value);

    public List<T> list();

    public void addLast(T value);

    public void removeFirst();

    public void addMiddle(int index, T value);

    public void remove(int index);
}
