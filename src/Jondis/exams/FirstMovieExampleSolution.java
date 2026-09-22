package jondis.exams;

import fileworks.DataExport;
import fileworks.DataImport;

import java.util.ArrayList;

class Movie{
    String name;
    int year;
    String genre;
    double rating;

    public Movie(String name, int year, String genre, double rating) {
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * Komentář k metodě - popis co dělá
     * @return - popis co vrací
     */

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                '}';
    }
}

public class FirstMovieExampleSolution {
    public static void main(String[] args) {
        DataImport di = new DataImport("src/jondis/exams/data/movieList.txt");
        DataExport de = new DataExport("horrors.txt");





        Movie bestFilm = new Movie(null, 0, null, Double.MIN_VALUE /* 0.0 nebo Double.MIN_NORMAL nebo Double.MIN_VALUE */);
        ArrayList<Movie> movies = new ArrayList<>();
        int numberOfHorrors = 0;
        int postMilenium = 0;

        // 1. vypsat nejslepší film dle hodnocení
        while (di.hasNext()){
            String line = di.readLine();
            String[] data = line.split(";");

            Movie movie = new Movie(
                    data[0],
                    Integer.parseInt(data[1]),
                    data[2],
                    Double.parseDouble(data[3])
            );

            if (movie.rating > bestFilm.getRating()) {
                bestFilm = movie;
            }

            // 3. vyfiltrovat horrory
            if (movie.genre.equalsIgnoreCase("horror")) {
                numberOfHorrors++;
                de.writeLine(movie.toString());
            }

            // 2. spočítat filmy po roce 2000
            if (movie.year >= 2000) {
                postMilenium++;
            }

            movies.add(movie);
        }

        int post2015 = 0;
        for (Movie m : movies){
            System.out.println(m);
            if(m.year == 2015) post2015++;
        }

        System.out.println("The best movie of all time is: " + bestFilm);
        System.out.println("Number of films postmilenium: " + postMilenium);
        System.out.println("Number of horrors: " + numberOfHorrors);
        System.out.println("Total: " + movies.size());

        di.finishImport();
        de.finishExport();
    }
}
