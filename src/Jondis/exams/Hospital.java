package jondis.exams;

import fileworks.DataExport;
import fileworks.DataImport;
import jondis.oop.inheritance.hunters.Hunter;
import jondis.oop.inheritance.hunters.Soldier;
import jondis.oop.inheritance.hunters.Witcher;
import oop.inheritance.Doctor;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

// Načtěte ze souboru hospitalData informace o doktorech
// do souboru hospital.txt vypiste nasledujici informace o vsech doktorech:

// 1. Doktora s nejvetsim vydelkem
// 2. Doktora s nejmensjim vydelkem
// 3. Prumerny plat v nemocnici
// 4. Pocet realizovanych operací srdce
// 5. Pocet udelenych penalizaci nemocnici
//     - Nemocnice je penalizovana za kazdy zakrok doktora, na ktery nema kvalifikaci

// Bonus:
//   Vypiste 5 nejlepe placenych doktoru v nemocnici
//   Procentualni zastoupeni zamestnancu. (příklad: 50% Doktoři, 35% Chirurgové, 15% Kardiochirurgové)
//   Kdo způsobil největší penalizaci nemocnici

public class Hospital {
    static int sumOfPenalties;
    static int sumOfCardiacSurgeries;

    static void validateJob(jondis.exams.Doctor d, String[] jobType) {
        // implementujte logiku validace práce:
        // Doktor může dělat práci typu `jobType` jen pokud je kvalifikovan
        // C -> cardiacSurgery
        // S -> surgery
        // D -> diagnose

        for (int i = 2; i < jobType.length; i++) {
            switch (jobType[i]){
                case "C":
                    if (d instanceof jondis.exams.CardiacSurgeon) {
                        ((jondis.exams.CardiacSurgeon) d).cardiacSurgery();
                        d.numOfCardiacSurgeries += 1;
                        sumOfCardiacSurgeries += 1;
                    } else {
                        d.numOfPenalties += 1;
                        sumOfPenalties += 1;
                    }
                    break;
                case "S":
                    if (d instanceof jondis.exams.Surgeon) {
                        ((jondis.exams.Surgeon) d).surgery();
                    } else {
                        d.numOfPenalties += 1;
                        sumOfPenalties += 1;
                    }
                    break;
                case "D":
                    if (d instanceof jondis.exams.Doctor) {
                        ((jondis.exams.Doctor) d).diagnose();
                    } else {
                        d.numOfPenalties += 1;
                        sumOfPenalties += 1;
                    }
            }
        }
    }

    public static void main(String[] args) {
        DataImport di = new DataImport("data/hospitalData.txt");
        DataExport de = new DataExport("src/jondis/exams/hospital.txt");

        List<Doctor> doctors = new ArrayList<>();
        jondis.exams.Doctor currentDoctor;
        while (di.hasNext()) {
            String line = di.readLine();
            String[] tokens = line.trim().split(";");


            switch (tokens[1]){
                case "Doctor":
                    currentDoctor = new jondis.exams.Doctor(tokens[0]);
                    break;
                case "Surgeon":
                    currentDoctor = new Surgeon(tokens[0]);
                    break;
                case "CardiacSurgeon":
                    currentDoctor = new CardiacSurgeon(tokens[0]);
                    break;
            }
            // doctors.add(currentDoctor);

        }

//        jondis.exams.Doctor best = doctors.getFirst();
//
//        for(Doctor doctor : doctors){
//            if(doctor.salary > best.salary){
//                best = doctor;
//            }
//        }
//        System.out.println("1. Nejlepší výplatu má:"+best);
//
//
//        jondis.exams.Doctor worst = doctors.getFirst();
//
//        for(Doctor doctor : doctors){
//            if(doctor.salary < worst.salary){
//                worst = doctor;
//            }
//        }
//        System.out.println("2. Nejhorší výplatu má: "+worst);

        System.out.println("4. Počet realizovaných operací srdce: "+sumOfCardiacSurgeries);

        System.out.println("5. Počet udělených penalizací nemocnicí: "+sumOfPenalties);


        System.out.println("To asi nebylo worth");
        // nezapomenout na úklid
        di.finishImport();
        de.finishExport();
    }
}
