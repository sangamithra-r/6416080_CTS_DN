import java.util.*;
class Product {
    int id;
    String name;
    String category;
    public Product(int id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
public class e_commerce {
    public static Product linearSearch(List<Product> products, String searchKey) {
        for (Product product : products) {
            if (product.name.equalsIgnoreCase(searchKey)) {
                return product;
            }
        }
        return null;
    }
    public static Product binarySearch(List<Product> products, String searchKey) {
        int left = 0;
        int right = products.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            Product midProduct = products.get(mid);
            int comparison = midProduct.name.compareToIgnoreCase(searchKey);
            if (comparison == 0) return midProduct;
            else if (comparison < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }
    public static void printAllProducts(List<Product> products) {
        System.out.println("Available Products:");
        for (Product product : products) {
            System.out.println("- " + product.name + " (" + product.category + ")");
        }
    }
    public static void main(String[] args) {
        List<Product> storeItems = new ArrayList<>();
        storeItems.add(new Product(101, "iPhone", "Electronics"));
        storeItems.add(new Product(102, "Shirt", "Clothing"));
        storeItems.add(new Product(103, "Laptop", "Electronics"));
        storeItems.add(new Product(104, "Book", "Education"));
        printAllProducts(storeItems);
        System.out.println();
        String searchKey = "Laptop";
        Product foundLinear = linearSearch(storeItems, searchKey);
        System.out.println(foundLinear != null ? "Found by Linear Search: " + foundLinear
                                               : "Linear Search: '" + searchKey + "' not found.");
        storeItems.sort(Comparator.comparing(p -> p.name.toLowerCase()));
        Product foundBinary = binarySearch(storeItems, searchKey);
        System.out.println(foundBinary != null ? "Found by Binary Search: " + foundBinary
                                               : "Binary Search: '" + searchKey + "' not found.");
        String missingKey = "Tablet";
        Product notFoundLinear = linearSearch(storeItems, missingKey);
        Product notFoundBinary = binarySearch(storeItems, missingKey);
        System.out.println(notFoundLinear != null ? "Found: " + notFoundLinear
                                                  : "Linear Search: '" + missingKey + "' not found.");
        System.out.println(notFoundBinary != null ? "Found: " + notFoundBinary
                                                  : "Binary Search: '" + missingKey + "' not found.");
    }
}


/*
 * ANALYSIS
 *
 *
 * ========================================================
 * Exercise 2: E-commerce Platform Search Function
 * ========================================================
 *
 * This program demonstrates the implementation of two search algorithms — linear search and binary search —
 * in the context of an e-commerce platform where product search needs to be optimized for performance.
 *
 * ------------------------------
 * 1. Big O Notation
 * ------------------------------
 * Big O notation is a mathematical concept used to describe the time complexity of algorithms as the input size grows.
 * It helps developers analyze the performance of algorithms independently of machine-specific run times.
 * For example, O(1) represents constant time (no matter how big the input is), O(n) represents linear time,
 * and O(log n) represents logarithmic time, which grows much slower than linear time.
 *
 * ------------------------------
 * 2. Best, Average, and Worst-Case Scenarios
 * ------------------------------
 * For linear search, the best-case scenario occurs when the target element is at the beginning of the list, giving O(1) time.
 * The average case assumes the element is somewhere in the middle, and the worst case is when it's at the end or not present,
 * leading to O(n) time complexity. Binary search, which only works on sorted arrays, has a best-case of O(1)
 * (when the element is at the midpoint), and average/worst-case scenarios of O(log n), making it more efficient overall.
 *
 * ------------------------------
 * 3. Product Setup
 * ------------------------------
 * A `Product` class is defined with attributes such as productId, productName, and category. Products are stored in an array
 * for linear search, and in a sorted array (based on product name) for binary search. Both search algorithms are implemented
 * to demonstrate their functionality and performance.
 *
 * ------------------------------
 * 4. Time Complexity Analysis
 * ------------------------------
 * Linear search has a time complexity of O(n), which means it checks each element one by one. It's simple and does not require
 * sorting, making it suitable for small datasets. Binary search, however, has a time complexity of O(log n), making it significantly
 * faster for larger datasets. The trade-off is that it requires the data to be sorted.
 *
 * ------------------------------
 * 5. Conclusion
 * ------------------------------
 * In the context of an e-commerce platform, binary search is generally preferred due to its speed, especially when dealing with
 * large volumes of products. However, if the product list is small or frequently updated in ways that make sorting difficult,
 * linear search can be acceptable. This program demonstrates both search techniques with example data and helps compare their
 * efficiency in practice.
 */
