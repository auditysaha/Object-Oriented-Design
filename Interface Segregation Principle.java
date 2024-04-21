//*************************************************************************
// Title : A Java program to demonstrate Interface Segregation Principle.
// Author: Audity Saha, Undergraduate student, Khulna University.
//*************************************************************************

import java.util.ArrayList;
import java.util.List;

// Interface representing the ability to eat
interface Eatable {
    void eat();
}

// Interface representing the ability to drink
interface Drinkable {
    void drink();
}

// Interface representing the ability to run
interface Runnable {
    void run();
}

// Class representing a Batsman that can eat and run
class Batsman implements Eatable, Runnable {
    @Override
    public void eat() {
        System.out.println("Batsman is eating.");
    }

    @Override
    public void run() {
        System.out.println("Batsman is running.");
    }
}

// Class representing a Bowler that can drink
class Bowler implements Drinkable {
    @Override
    public void drink() {
        System.out.println("Bowler is drinking.");
    }
}

// Demo class demonstrating the usage of cricket players and the Interface Segregation Principle
public class InterfaceSegregationPrincipleDemo {
    public static void main(String[] args) {
        // Create a list of cricket players
        List<Object> players = new ArrayList<>();
        players.add(new Batsman());
        players.add(new Bowler());

        // Perform actions on each player
        for (Object player : players) {
            if (player instanceof Eatable) {
                ((Eatable) player).eat();
            }
            if (player instanceof Drinkable) {
                ((Drinkable) player).drink();
            }
            if (player instanceof Runnable) {
                ((Runnable) player).run();
            }
            System.out.println();
        }
    }
}

/**
 * In the above program, there are three interfaces for specific tasks like
 * eating, drinking, and running instead of a fat interface containing all 
 * the three tasks. As a result, the Batsman class can implement specific interfaces
 * like Eatable and Runnable, and similarly, the Bowler class can use the specific
 * Drinkable interface.
 */
