//***********************************************************************
// Title : A Java program to demonstrate Liskov Substitution Principle.
// Author: Audity Saha, Undergraduate student, Khulna University.
//***********************************************************************

import java.util.ArrayList;
import java.util.List;

/**
 * Interface representing a country.
 */
interface Country {
    /**
     * Retrieves the population of the country.
     *
     * @return The population of the country.
     */
    double getPopulation();
}

/**
 * Class representing a large country.
 */
class LargeCountry implements Country {
    private double population;

    /**
     * Constructs a new LargeCountry object with the given population.
     *
     * @param population The population of the country.
     */
    public LargeCountry(double population) {
        this.population = population;
    }

    @Override
    public double getPopulation() {
        return population;
    }
}

/**
 * Class representing a small country, which is a special case of a large country.
 */
class SmallCountry implements Country {
    private double population;

    /**
     * Constructs a new SmallCountry object with the given population.
     *
     * @param population The population of the country.
     */
    public SmallCountry(double population) {
        this.population = population;
    }

    @Override
    public double getPopulation() {
        return population;
    }
}

/**
 * Demo class demonstrating the usage of countries and the Liskov Substitution Principle.
 */
class LiskovSubstitutionPrincipleDemo {
    /**
     * Calculates the total population of countries and prints it.
     *
     * @param countries The list of countries.
     */
    public static void calculateTotalPopulation(List<Country> countries) {
        double totalPopulation = 0;
        for (Country country : countries) {
            totalPopulation += country.getPopulation();
        }
        System.out.println("Total population of countries: " + totalPopulation);
    }

    public static void main(String[] args) {
        // Create a list of countries
        List<Country> countries = new ArrayList<>();
        countries.add(new LargeCountry(1000000000)); // Large country with 1 billion population
        countries.add(new SmallCountry(1000000));   // Small country with 1 million population

        // Calculate and print the total population of countries
        calculateTotalPopulation(countries);
    }
}

/**
 * The SmallCountry class is a subtype of LargeCountry, and we can substitute
 * a SmallCountry object for a LargeCountry object without affecting the correctness
 * of the program. This adheres to the Liskov Substitution Principle.
 */
