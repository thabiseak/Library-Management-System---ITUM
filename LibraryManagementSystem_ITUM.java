import java.util.*;

// Enum for Book Type
enum BookType {
    FICTION,
    NON_FICTION,
    HISTORICAL,
    MATHEMATICAL,
    PROGRAMMING,
    UNKNOWN
}

// Book class
class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean availability;
    private BookType bookType;

    public Book(String title, String author, String isbn, BookType bookType) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.availability = true;
        this.bookType = bookType;
    }

    // Getters and setters

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public BookType getBookType() {
        return bookType;
    }
}

// Library class
class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
        addDefaultBooks();
    }

    private void addDefaultBooks() {
        books.add(new Book("To Kill a Mockingbird","Lost Echoes","The Silent Minotaur","Whispers in the Dark","1984","The Catcher in the Rye","The Great Gatsby","F. Scott Fitzgerald", "1", BookType.FICTION));
        books.add(new Book("Chronicles of Science","The Art of Dreaming", "Exploring the Cosmos","Sapiens: A Brief History of Humankind", "Yuval Noah Harari", "2", BookType.NON_FICTION));
        books.add(new Book("Echoes of the Past","Sword of Destiny","The Golden Age","The Book Thief","Markus Zusak","3",BookType.HISTORICAL));
        books.add(new Book("Mathematics: A Beautiful Journey","Infinity and Beyond" ,"The Code of Equations","The Joy of x", "Steven Strogatz", "4", BookType.MATHEMATICAL));
        books.add(new Book("Coding Chronicles","Algorithms Unleashed","The Programmer's Mind","Clean Code: A Handbook of Agile Software Craftsmanship","Robert C. Martin","5",BookType.PROGRAMMING));
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("\t\tBook added to the library: " + book.getTitle());
    }

    public void displayAvailableBooks() {
        System.out.println("\n\t\tAvailable Books: \n");
        books.stream()
             .filter(Book::isAvailable)
             .forEach(book -> System.out.println("Type: " + book.getBookType() +
                     " - " + book.getTitle() + " by " + book.getAuthor() +
                     " (ISBN: " + book.getIsbn() + ")"));
    }

    public void borrowBook(User user, String isbn) {
        Optional<Book> bookToBorrow = books.stream()
                                          .filter(book -> book.getIsbn().equals(isbn) && book.isAvailable())
                                          .findFirst();
        if (bookToBorrow.isPresent()) {
            Book book = bookToBorrow.get();
            user.borrowBook(book);
            book.setAvailability(false);
            System.out.println("\t\tBook borrowed successfully: " + book.getTitle());
        } else {
            System.out.println("Book with ISBN " + isbn + " is not available for borrowing.");
        }
    }

    public void returnBook(User user, String isbn) {
        Optional<Book> bookToReturn = books.stream()
                                           .filter(book -> book.getIsbn().equals(isbn) && !book.isAvailable())
                                           .findFirst();
        if (bookToReturn.isPresent()) {
            Book book = bookToReturn.get();
            user.returnBook(book);
            book.setAvailability(true);
            System.out.println("\t\tBook returned successfully: " + book.getTitle());
        } else {
            System.out.println("Book with ISBN " + isbn + " cannot be returned or is not borrowed by the user.");
        }
    }
}

// User class
class User {
    private static int userCount = 1;
    private int userId;
    private List<Book> borrowedBooks;

    public User() {
        this.userId = userCount++;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public void displayBorrowedBooks() {
        System.out.println("\t\tBorrowed Books by User " + userId + ":");
        borrowedBooks.forEach(book -> System.out.println(book.getTitle() + " by " + book.getAuthor() + " (ISBN: " + book.getIsbn() + ")"));
    }
}

// Main class
public class LibraryManagementSystem_ITUM{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\n\nWelcome to the Library Management System,Institute of Technology University of Moratuwa!\n\nEnter user ID: ");
        User user = new User();
        int userId = scanner.nextInt();
        scanner.nextLine();
        user.setUserId(userId);

        Library library = new Library();

        while (true) {
            System.out.println("\n\n-------------------------------------------------------------------------------------------");
            System.out.println("\t\t\t1. Add a Fiction Book");
            System.out.println("\t\t\t2. Add a Non-Fiction Book");
            System.out.println("\t\t\t3. Add a Historical Book");
            System.out.println("\t\t\t4. Add a Mathematical Book");
            System.out.println("\t\t\t5. Add a Programming Book");
            System.out.println("\t\t\t6. Display available books");
            System.out.println("\t\t\t7. Borrow a book");
            System.out.println("\t\t\t8. Return a book");
            System.out.println("\t\t\t9. Display borrowed books");
            System.out.println("\t\t\t10. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook(scanner, library, BookType.FICTION);
                    break;
                case 2:
                    addBook(scanner, library, BookType.NON_FICTION);
                    break;
                case 3:
                    addBook(scanner, library, BookType.HISTORICAL);
                    break;
                case 4:
                    addBook(scanner, library, BookType.MATHEMATICAL);
                    break;
                case 5:
                    addBook(scanner, library, BookType.PROGRAMMING);
                    break;
                case 6:
                    library.displayAvailableBooks();
                    break;
                case 7:
                    borrowOrReturnBook(scanner, library, user, true);
                    break;
                case 8:
                    borrowOrReturnBook(scanner, library, user, false);
                    break;
                case 9:
                    user.displayBorrowedBooks();
                    break;
                case 10:
                    System.out.println("\nExiting the system. Thank you!");
                    System.exit(0);
                default:
                    System.out.println("\nInvalid choice. Please enter a number between 1 and 10.");
            }
        }
    }

    // Method to add a book based on user input
    private static void addBook(Scanner scanner, Library library, BookType bookType) {
        System.out.println("\nEnter details for a " + bookType + " Book!");
        System.out.print("\tTitle: ");
        String title = scanner.nextLine();
        System.out.print("\tAuthor: ");
        String author = scanner.nextLine();
        System.out.print("\tISBN: ");
        String isbn = scanner.nextLine();

        Book book = new Book(title, author, isbn, bookType);
        library.addBook(book);
    }

    // Method to borrow or return a book based on user input
    private static void borrowOrReturnBook(Scanner scanner, Library library, User user, boolean isBorrow) {
        String action = isBorrow ? "borrow" : "return";
        System.out.print("\nEnter the ISBN to " + action + " a book: ");
        String isbn = scanner.nextLine();
        if (isBorrow) {
            library.borrowBook(user, isbn);
        } else {
            library.returnBook(user, isbn);
        }
    }
}
