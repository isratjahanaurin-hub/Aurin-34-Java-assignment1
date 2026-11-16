import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int n = s.nextInt();
        
        int t1 = 0, t2 = 1;
        System.out.print("Series: " + t1 + ", " + t2);
        
        // Generate Fibonacci terms
        for (int i = 3; i <= n; i++) {
            int next = t1 + t2;
            System.out.print(", " + next);
            t1 = t2;
            t2 = next;
        }
        s.close();
    }
}