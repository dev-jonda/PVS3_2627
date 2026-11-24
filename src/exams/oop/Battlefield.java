package exams.oop;

import fileworks.DataExport;
import fileworks.DataImport;

import java.util.ArrayList;
import java.util.List;

public class Battlefield {
    static void doAction(Weapon w, String actionType) {
        // TODO:
        //  Provest akci, jen pokud je Weapon w instance správné třídy, jinak nic
    }

    private static void exportStatistics(DataExport de, List<Weapon> weapons) {
        de.writeLine("Loaded " + weapons.size() + " weapons.");
        de.writeLine("Total XPs gained by using weapons: " + xpGained(weapons));
        de.writeLine("Total mana spent by using all weapons: " + manaSpent(weapons));
    }

    private static List<Weapon> loadData(DataImport di) {
        List<Weapon> toReturn = new ArrayList<>();

        while (di.hasNext()) {
            String line = di.readLine().strip();
            String[] parts = line.split(";");

            String classType = parts[0];
            String name = parts[1];
            int damage = Integer.parseInt(parts[2]);

            // TODO:
            // 1. Přidat do listu toReturn správnou instanci podle classType (Weapon/MagicWeapon)
            // 2. Provést všechny akce zbraně
        }

        return toReturn;
    }

    public static double xpGained(List<Weapon> weapons) {
        double totalXp = 0;

        for (Weapon weapon : weapons) {
            totalXp += weapon.getXp();
        }

        return totalXp;
    }

    public static double manaSpent(List<Weapon> weapons) {
        // TODO: vrátit celkovou spotřebovanou manu všech MagicWeapon instancí
        return 0.0;
    }

    public static void main(String[] args) {
        DataImport di = new DataImport("data/weapons.txt");
        DataExport de = new DataExport("data/weaponStatistics.txt");

        List<Weapon> weapons = loadData(di);
        exportStatistics(de, weapons);

        di.finishImport();
        de.finishExport();
    }
}
