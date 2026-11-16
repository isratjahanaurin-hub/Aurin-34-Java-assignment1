import java.util.Scanner;

public class NumberGCD {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter two numbers: ");
        int a = s.nextInt();
        int b = s.nextInt();
        
        //algorithm for GCD using while loop
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        System.out.println("GCD is: " + a);
        s.close();
    }
}