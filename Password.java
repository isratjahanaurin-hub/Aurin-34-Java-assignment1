import java.util.Scanner;

public class Password {
    public static void main(String[] args) {
        String correct = "Aurinnnnnn"; //here Aurinnnnnn is the correct password
        Scanner s = new Scanner(System.in);
        System.out.print("Enter password: ");
        String input = s.nextLine();
        
        // Validate password string
        if (input.equals(correct)) {
            System.out.println("Access Granted!");
        } else {
            System.out.println("Incorrect Password!");
        }
        s.close();
    }
}