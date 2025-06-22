package LibraryManagementSystem;

import java.util.Arrays;
import java.util.Scanner;

class Book {
    int bookId;
    String title;
    String author;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title.toLowerCase();
        this.author = author.toLowerCase();
    }

    public String toString() {
        return "[" + bookId + ", " + title + ", " + author + "]";
    }
}

class LibraryManagementSystem {

    public static Book linearSearch(Book[] books, String targetTitle) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(targetTitle)) return b;
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String targetTitle) {
        int left = 0, right = books.length - 1;
        targetTitle = targetTitle.toLowerCase();
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = books[mid].title.compareTo(targetTitle);
            if (cmp == 0) return books[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book(101, "The Alchemist", "Paulo Coelho"),
            new Book(102, "Atomic Habits", "James Clear"),
            new Book(103, "Wings of Fire", "A. P. J. Abdul Kalam"),
            new Book(104, "Zero to One", "Peter Thiel"),
            new Book(105, "Ikigai", "Francesc Miralles")
        };

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter book title to search: ");
        String title = sc.nextLine();

        System.out.println("\n--- Linear Search ---");
        Book linearResult = linearSearch(books, title);
        System.out.println(linearResult != null ? linearResult : "Book not found");

        Arrays.sort(books, (b1, b2) -> b1.title.compareToIgnoreCase(b2.title));

        System.out.println("\n--- Binary Search ---");
        Book binaryResult = binarySearch(books, title);
        System.out.println(binaryResult != null ? binaryResult : "Book not found");

        sc.close();
    }
}
