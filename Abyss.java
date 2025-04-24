1) Derive a class Book from Publisher. Derive class Employee from Department. Display details of books and employees using thread.
    
// Publisher class
class Publisher {
    private String publisherName;
    private String address;

    public Publisher(String publisherName, String address) {
        this.publisherName = publisherName;
        this.address = address;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Publisher: " + publisherName + ", Address: " + address;
    }
}

// Book class derived from Publisher
class Book extends Publisher {
    private String bookTitle;
    private String author;

    public Book(String publisherName, String address, String bookTitle, String author) {
        super(publisherName, address);
        this.bookTitle = bookTitle;
        this.author = author;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return super.toString() + ", Book: " + bookTitle + ", Author: " + author;
    }
}

// Department class
class Department {
    private String departmentName;

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    @Override
    public String toString() {
        return "Department: " + departmentName;
    }
}

// Employee class derived from Department
class Employee extends Department {
    private String employeeName;
    private String employeeRole;

    public Employee(String departmentName, String employeeName, String employeeRole) {
        super(departmentName);
        this.employeeName = employeeName;
        this.employeeRole = employeeRole;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeRole() {
        return employeeRole;
    }

    @Override
    public String toString() {
        return super.toString() + ", Employee: " + employeeName + ", Role: " + employeeRole;
    }
}

// Thread to display Book details
class BookThread extends Thread {
    private Book book;

    public BookThread(Book book) {
        this.book = book;
    }

    @Override
    public void run() {
        System.out.println("Book Details: " + book);
    }
}

// Thread to display Employee details
class EmployeeThread extends Thread {
    private Employee employee;

