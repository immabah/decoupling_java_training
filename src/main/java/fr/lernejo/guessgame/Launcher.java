package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;

public class Launcher {
    private static final Logger logger = LoggerFactory.getLogger("Launcher");

    public static void main(String[] args) {
        if (args == null || args.length <= 0) {
            logger.log("Entrez un argument ");
            assert args != null;

            logger.log("""
				Usage: Launcher -interactive/-auto <n>
				\t-interactive\tStart game with a number to guess between 0 and 100 & an infinite amount of trials (Player is you)
				\t-auto <n>\tStart game with a number between 0 and <n> and 1000 trials (Player is Computer)
				""");
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
                } catch (NumberFormatException ignored) {}
            }
            if (nbr == null) {
                logger.log("No correct");
                return;
            }
            Simulation simulation = new Simulation(new ComputerPlayer());
            simulation.initialize(nbr);
            simulation.loopUntilPlayerSucceed(1000);
        }
    }
}
