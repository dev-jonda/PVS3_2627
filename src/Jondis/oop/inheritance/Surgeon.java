package jondis.oop.inheritance;

public class Surgeon extends Doctor {
    final static int SURGEON_BONUS = 25000;

    Surgeon(String name) {
        super(name);
        salary += SURGEON_BONUS;
    }

    void surgery(){
        System.out.println("5e6ba");
        salary += 25000;
    }
}
