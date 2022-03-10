package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("Simulation");
    private final Player player;
    private long nToGuess;

    public Simulation(Player player) {
        this.player=player;
    }

    public void initialize(long nToGuess) {
        this.nToGuess = nToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        //System.out.println(" Entrez un nombre ");
        long guess = player.askNextGuess();
        if (guess == nToGuess) {

            return true;
        }
        if (guess > nToGuess) {
            logger.log(" Entrez un plus petit nombre \n");
            player.respond(false);
        }else{
            logger.log(" Entrez un plus grand nombre \n");
            player.respond(true);
        }

        return false;
    }

    public void loopUntilPlayerSucceed(long mL) {
        boolean win = false;
        long dp = System.currentTimeMillis();
        for (int i = 0; i < mL; i++) {
            if (nextRound()) {
                win = true;
                break;
            }
        }
        long time = System.currentTimeMillis() - dp;
        if(win)
        {
            logger.log(" Vous avez gagné \n");
        }else{
            logger.log(" Vous avez perdu \n");
        }
        logger.log(" Temps total : "  + new SimpleDateFormat("mm:ss:SSS").format(new Date(time)));
    }
}
