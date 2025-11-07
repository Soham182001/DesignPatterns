package SingletonPatternLLD;

public class SingletonDemo {
    public static void main(String[] args) {
        LoggerSingleton inst1 = LoggerSingleton.getInstance();
        System.out.println(inst1);

        LoggerSingleton inst2 = LoggerSingleton.getInstance();
        System.out.println(inst2);
    }
}
