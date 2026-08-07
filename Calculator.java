//18. simple calculator using switch case

import java.util.Scanner;

public class Calculator {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter 1st number: ");
        double n1 = input.nextDouble();

        System.out.println("Enter a operator: ");
        String op = input.next();

        System.out.println("Enter 2nd number: ");
        double n2 = input.nextDouble();

        double result = 0;

        switch (op) {
            case "+":
                result=n1+n2;
                break;
              
            case "-":
                result=n1-n2;
                break;

            case "*":
                result=n1*n2;
                break;

            case "/":
                result=n1/n2;
                break;

            default:
                System.out.println("Invalid operator ");
                return;
        }
        System.out.println("Result: " + result);
        input.close();
    }
}
