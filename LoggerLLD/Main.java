// Chain of Responsibility Pattern Implementation
package LoggerLLD;

public class Main {
    public static void main(String[] args) {
        LogProcessor loggerChain = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

        loggerChain.log(LogProcessor.ERROR, "This is an Error message.");
        loggerChain.log(LogProcessor.INFO, "This is a Info message.");
        loggerChain.log(LogProcessor.DEBUG, "This is an Debug message.");
    }
}
