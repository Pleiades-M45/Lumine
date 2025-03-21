class Mul implements Runnable {
    @Override
    public void run() {
        System.out.println("Multiplication Table: ");
        for (int i = 1; i <= 10; i++) {
            System.out.println("\t5 * " + i + " = " + (5 * i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Fact implements Runnable {
    @Override
    public void run() {
        System.out.println("Factors of 36: ");
        for (int i = 1; i <= 36; i++) {
            if (36 % i == 0) {
                System.out.println("F(36): " + i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Mul());
        Thread t2 = new Thread(new Fact());
        t1.start();
        t2.start();
    }
}

/*
Factors of 36: 
F(36): 1
Multiplication Table:
        5 * 1 = 5
F(36): 2
        5 * 2 = 10
F(36): 3
F(36): 4
        5 * 3 = 15
F(36): 6
        5 * 4 = 20
F(36): 9
F(36): 12
        5 * 5 = 25
F(36): 18
F(36): 36
        5 * 6 = 30
        5 * 7 = 35
        5 * 8 = 40
        5 * 9 = 45
        5 * 10 = 50
*/