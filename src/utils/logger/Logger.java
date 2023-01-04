package src.utils.logger;

public class Logger {
    public void info(String message) {
        System.out.printf("[Info]    %s%n", message);
    }

    public void info(int message) {
        System.out.printf("[Info]    %s%n", message);
    }

    public void info(double message) {
        System.out.printf("[Info]    %s%n", message);
    }

    public void warning(String message) {
        System.out.printf("\u001B[33m[Warning] %s\u001B[0m%n", message);
    }

    public void error(String message) {
        System.out.printf("\u001B[31m[Error]   %s\u001B[0m%n", message);
    }

    public void success(String message) {
        System.out.printf("\u001B[32m[Success] %s\u001B[0m%n", message);
    }
}
