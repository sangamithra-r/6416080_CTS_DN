import java.util.Scanner;
interface Document {
    void open();
}
class PdfDocument implements Document {
    public void open() {
        System.out.println("Opening PDF document...");
    }
}
class WordDocument implements Document {
    public void open() {
        System.out.println("Opening Word document...");
    }
}
class ExcelDocument implements Document {
    public void open() {
        System.out.println("Opening Excel document...");
    }
}
abstract class DocumentFactory {
    abstract Document createDocument();
}
class PdfFactory extends DocumentFactory {
    Document createDocument() {
        return new PdfDocument();
    }
}
class WordFactory extends DocumentFactory {
    Document createDocument() {
        return new WordDocument();
    }
}
class ExcelFactory extends DocumentFactory {
    Document createDocument() {
        return new ExcelDocument();
    }
}
public class FactoryMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose document type to open:");
        System.out.println("1. PDF");
        System.out.println("2. Word");
        System.out.println("3. Excel");
        System.out.print("Enter choice (1-3): ");
        int choice = scanner.nextInt();
        DocumentFactory factory;
        switch (choice) {
            case 1:
                factory = new PdfFactory();
                break;
            case 2:
                factory = new WordFactory();
                break;
            case 3:
                factory = new ExcelFactory();
                break;
            default:
                System.out.println("Invalid choice.");
                scanner.close();
                return;
        }
        Document document = factory.createDocument();
        document.open();
        scanner.close();
    }
}

/*
 * ========================================================
 * Exercise 2: Implementing the Factory Method Pattern 
 * ========================================================
 *
 * DESCRIPTION:
 * This Java program demonstrates the Factory Method Design Pattern using a document creation scenario.
 * It allows users to choose between creating different types of documents (PDF, Word, Excel),
 * and creates the appropriate object using factory classes, hiding the creation logic from the main program.
 *
 * --------------------------------------------------------
 * PURPOSE OF FACTORY METHOD:
 * - To encapsulate object creation.
 * - To provide a way to create objects without specifying the exact class of object being created.
 * - Helps achieve loose coupling and easier scalability.
 *
 * --------------------------------------------------------
 * HOW THE CODE WORKS:
 * - An interface `Document` defines a common method `open()` for all document types.
 * - Classes `PdfDocument`, `WordDocument`, and `ExcelDocument` implement the `Document` interface.
 * - Abstract class `DocumentFactory` has a method `createDocument()`.
 * - Concrete factories like `PdfFactory`, `WordFactory`, and `ExcelFactory` implement the method
 *   and return instances of the respective document types.
 * - In the `main()` method, user input determines which factory to use, and the corresponding document is opened.
 *
 * --------------------------------------------------------
 * USER INPUT:
 * - The program asks the user to enter a number (1 to 3) to select a document type.
 * - Based on the input, the correct factory creates and opens the corresponding document.
 *
 * --------------------------------------------------------
 * SAMPLE OUTPUT:
 * Choose document type to open:
 * 1. PDF
 * 2. Word
 * 3. Excel
 * Enter choice (1-3): 3
 * Opening Excel document...
 *
 * --------------------------------------------------------
 * BENEFITS:
 * - Flexibility: Adding new document types requires minimal changes.
 * - Clean Code: Separates object creation logic from usage.
 * - Maintainability: Easy to understand and extend in large-scale applications.
 *
 * --------------------------------------------------------
 * CONCLUSION:
 * This example demonstrates how the Factory Method Pattern helps create different objects based on user input.
 * It is commonly used in software development to maintain clean and scalable code by following the principles of OOP.
 */
