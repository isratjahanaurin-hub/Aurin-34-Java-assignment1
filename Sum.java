//12.sum of digits

import java.util.Scanner;
public class Sum {
    public static void main(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number: "); //taking an input from user

        int num = input.nextInt();
        int sum = 0;
        while(num>0)
        {
            int digit = num%10;
            sum += digit; //sum=sum+digit.
            num /= 10;
        }
        System.out.println("Sum of digits= "+sum);
        input.close();

    }
}
