package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player{
    private static final Logger logger =  LoggerFactory.getLogger("player");

    @Override
    public long askNextGuess(){
        long val = -1;
        try {
            val = new Scanner(System.in).nextLong();
        } catch (Exception e) {
            logger.log("No correct !");
        }
        return val;
    }
    @Override
    public void respond(boolean lowerOrGreater) {
    }

}
