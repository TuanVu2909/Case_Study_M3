package service;

import java.util.List;

public interface Service<E> {
    List<E> getList();
    void create(E e);
    void update(E e);
    void delete();
    void displayALL();
}
