//6. Even Odd Number

import java.util.Scanner;

public class EvenOdd {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in); //for taking input from user
        int n = input.nextInt();

        if(n==0) //condition for Zero
        {
            System.out.println("Zero");
        }
        else if (n%2==0) //condition for even num
        {
            System.out.println("Even number");
        }
        else //if n%2!=0, then it'll be odd num
        {
            System.out.println("Odd number");
        }
        input.close();


    }
    
}
