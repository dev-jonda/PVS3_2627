package basics;

public class Country {
    String name, continent;
    long population;
    double avgAge;

    // alt + insert

    public Country(String name, String continent, long population, double avgAge) {;
        this.name = name;
        this.continent = continent;
        this.population = population;
        this.avgAge = avgAge;
    }


    @Override
    public String toString() {
        return name + " (" + continent + ") [" + population + " people, average life expectancy: " + avgAge + "]";
    }
}
