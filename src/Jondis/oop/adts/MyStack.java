package jondis.oop.adts;

public interface MyStack {
    void push(String item);
    // TODO: Chtělo by nějak mít možnost vracet různe datové typy
    String pop();
    String peek();
    boolean isEmpty();
}
