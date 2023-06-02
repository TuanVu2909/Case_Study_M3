package service;

public interface Service<E> {
    E create();
    E update();
    E delete();
    void displayALL();
}
