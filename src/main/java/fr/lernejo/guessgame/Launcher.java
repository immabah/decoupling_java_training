package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
    public static void main() {
        Simulation simulation = new Simulation(new HumanPlayer());
        SecureRandom random = new SecureRandom();
        simulation.initialize(random.nextInt(100));
        // long randomNumber = random.nextLong(); // génère un nombre entre Long.MIN_VALUE et Long.MAX_VALUE
        //long random Number = random.nextInt(100); // génère un nombre entre 0 (inclus) et 100 (exclus)
        simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);
    }
}
