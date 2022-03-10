package fr.lernejo.logger;

public class CompositeLogger implements Logger{
    private final Logger[] loggers = new Logger[2];

    public CompositeLogger(Logger loggera, Logger loggerb) {
        loggers[0] = loggera;
        loggers[1] = loggerb;
    }

    @Override
    public void log(String msg) {
        loggers[0].log(msg);
        loggers[1].log(msg);
    }
}
