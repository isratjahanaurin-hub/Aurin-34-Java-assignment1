import java.util.Scanner;

public class NumberLCM {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter two numbers: ");
        int a = s.nextInt();
        int b = s.nextInt();
        
        int x = a, y = b;
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        //formula for Lcm: (a * b) / GCD
        int lcm = (a * b) / x;
        System.out.println("LCM is: " + lcm);
        s.close();
    }
}