import java.util.Scanner;
class LogManager {
    private static LogManager instance;
    private LogManager() {
        System.out.println("LogManager initialized.");
    }
    public static LogManager getLogger() {
        if (instance == null) {
            instance = new LogManager();
        }
        return instance;
    }
    public void writeLog(String message) {
        System.out.println("Log: " + message);
    }
}
public class Singleton_Pattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LogManager logger = LogManager.getLogger();
        System.out.print("Enter number of log messages: ");
        int count = scanner.nextInt();
        scanner.nextLine(); 
        for (int i = 1; i <= count; i++) {
            System.out.print("Enter log message " + i + ": ");
            String input = scanner.nextLine();
            logger.writeLog(input);
        }
        LogManager logger2 = LogManager.getLogger();
        System.out.println("Checking if both logger instances are same: " + (logger == logger2));
        scanner.close();
    }
}

/*
 * ========================================================
 * Exercise 1: Implementing the Singleton Pattern 
 * ========================================================
 *
 * Description:
 * This Java program demonstrates the Singleton design pattern by creating a logging utility 
 * that ensures only one instance of the logger is used across the application. This is helpful 
 * in maintaining consistent logging behavior and saving memory.
 *
 * How It Works:
 * The `LogManager` class uses a private static instance variable and a private constructor 
 * to control object creation. The method `getLogger()` checks if the instance already exists. 
 * If not, it creates one. Otherwise, it returns the existing instance. This guarantees that 
 * only one logger instance exists throughout the program.
 *
 * User Input:
 * The `Singleton_Pattern` class prompts the user to input how many messages they want to log. 
 * Then it collects each message and logs it using the Singleton logger instance. This demonstrates 
 * how the same logger is reused to handle all input messages.
 *
 * Singleton Verification:
 * The program tries to get a second logger instance using `getLogger()` and compares it to 
 * the first one. If both references point to the same object, the Singleton pattern is successfully implemented.
 *
 * Advantage of Singleton:
 * Singleton provides a single point of access to a shared resource such as a logger or configuration manager. 
 * It avoids creating multiple instances, which saves memory and prevents unexpected behavior in the application.
 *
 * Sample Output:
 * LogManager initialized.
 * Enter number of log messages: 2  
 * Enter log message 1: Server started  
 * Log: Server started  
 * Enter log message 2: Connection successful  
 * Log: Connection successful  
 * Checking if both logger instances are same: true
 *
 * Conclusion:
 * This exercise clearly shows how the Singleton pattern works in a real-world scenario. It ensures that 
 * only one object handles all the logging operations, making the program more efficient and maintainable.
 */
