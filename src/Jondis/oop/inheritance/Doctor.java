package jondis.oop.inheritance;

public class Doctor {
    final static int BASE_SALARY = 50000; // konstanta
    String name;
    int salary;

    Doctor(String name, int salary) {
        this.name = name;
        salary = BASE_SALARY;
    }

    void diagnose(){
        System.out.println("Zjišťuji co s vámi je...");
        salary += 10000;
    }
}
