//8.Celcius to fahrenheit

import java.util.Scanner;

public class CelciusToFahrenheit {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a termperature in celcius: "); //taking input from user
        Double celsius = input.nextDouble();
        double fahrenheit = (celsius*1.8)+32; //formula for converting celsius into fahrenheit
        System.out.println("temperature in fahrenheit: " +fahrenheit);
        input.close();
    }
}
