package jondis.oop.interfaces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ComparingBasics {
    static void printList(ArrayList<Item> items){
        for (Item i : items) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("potato", 100, 0.33));
        items.add(new Item("White Monster Ultra", 1_000_000, 1.65));
        items.add(new Item("Mango Monster", 500_000, 1.65));
        items.add(new Item("Beef steak", 100_000, 11.5));
        items.add(new Item("onion", 200_000, 0.5));

        // System.out.println(items);

        Collections.shuffle(items);
        printList(items);

        // serad, podle (defaultniho) prirozeneho razeni
        System.out.println("---");
        Collections.sort(items);
        printList(items);

        // anonymni vnitrni trida

        // ...
    }
}

class Item implements Comparable<Item> {
    String name;
    int quantity;
    double price;

    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ", " + quantity + ", " + price +"$"+"; ";
    }

    // quantity
//    @Override
//    public int compareTo(Item o) {
//        return this.quantity - o.quantity;
//    }

    // price
//    @Override
//    public int compareTo(Item o) {
//        // return (int) (this.price - o.price);
//        return Double.compare(this.price, o.price);
//    }

    // name

    @Override
    public int compareTo(Item o) {
        return this.name.compareTo(o.name);
    }
}