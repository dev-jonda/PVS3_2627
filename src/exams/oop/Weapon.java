package exams.oop;

public class Weapon {
    protected String name;
    protected int damage;
    protected double xp;

    protected static final double XP_PER_ATTACK = 10;

    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
        this.xp = 0;
    }

    public void attack() {
        System.out.println(name + " deals " + damage + " damage.");
        xp += XP_PER_ATTACK;
        System.out.println("Gained " + XP_PER_ATTACK + " XPs");
    }

    public int getDamage() {
        return damage;
    }

    public double getXp() {
        return xp;
    }
}