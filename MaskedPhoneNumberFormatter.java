import java.util.Scanner;

public class MaskedPhoneNumberFormatter {

    static String maskPhoneNumber(String phone) {

        // Check whether length is exactly 10
        if (phone.length() != 10) {
            return "Invalid phone number";
        }

        // Check whether all characters are digits
        for (int i = 0; i < phone.length(); i++) {

            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        // Get last 4 digits
        String lastFour = phone.substring(6);

        // Create masked number
        StringBuilder result = new StringBuilder("XXXXXX");

        // Insert hyphen
        result.insert(6, "-");

        // Add last four digits
        result.append(lastFour);

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String phone = sc.nextLine();

        System.out.println(maskPhoneNumber(phone));
    }
}