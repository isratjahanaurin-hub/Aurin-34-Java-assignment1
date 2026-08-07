//3. Palindrome number

import java.util.Scanner;
public class Palindrome {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int num = input.nextInt();

        int originalNum = num;
        int rev = 0;

        while (num > 0){
            int digit = num%10;
            rev = rev*10+digit;
            num=num/10;
        }
        if(originalNum == rev){
            System.out.println(originalNum + "is a Palindrome number");
        }
        else{
            System.out.println(originalNum + "is not a palindrome number");
            input.close();
        }
    }
}
