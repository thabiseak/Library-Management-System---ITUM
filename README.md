# Library Management System - ITUM
## Description
This Java-based **Library Management System** allows users to manage a collection of books, borrow them, and return them. The system is designed for the **Institute of Technology, University of Moratuwa (ITUM)**, featuring various types of books including **Fiction**, **Non-Fiction**, **Historical**, **Mathematical**, and **Programming** books.

The system supports the following functionalities:

- Add books to the library based on genre.
- Display available books.
- Borrow and return books by users.
- Track the borrowed books of a user.
  
### Features
### Book Types (Enums):
- Fiction
- Non-Fiction
- Historical
- Mathematical
- Programming
- Unknown
  
### Key Components:
- **Book Class**: Defines the attributes and behaviors of a book including title, author, ISBN, availability status, and type.
- **Library Class**: Manages a list of books, providing methods to add, display, borrow, and return books.
- **User Class**: Represents a library user with the ability to borrow and return books and track their borrowed items.
  
## Main Functionalities:
**1. Add Books:** Add books to the library under specific categories such as Fiction, Non-Fiction, etc.

**2. Display Available Books:** Display the list of available books in the library.

**3. Borrow a Book:** Allows a user to borrow a book using the ISBN.

**4. Return a Book:** Enables users to return a borrowed book using the ISBN.

**5. Display Borrowed Books:** Display a list of books borrowed by the user.

## How to Run
**1. Compile the Program:**

Open a terminal or command prompt and compile the LibraryManagementSystem_ITUM.java file using the following command:

        javac LibraryManagementSystem_ITUM.java

**2. Run the Program:**

After compiling, run the program using the following command:

        java LibraryManagementSystem_ITUM

**3. Interact with the System:**

- You will be prompted to enter your User ID.
- Then, you can interact with the menu to add books, borrow or return books, and display available or borrowed books.

## System Menu
```
-------------------------------------------------------------------------------------------
                1. Add a Fiction Book
                2. Add a Non-Fiction Book
                3. Add a Historical Book
                4. Add a Mathematical Book
                5. Add a Programming Book
                6. Display available books
                7. Borrow a book
                8. Return a book
                9. Display borrowed books
                10. Exit
-------------------------------------------------------------------------------------------
```
You can choose an option by entering the corresponding number. Each option provides specific functionality as explained above.

## Sample Usage

**1. Adding a Book:**
You can add a book by choosing the option corresponding to the type of book. The system will prompt for the title, author, and ISBN.

**2. Displaying Available Books:**
The system will display all books that are currently available for borrowing.

**3. Borrowing a Book:**
Enter the ISBN of the book you want to borrow. If available, the system will allow you to borrow it.

**4. Returning a Book:**
Provide the ISBN of the book you have borrowed. The system will mark it as returned and make it available again.

**5. Displaying Borrowed Books:**
The system will display a list of all books you have borrowed.

## Example Output
```
Welcome to the Library Management System, Institute of Technology University of Moratuwa!

Enter user ID: 1


-------------------------------------------------------------------------------------------
                1. Add a Fiction Book
                2. Add a Non-Fiction Book
                3. Add a Historical Book
                4. Add a Mathematical Book
                5. Add a Programming Book
                6. Display available books
                7. Borrow a book
                8. Return a book
                9. Display borrowed books
                10. Exit
-------------------------------------------------------------------------------------------

Enter your choice: 6

Available Books:

Type: FICTION - To Kill a Mockingbird by F. Scott Fitzgerald (ISBN: 1)
Type: NON_FICTION - Sapiens: A Brief History of Humankind by Yuval Noah Harari (ISBN: 2)
Type: HISTORICAL - The Book Thief by Markus Zusak (ISBN: 3)
Type: MATHEMATICAL - The Joy of x by Steven Strogatz (ISBN: 4)
Type: PROGRAMMING - Clean Code: A Handbook of Agile Software Craftsmanship by Robert C. Martin (ISBN: 5)
```

## Technologies Used
- **Java**: The core language used for the implementation.
- **Enum**: For book type categorization.
- **Collections**: For managing books and borrowed book lists.
  
## Contributing
Feel free to submit issues or pull requests for improvements to the system.







