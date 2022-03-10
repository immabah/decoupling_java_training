package fr.lernejo.logger;
import java.util.function.Predicate;

public class LoggerFactory {
    public static Logger getLogger(String name){
        Predicate<String> condition = message -> !message.contains("player");
        return new CompositeLogger(new FilteredLogger(new ContextualLogger(name, (Logger) new FileLogger("dlog.txt")), condition), new ContextualLogger(name, new ConsoleLogger()));
    }
}
