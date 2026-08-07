//7. Leap Year
import java.util.Scanner;

public class LeapYear {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in); //taking input a year from user
        int year = input.nextInt();

        if((year%4==0 && year%100!=0) || (year%400==0)) //conditions for leap year
        {
            System.out.println(year+" is a leap year");
        }
        else
        {
            System.out.println(year+" is not a leap year");
        }
        input.close();
     
    }
}
