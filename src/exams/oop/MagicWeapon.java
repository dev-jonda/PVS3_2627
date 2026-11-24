package exams.oop;

public class MagicWeapon extends Weapon {
    private int manaCost;
    private int castCount;

    private static final double XP_SCALING = 1.2;
    private static final int MANA_BASE = 100;

    public MagicWeapon(String name, int damage) {
        super(name, damage);

        this.manaCost = MANA_BASE;
        this.xp = 100;
        this.castCount = 0;
    }

    public void cast() {
        castCount++;
        double xpGained = XP_PER_ATTACK * XP_SCALING;
        this.xp += xpGained;

        System.out.println("Gained " + xpGained + " XPs");
        System.out.println("Casting fireball!, consumed " + manaCost + " MP");
    }

    public int getManaCost() {
        return manaCost;
    }

    public int getManaSpent(){
        // TODO: vrátit celkovou spotřebovanou manu
        //       mana se spotřebuje vždy jen při volání metody cast()
        return 0;
    }
}