    public EmployeeThread(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void run() {
        System.out.println("Employee Details: " + employee);
    }
}

// Main class to demonstrate the usage of threads
public class Main {
    public static void main(String[] args) {
        // Create Book and Employee objects
        Book book1 = new Book("Penguin", "123 Book St.", "Java Programming", "John Doe");
        Book book2 = new Book("HarperCollins", "456 Book Rd.", "Data Structures", "Jane Smith");

        Employee employee1 = new Employee("IT Department", "Alice", "Developer");
        Employee employee2 = new Employee("HR Department", "Bob", "Manager");

        // Create Threads for Books and Employees
        Thread bookThread1 = new BookThread(book1);
        Thread bookThread2 = new BookThread(book2);

        Thread employeeThread1 = new EmployeeThread(employee1);
        Thread employeeThread2 = new EmployeeThread(employee2);

        // Start the threads
        bookThread1.start();
        bookThread2.start();

        employeeThread1.start();
        employeeThread2.start();
        
        // Wait for all threads to finish
        try {
            bookThread1.join();
            bookThread2.join();
            employeeThread1.join();
            employeeThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

Book Details: Publisher: Penguin, Address: 123 Book St., Book: Java Programming, Author: John Doe
Book Details: Publisher: HarperCollins, Address: 456 Book Rd., Book: Data Structures, Author: Jane Smith
Employee Details: Department: IT Department, Employee: Alice, Role: Developer
Employee Details: Department: HR Department, Employee: Bob, Role: Manager

-----------------------------------------------
2) Create two threads-Factorial thread which finds the factorial of a number and reverse thread which finds the reverse of a number by user input. Ensure that the factorial is printed before the reverse of the number.
import java.util.Scanner;

class FactorialThread extends Thread {
    private int number;

    public FactorialThread(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        long factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        System.out.println("Factorial of " + number + " is: " + factorial);
    }
}

class ReverseThread extends Thread {
    private int number;

    public ReverseThread(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        int reversed = 0;
        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        System.out.println("Reverse of the number is: " + reversed);
    }
}

public class Main {
    public static void main(String[] args) {
        // Create scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        // Input number for factorial and reverse
        System.out.print("Enter a number for Factorial and Reverse: ");
        int number = scanner.nextInt();
        
        // Create Factorial thread and Reverse thread
        FactorialThread factorialThread = new FactorialThread(number);
        ReverseThread reverseThread = new ReverseThread(number);
        
        // Start the Factorial thread
        factorialThread.start();
        
        // Use join to ensure the factorial thread finishes before the reverse thread
        try {
            factorialThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Start the Reverse thread after the Factorial thread completes
        reverseThread.start();
        
        // Wait for the Reverse thread to finish as well
        try {
            reverseThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        scanner.close();  // Close scanner object
    }
}

Enter a number for Factorial and Reverse: 5
Factorial of 5 is: 120
Reverse of the number is: 5

-----------------------------------------------
3) Shared resource "Programming".One thread will remove a character from right side and other thread will remove character from left side. Implement concurrent execution.
class SharedResource {
    private StringBuilder str;

    public SharedResource(String str) {
        this.str = new StringBuilder(str);
    }

    // Method to remove a character from the left side
    public synchronized void removeFromLeft() {
        if (str.length() > 0) {
            System.out.println("Removing from Left: " + str.charAt(0));
            str.deleteCharAt(0);  // Remove the leftmost character
            System.out.println("Current String: " + str);
        }
    }

    // Method to remove a character from the right side
    public synchronized void removeFromRight() {
        if (str.length() > 0) {
            System.out.println("Removing from Right: " + str.charAt(str.length() - 1));
            str.deleteCharAt(str.length() - 1);  // Remove the rightmost character
            System.out.println("Current String: " + str);
        }
    }

    // Check if the string is empty
    public boolean isEmpty() {
        return str.length() == 0;
    }
}

// Thread to remove character from left
class LeftRemovalThread extends Thread {
    private SharedResource sharedResource;

    public LeftRemovalThread(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        while (!sharedResource.isEmpty()) {
            sharedResource.removeFromLeft();
            try {
                Thread.sleep(500);  // Simulate some processing time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Thread to remove character from right
class RightRemovalThread extends Thread {
    private SharedResource sharedResource;

    public RightRemovalThread(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        while (!sharedResource.isEmpty()) {
            sharedResource.removeFromRight();
            try {
                Thread.sleep(500);  // Simulate some processing time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Initialize the shared resource with the string "Programming"
        SharedResource sharedResource = new SharedResource("Programming");

        // Create and start both threads
        LeftRemovalThread leftThread = new LeftRemovalThread(sharedResource);
        RightRemovalThread rightThread = new RightRemovalThread(sharedResource);

        leftThread.start();
        rightThread.start();

        // Wait for both threads to complete
        try {
            leftThread.join();
            rightThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Final String: " + sharedResource);
    }
}

Removing from Left: P
Current String: rogramming
Removing from Right: g
Current String: programmin
Removing from Left: r
Current String: ogrammin
Removing from Right: n
Current String: programmi
Removing from Left: o
Current String: grammi
Removing from Right: i
Current String: gramm
Removing from Left: g
Current String: ramm
Removing from Right: m
Current String: ram
Removing from Left: r
Current String: am
Removing from Right: a
Current String: r
Removing from Left: a
Current String: 
Final String: 

-----------------------------------------------------------------------------------
4) Write a program that writes even numbers from an array to a file and retrive that values and print on screen.

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EvenNumberFileIO {

    // Method to write even numbers to a file
    public static void writeEvenNumbersToFile(int[] numbers, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int number : numbers) {
                if (number % 2 == 0) {
                    writer.write(number + "\n");  // Write even number to file
                }
            }
            System.out.println("Even numbers written to the file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to read numbers from a file and return them as a List
    public static List<Integer> readNumbersFromFile(String fileName) {
        List<Integer> evenNumbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                evenNumbers.add(Integer.parseInt(line));  // Add each number to the list
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return evenNumbers;
    }

    public static void main(String[] args) {
        // Array of numbers to process
        int[] numbers = {12, 15, 18, 20, 25, 30, 33, 40};

        // File name to store even numbers
        String fileName = "even_numbers.txt";

        // Write even numbers to file
        writeEvenNumbersToFile(numbers, fileName);

        // Read even numbers from file
        List<Integer> evenNumbers = readNumbersFromFile(fileName);

        // Print even numbers read from file
        System.out.println("Even numbers retrieved from the file:");
        for (int number : evenNumbers) {
            System.out.println(number);
        }
    }
}

Even numbers written to the file successfully.
Even numbers retrieved from the file:
12
18
20
30
40

-----------------------------------------------
5) Read text from console, write to a file and display the contents of the file.

import java.io.*;
import java.util.Scanner;

public class ConsoleToFile {

    // Method to write text to a file
    public static void writeToFile(String text, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(text);  // Write the text to the file
            System.out.println("Text written to the file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to read text from a file and display it
    public static void readFromFileAndDisplay(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("\nContents of the file:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);  // Display the contents of the file
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter text
        System.out.println("Enter some text (type 'exit' to stop):");

        // Read multi-line input from the console
        StringBuilder inputText = new StringBuilder();
        String line;
        while (!(line = scanner.nextLine()).equalsIgnoreCase("exit")) {
            inputText.append(line).append("\n");
        }

        // File name to store the text
        String fileName = "output.txt";

        // Write the input text to the file
        writeToFile(inputText.toString(), fileName);

        // Read and display the contents of the file
        readFromFileAndDisplay(fileName);

        // Close the scanner
        scanner.close();
    }
}

Enter some text (type 'exit' to stop):
Hello, this is a test.
This is the second line.
exit

Text written to the file successfully.

Contents of the file:
Hello, this is a test.
This is the second line.
