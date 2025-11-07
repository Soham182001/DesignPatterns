package SingletonPatternLLD;

public class LoggerSingleton {
    private static LoggerSingleton instance = null;
    
    private LoggerSingleton(){
        if(instance != null){
            throw new RuntimeException("Not accessible");
        }
    }

    public static LoggerSingleton getInstance() {
        if(instance == null){
            synchronized(LoggerSingleton.class){
                if(instance == null){
                    instance = new LoggerSingleton();
                }
            }
        }
        return instance;
    }
}
