package service;

public interface Service<E> {
    void create(E e);
    void update(E e);
    void delete();
    void displayALL();
}
