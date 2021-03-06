package fr.lernejo.logger;

import java.util.function.Predicate;
public class FilteredLogger implements Logger {
    private final Logger delegateLogger;
    private final Predicate<String> predicate;

    public FilteredLogger(Logger delegate, Predicate<String> condition) {
        delegateLogger = delegate;
        predicate = condition;
    }

    @Override
    public void log(String msg) {
        if (predicate.test(msg))
            delegateLogger.log(msg);
    }
}
