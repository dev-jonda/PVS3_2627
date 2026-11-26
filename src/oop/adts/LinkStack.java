package oop.adts;

public class LinkStack implements MyStack{
    MyLink data;

    @Override
    public void push(String item) {
        // 1. vzít MyLink
        MyLink curr = data; // celej retez dat

        // 2. zkontrolovat, jestli je v něm místo
        while(curr.getCurrent() != null){
            curr = curr.getNext();
        }

        // 3. Pokud je prázdný, přidáme hodnotu
        curr.setCurrent(item);

        // 4. Vytvořím prázdného souseda
        curr.setNext(new MyLink(null));
    }

    @Override
    public String pop() {
        return "";
    }

    @Override
    public String peek() {
        return "";
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}

class MyLink{
    private String current;
    private MyLink next;

    public MyLink(String current){
        this.current = current;
    }

    public MyLink getNext() {
        return next;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public void setNext(MyLink next){
        this.next = next;
    }
}