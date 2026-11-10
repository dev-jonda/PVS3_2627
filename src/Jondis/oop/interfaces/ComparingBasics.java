package jondis.oop.interfaces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

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
//        Comparator<Item> BY_PRICE = new Comparator<Item>() {
//            @Override
//            public int compare(Item o1, Item o2) {
//                return 0;
//            }
//        };
        System.out.println("---");
        items.sort(Item.BY_PRICE);
        printList(items);
        System.out.println("--- .reversed ---");
        items.sort(Item.BY_PRICE.reversed()); // .reversed -> řazení naopak
        printList(items);
    }
}

class Item implements Comparable<Item> {
    String name;
    int quantity;
    double price;

    public static final Comparator<Item> BY_PRICE = new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            return Double.compare(o1.price, o2.price);
        }
    };

    public static final Comparator<Item> BY_QTY = new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            return Double.compare(o1.quantity, o2.quantity);
        }
    };

    public static final Comparator<Item> BY_TOTAL_VALUE = new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            return 0;
        }
    };

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

    // Porovnání podle jména abecedně
    @Override
    public int compareTo(Item o) {
        return this.name.toLowerCase().compareTo(o.name.toLowerCase()); // .toLowerCase -> porovnáná nejdříve malá písmena a pak velká podle ASCI table
    }
}