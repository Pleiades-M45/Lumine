import java.util.HashMap;
//import java.util.Map;
import java.util.Scanner;

public class HashMapStudent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        
        HashMap<Integer, String> s = new HashMap<>(n);

        for (int i = 0; i < n; i++) {
            sc.nextLine();
            System.out.print("Enter #" + (i + 1) + " Student Name: ");
            String name = sc.nextLine();
            
            System.out.print("Enter #" + (i + 1) + " Student RollNo: ");
            int roll = sc.nextInt();
            
            s.put(roll, name);
        }

        // for(Map.Entry<Integer, String> x : s.entrySet()){
        //     System.out.println("Roll Number: "+x.getKey()+", Name: "+x.getValue());
        // }

        System.out.println("------------------------");

        while (true) {
            System.out.print("\n1. Search\n2. Exit\nEnter your choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter RollNo: ");
                    int r = sc.nextInt();
                    sc.nextLine();

                    if (s.containsKey(r)) {
                        System.out.println("Name: " + s.get(r));
                    } else {
                        System.out.println("Student with RollNo " + r + " not found!");
                    }
                    break;

                case 2:sc.close(); return;

                default:
                    System.out.println("Invalid Choice!");
                    break;
            }
        }
    }
}
