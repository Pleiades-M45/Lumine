import java.util.Scanner;

class Factorial implements Runnable {
    int number;

    public Factorial(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        long fact = 1;
        for (int i = 1; i <= number; i++) {
            fact *= i;
        }
        System.out.println("Factorial of " + number + " : " + fact);
    }
}

class Reverse implements Runnable {
    int number;

    public Reverse(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        int rev = 0;
        while (number != 0) {
            rev = rev * 10 + number % 10;
            number /= 10;
        }
        System.out.println("Reverse of the number is: " + rev);
    }

    //  Alternate method to preserve leading zeros
    /*
    public void run() {
        String reversed = new StringBuilder(String.valueOf(number)).reverse().toString();
        System.out.println("Reverse of the number is: " + reversed);
    }
    */
}

public class FactorialReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number (max 20 to avoid overflow): ");
        int number = scanner.nextInt();

        Runnable factorialRunnable = new Factorial(number);
        Runnable reverseRunnable = new Reverse(number);

        Thread factorialThread = new Thread(factorialRunnable);
        Thread reverseThread = new Thread(reverseRunnable);

        factorialThread.start();

        try {
            factorialThread.join();
        } catch (InterruptedException e) {
            System.out.println("Factorial thread was interrupted.");
        }

        reverseThread.start();

        try {
            reverseThread.join();
        } catch (InterruptedException e) {
            System.out.println("Reverse thread was interrupted.");
        }

        scanner.close();
    }
}


/*
Enter the number (max 20 to avoid overflow): 19
Factorial of 19 : 121645100408832000
Reverse of the number is: 91


Enter the number (max 20 to avoid overflow): 20
Factorial of 20 : 2432902008176640000
Reverse of the number is: 2
*/