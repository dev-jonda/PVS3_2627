package Jondis.oop;

import fileworks.DataImport;

import java.util.ArrayList;
import java.util.List;

// Naimplementujte třídu reprezentující 1 hru/řádek
// Načtěte soubor
// Naimplementujte jednotlivé metody

public class GameTest {
    public static void main(String[] args) {
        DataImport di = new DataImport("data/steam_games.txt");

        List<Game> games = new ArrayList<>();
        String line;
        String[] params;
        while (di.hasNext()) {
            line = di.readLine();
            params = line.split("\t");

            switch (params.length) {
                case 4: games.add(new Game(params[0],
                        Double.parseDouble(params[1]),
                        Integer.parseInt(params[2]),
                        params[3]));
                break;

                case 3: games.add(new Game(params[0],
                        Double.parseDouble(params[1]),
                        Integer.parseInt(params[2])));
                break;


            }
        }

        System.out.println("Games total loaded: " + games.size());

        System.out.println("Number of free games: " + totalFreeGames(games));
        System.out.println("Average number of reviews per game: " + avgReviewPerGame(games));
        System.out.println("The most expensive game is: " + mostExpansive(games));

        System.out.println(games.get(0));                   // zdarma
        System.out.println(games.get(games.size() / 2));    // placené
        di.finishImport();
    }

    private static Game mostExpansive(List<Game> games) {
        Game mostExpansive = games.get(0);

        for (Game game : games) {
            if (game.getPrice() > mostExpansive.getPrice()) {
                mostExpansive = game;
            }
        }
        return mostExpansive;
    }

    private static long totalFreeGames(List<Game> games) {
        // TODO: vrátit počet her, které jsou zdarma

        return 0L; // tento řádek smažte
    }
    private static double avgReviewPerGame(List<Game> games) {
        // TODO: vrátit průměrný počet hodnocení

        return 0.0; // tento řádek smažte
    }
}

class Game {
    String name;
    double price;
    int num_reviews_total;
    String short_description;

    public Game(String name, double price, int num_reviews_total, String short_description) {
        this.name = name;
        this.price = price;
        this.num_reviews_total = num_reviews_total;
        this.short_description = short_description;
    }

    public Game(String name, double price, int num_reviews_total) {
        this.name = name;
        this.price = price;
        this.num_reviews_total = num_reviews_total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum_reviews_total() {
        return num_reviews_total;
    }

    public void setNum_reviews_total(int num_reviews_total) {
        this.num_reviews_total = num_reviews_total;
    }

    public String getShort_description() {
        if (short_description.equals("") && price == 0.0) {
            return "Not released yet";
        } else {
        return short_description;
        }
        // nevím, jestli to bude fungovat
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", num_reviews_total=" + num_reviews_total +
                ", short_description='" + getShort_description() + '\'' +
                '}';
    }
}
