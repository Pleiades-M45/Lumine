import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NameList {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        while(true){
            System.out.print("\n1.Add\n2.Remove\n3.Search\n4.Sort\n5.Display\n6.Exit\nEnter your choice: ");
            int ch = sc.nextInt();
            sc.nextLine();
            System.out.print("\n");
            switch(ch){
                case 1:
                    System.out.print("Enter the name to add: ");
                    String name = sc.nextLine();
                    names.add(name);
                    System.out.println(name + " added Successfully !");
                    break;

                case 2:
                    System.out.print("Enter the name to remove: ");
                    String n = sc.nextLine();
                    if(names.remove(n)){
                        System.out.println( n + " removed Succesfully !");
                    }
                    else{
                        System.out.println( n + " not present !!");
                    }
                    break;

                case 3:
                    System.out.print("Enter the name to search: ");
                    String s = sc.nextLine();
                    if(names.indexOf(s) < 0){
                        System.out.println( s + " not present !!");
                    }
                    else{
                        System.out.println( s + " present at position " + (names.indexOf(s) + 1));
                    }
                    break;

                case 4:
                    Collections.sort(names);
                    System.out.println("\tSorted List\n-----------------------");
                    for(String x: names) System.out.println(x);
                    System.out.println("-----------------------");
                    break;

                case 5:
                    if(names.isEmpty()){
                        System.out.println("Empty List !!");
                    }
                    else{
                        System.out.println("\n-----------------------");
                        for(String x: names) System.out.println(x);
                        System.out.println("-----------------------");
                    }
                    break;

                case 6:sc.close(); System.exit(0);

                default:System.out.println("\nInvalid Choice\n"); break;
            }
        }
    }
}