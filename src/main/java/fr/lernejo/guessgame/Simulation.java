package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Simulation {
    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long nbr = player.askNextGuess();
        if (nbr == numberToGuess) {
            return true;
        }
        if (nbr > numberToGuess) {
            logger.log(" Plus petit \n");
            player.respond(false);
        }else{
            logger.log(" Plus grand  \n");
            player.respond(false);
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
        long eLapsedTime = System.currentTimeMillis() - start;
        if(win)
        {
            logger.log(" Vous avez gagné \n");
        }else{
            logger.log(" Vous avez perdu \n");
        }
        logger.log("Temps total : "  + new SimpleDateFormat("mm:ss:SSS").format(new Date(eLapsedTime)));
    }
}
