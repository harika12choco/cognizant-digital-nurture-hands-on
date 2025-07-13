package platform;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Product {
    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String toString() {
        return "[" + productId + ", " + productName + ", " + category + "]";
    }
}

public class EcommerceSearchFunction {

    public static Product linearSearch(Product[] products, int targetId) {
        for (Product p : products) {
            if (p.productId == targetId) return p;
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (products[mid].productId == targetId) return products[mid];
            else if (products[mid].productId < targetId) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(105, "Shoes", "Fashion"),
            new Product(101, "Mobile", "Electronics"),
            new Product(104, "Laptop", "Electronics"),
            new Product(102, "Watch", "Accessories"),
            new Product(103, "Book", "Education")
        };

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Product ID to search: ");
        int searchId = sc.nextInt();

        System.out.println("\n--- Linear Search ---");
        Product result1 = linearSearch(products, searchId);
        System.out.println(result1 != null ? result1 : "Product not found");

        System.out.println("\n--- Binary Search ---");
        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));
        Product result2 = binarySearch(products, searchId);
        System.out.println(result2 != null ? result2 : "Product not found");
        
        sc.close();
    }
}
