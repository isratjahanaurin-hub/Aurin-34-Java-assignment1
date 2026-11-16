import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a decimal number: "); // decimal numbers: 0,1,2,3,4,5,6,7,8,9.
        int n = sc.nextInt();
        
        // Convert decimal number to binary string
        String binary = Integer.toBinaryString(n);
        System.out.println("Binary: " + binary);
        sc.close();
    }
}