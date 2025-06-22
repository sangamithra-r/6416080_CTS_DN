import java.util.Scanner;
public class FinancialForecasting {
    static double forecast(double amount, double rate, int years) {
        if (years == 0) return amount;
        return forecast(amount * (1 + rate), rate, years - 1);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the initial investment amount (e.g. 10000): ");
        double amount = scanner.nextDouble();
        System.out.print("Enter the annual growth rate (in %, e.g. 10 for 10%): ");
        double rate = scanner.nextDouble() / 100; 
        System.out.print("Enter the number of years to forecast: ");
        int years = scanner.nextInt();
        double futureValue = forecast(amount, rate, years);
        System.out.printf("Forecasted value after %d years: ₹%.2f%n", years, futureValue);
        scanner.close();
    }
}

/*
 * ANALYSIS
 *
 *
 * ========================================================
 * Exercise 7: Financial Forecasting
 * ========================================================
 *
 * This program demonstrates the use of a recursive algorithm to forecast future financial values
 * based on past data and expected annual growth rates. It allows user input for principal amount,
 * growth rate, and forecast duration.
 *
 * ------------------------------
 * 1. Recursion Concept
 * ------------------------------
 * Recursion is a method where a function calls itself to solve smaller instances of a problem.
 * It is useful in situations where a problem can naturally be divided into similar sub-problems,
 * such as calculating compound interest over multiple years.
 *
 * In this case, recursion is used to compute the compounded value year by year until the desired
 * number of years is reached.
 *
 * ------------------------------
 * 2. Recursive Setup
 * ------------------------------
 * The recursive method `forecast` takes the initial amount, annual growth rate, and the number
 * of years to forecast. It multiplies the amount with (1 + rate) each year and continues the
 * process until the base case (0 years remaining) is met.
 *
 * ------------------------------
 * 3. Forecasting Logic
 * ------------------------------
 * At each recursive step, the method calculates the increased amount and calls itself with
 * one less year. This continues until the number of years becomes zero, at which point the
 * accumulated value is returned.
 *
 * ------------------------------
 * 4. Performance and Optimization
 * ------------------------------
 * The recursive approach is clean and easy to understand for small inputs, but it can lead to
 * performance issues or stack overflow if used for very large year counts.
 *
 * To optimize, an **iterative approach** or **memoization** could be used in real applications
 * to avoid deep recursion. However, for learning and demonstration purposes, recursion is ideal
 * to understand algorithmic thinking.
 *
 * ------------------------------
 * 5. Conclusion
 * ------------------------------
 * This program effectively shows how recursion can be applied to a financial forecasting problem
 * in a structured and readable way. While not always the most efficient method, it is a great
 * tool for educational purposes and conceptual clarity.
 */
