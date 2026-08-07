//19. Largest among 3 numbers

import java.util.Scanner;
public class LargestNumber {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        //taking inputs from user.
        System.out.println("Enter 1st number: ");
        int a = input.nextInt();

        System.out.println("Enter 2nd number: ");
        int b = input.nextInt();

        System.out.println("Enter 3rd number: ");
        int c = input.nextInt();

        //conditions for largest number.
        if(a>=b && a>=c){
            System.out.println(a + "is the largest number");
        }
        else if(b>=c && b>=a){
            System.out.println(b + "is the largest number");
        }
        else{
            System.out.println(c + "is the largest number");
        }
        input.close();
    }
    
}
