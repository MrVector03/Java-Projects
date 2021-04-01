package corporateEmailSystem.java;

import java.util.Scanner;
import java.util.Random;

public class corporateEmailSystem {

    public void newEmployee(){
        Scanner input = new Scanner(System.in);
        System.out.print("First name: ");
        String name = input.next();

        System.out.print("Last name: ");
        String lastName = input.next();

        Random random = new Random();

        // New employee chooses their department and the email is created
        System.out.println("Choose your department:\n1. Business\n2. Software\n3. Hardware\n4. Management");
        System.out.println("Department: ");
        String department;
        do {
            department = input.next();
            if (department.equals("1") || department.equalsIgnoreCase("business")) {
                department = "business";
                break;
            } else if (department.equals("2") || department.equalsIgnoreCase("software")) {
                department = "software";
                break;
            } else if (department.equals("3") || department.equalsIgnoreCase("hardware")) {
                department = "hardware";
                break;
            } else if (department.equals("4") || department.equalsIgnoreCase("management")) {
                department = "management";
                break;
            } else {
                System.out.println("Incorrect input");
            }
        }while(true);
        String email = name.toLowerCase() + lastName.toLowerCase() + "@neolife." + department + ".com";
        System.out.println("Your email: " + email);

        // Creating the password
        String capitals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowers = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "1234567890";
        String specials = "#!$%@&";
        String overall = capitals + lowers + numbers + specials;
        StringBuilder password = new StringBuilder();

        // ensuring the minimum requirements for the password
        password.append(capitals.charAt(random.nextInt(capitals.length())));
        password.append(lowers.charAt(random.nextInt(lowers.length())));
        password.append(numbers.charAt(random.nextInt(numbers.length())));
        password.append(specials.charAt(random.nextInt(specials.length())));

        // adding 4 more characters for the complete password
        for (int i = 0; i < 4; i++){
            password.append(overall.charAt(random.nextInt(overall.length())));
        }
        System.out.println("Your password: " + password);
    }

    public static void main(String[] args){
        corporateEmailSystem newMail = new corporateEmailSystem();
        newMail.newEmployee();
    }
}
