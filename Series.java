import java.util.Scanner;

public class Series {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int sum = 0;
        
        // Sum of natural numbers series
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println("Sum of series: " + sum);
        sc.close();
    }
}