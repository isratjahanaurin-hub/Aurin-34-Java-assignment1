// 2.Prime number
import java.util.Scanner;

public class PrimeNumber {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in); //for taking input from user
        int num = input.nextInt();

        boolean isPrime = num>1;
        for(int i = 2; i<num; i++){
            if (num%i == 0) //if the num is not a prime number
            {
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            System.out.println(num + " is a prime number.");
        }
        else{
            System.out.println(num + " is not a prime number.");
        }
    }
}
