//4. Strong number

import java.util.Scanner;
public class StrongNumber {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int num = input.nextInt();

        int abc = num;
        int sum = 0;

        while (abc>0) {
            int digit = abc%10;
            int fact = 1; //factorial
            for(int i=1; i<=digit; i++){
                fact *= i;
            }
            sum += fact;
            abc /= 10;
        }

        if (sum == num){
            System.out.println(num + " is an strong number");
        }
        else {
            System.out.println(abc + " is not a strong number");
            input.close();
        }
    }
}

