//16. number swap.

import java.util.Scanner;
public class NumberSwap {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        //taking inputs from user
        System.out.println("Enter 1st number: ");
        int a = input.nextInt();

        System.out.println("Enter 2nd number: ");
        int b = input.nextInt();

        a = a + b;
        b = a - b;
        a = a - b;
        
        //to print the swapping numbers. 
        System.out.println("By swapping numbers: ");
        System.out.println("a = "+a);
        System.out.println("b = "+b);
        input.close();

    }
}
