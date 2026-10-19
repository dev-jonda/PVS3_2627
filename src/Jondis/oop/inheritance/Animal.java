package jondis.oop.inheritance;

import fileworks.DataImport;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    protected String name;
    private double energy;

    public Animal(String name, double energy) {
        this.name = name;
        this.energy = energy;
    }

    public void eat() {
        energy += Math.exp(-energy);
    }

    public void makeNoise() {
        System.out.println("Make some noise");
    }
}

class Dog extends Animal {
    public String breed;

    public Dog(String name, double energy) {
        super(name, energy);
    }

    public Dog(String name, double energy, String breed) {
        super(name, energy);
        this.breed = breed;
    }

    @Override
    public void makeNoise() {
        System.out.println("Haf");
    }
}

class Cat extends Animal {
    public Cat(String name, double energy) {
        super(name, energy);
    }

    @Override
    public void makeNoise() {
        System.out.println("Moew");
    }

}

class Pig extends Animal {
    int mudLevel;

    public Pig(String name, double energy) {
        super(name, energy);
    }

    public Pig(String name, double energy, int mudLevel) {
        super(name, energy);
        this.mudLevel = mudLevel;
    }

    void playInMud() {
        mudLevel += 10;
        mudLevel = Math.min(mudLevel, 100);
    }

    @Override
    public void makeNoise() {
        System.out.println("Chro chro chro :)");
    }
}

class Main {
    public static void main(String[] args) {
        DataImport di = new DataImport("data/animals.txt");

        di.readLine(); // přeskočení hlavičky

        List<Animal> animals = new ArrayList<>();
        while (di.hasNext()) {
            String line = di.readLine();
            String[] parts = line.trim().split(";");

            // Přidat do listu animals zvíře
            switch (parts[0]){
                case "Dog": {
                    animals.add(new Animal(parts[1], Double.parseDouble(parts[2]), parts[3]));
                    break;
                }
            }
        }


        di.finishImport();
    }
}