package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class ComputerPlayer implements Player{
    private int est = -1;
    private int max;
    private int min;
    private boolean rslt;

    @Override
    public long askNextGuess() {
        if (est == -1) {
            max = 100;
            min = 0;
            est = (int) new SecureRandom().nextLong(min, max);
        }
        if (rslt){
            min = est;
            est = (int) new SecureRandom().nextLong(min, max);
        }
        else
        {
            max = est;
            est = (int) new SecureRandom().nextLong(min, max);
        }
        return est;
    }
    @Override
    public void respond(boolean lowerOrGreater) {
        rslt = lowerOrGreater;
    }
}
