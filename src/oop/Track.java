package oop;

public class Track {
    String name;
    int year;
    double rating;
    int duration;

    public Track(String name, int year, double rating, int duration) {
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Track{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                ", duration=" + duration +
                '}';
    }

    public void setDuration(int duration) {
        if(duration < 0){
            System.out.println("Invalid duration");
            return;
        }

        this.duration = duration;
    }

    public void setRating(double rating) {
        if(rating < 0.0 || rating > 10.0){
            System.out.println("Invalid rating");
            return;
        }

        this.rating = rating;
    }


    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public double getRating() {
        return rating;
    }

    public int getDuration() {
        return duration;
    }
}
