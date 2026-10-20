package jondis.oop.inheritance;

import java.util.ArrayList;

public class CardiacSurgeon extends Surgeon{

    final static int CS_BONUS = 30000;
    CardiacSurgeon(String name) {
        super(name);
        salary += CS_BONUS;
    }

    void cardiacSurgery(){
        System.out.println("Bod8m srdce");
        salary += 30000;
    }
}
