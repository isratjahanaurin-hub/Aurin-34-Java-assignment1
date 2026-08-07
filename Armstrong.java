//4. Armstrong number

import java.util.Scanner;
public class Armstrong {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int num = input.nextInt();

        int originalNum = num;
        int sum = 0;

        while (num>0) {
            int digit = num%10;
            sum += (digit * digit * digit);
            num /= 10;
        }

        if (originalNum == sum){
            System.out.println(originalNum + " is an Armstrong number");
        }
        else {
            System.out.println(originalNum + " is not an Armstrong number");
            input.close();
        }
    }
}
