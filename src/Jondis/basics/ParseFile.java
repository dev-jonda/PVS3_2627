package Jondis.basics;

import fileworks.DataImport;

public class ParseFile {
    public static void main(String[] args) {
        String path = "data/countries.txt";
        DataImport di = new DataImport(path);

//       // di.printFile();
//       System.out.println(di.readLine()); // výpis jednoho řádku

//       // TODO: Vypsat informace jednoho řádku
//       String name;
//       String continent;
//       long population;
//       double avgAge;

//       // vypsat celý obsah bez printFile
//       // di.reinitializeRead();
//       while (di.hasNext()) {
//           System.out.println(di.readLine());
//       }

//       // načíst je z jednoho řádku
//       String line = di.readLine();
//       String[] tokens = line.split(";");

//       name = tokens[0];
//       continent = tokens[1];
//       population = Long.parseLong(tokens[2]);
//       avgAge = Double.parseDouble(tokens[3]);


//       System.out.println(name);
//       System.out.println(continent);
//       System.out.println(population);
//       System.out.println(avgAge);

        Country czechia = new Country("Czech Republic", "Europe", 10_800_000, 85.0);

        System.out.println(czechia);

        // Vypsat všechny řádky jako objekty (třídy Country)
        // 1. Přečíst soubor
        //  1.1 Přečíst řádek
         String line = di.readLine();
         String []tokens = line.split(";");

         String name = tokens[0];
         String continent = tokens[1];
         long population = Long.parseLong(tokens[2]);
         double avgAge = Double.parseDouble(tokens[3]);

         Country oneCountry = new Country(
                 name,
                 continent,
                 population,
                 avgAge
         );
        System.out.println(oneCountry);

        di.finishImport();
,    }
}
