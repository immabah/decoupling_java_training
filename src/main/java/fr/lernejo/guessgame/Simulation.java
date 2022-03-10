package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Simulation {
    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long nbr;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.nbr = numberToGuess;
    }

    private boolean nextRound() {
        long nbr = player.askNextGuess();
        if (nbr == nbr) {
            return true;
        }
        if (nbr > nbr) {
            logger.log(" Plus petit \n");
            player.respond(false);
        }else{
            logger.log(" Plus grand  \n");
            player.respond(true);
        }
        return false;
    }

    public void loopUntilPlayerSucceed(long maxLoops) {
        boolean win = false;
        long start = System.currentTimeMillis();
        for (int i = 0; i < maxLoops; i++) {
            if (nextRound()) {
                win = true;
                break;
            }
        }
        long time = System.currentTimeMillis() - start;
        if(win)
        {
            logger.log(" Vous avez gagné \n");
        }else{
            logger.log(" Vous avez perdu \n");
        }
        logger.log("Temps total : "  + new SimpleDateFormat("mm:ss:SSS").format(new Date(time)));
    }
}
