package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;

public class Launcher {
    private static final Logger logger = LoggerFactory.getLogger("Launcher");

    public static void main(String[] args) {

        if (args == null || args.length <= 0) {
            logger.log(" Entrez un argument ");
            assert args != null;
            return;
        }
        if (args[0].equals("-interactive")) {
            Simulation simulation = new Simulation(new HumanPlayer());
            simulation.initialize(new SecureRandom().nextInt(100));
            simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);
        }
        if (args[0].equals("-auto")) {
            Long nbr = null;
            if (args.length >= 2) {
                try {
                    nbr = Long.parseLong(args[1]);
                } catch (NumberFormatException ignored) {
                }
            }
            if (nbr == null) {
                logger.log("Entrez un nombre correct");
                return;
            }
            Simulation simulation = new Simulation(new ComputerPlayer());
            simulation.initialize(nbr);
            simulation.loopUntilPlayerSucceed(1000);
        }
    }
}
