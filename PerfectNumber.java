import java.util.Scanner;

public class PerfectNumber {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = s.nextInt();
        int sum = 0;
        
        // Sum proper divisors
        for (int i = 1; i < num; i++) {
            if (num % i == 0) sum += i; //exp:6. 6 can be devided by 1,2,3,6. 1+2+3=6. therefore 6 is perfect number.
        }
        
        if (sum == num && num > 0) {
            System.out.println("Perfect Number.");
        } else {
            System.out.println("Not a Perfect Number.");
        }
        s.close();
    }
}