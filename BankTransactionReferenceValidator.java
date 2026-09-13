import java.util.Scanner;

public class BankTransactionReferenceValidator {

    static String normalizeReference(String raw) {

        // Remove spaces from beginning and end
        raw = raw.trim();

        // Convert first 3 characters to uppercase
        if (raw.length() >= 3) {

            String bankCode = raw.substring(0, 3).toUpperCase();

            String remaining = raw.substring(3);

            raw = bankCode + remaining;
        }

        return raw;
    }

    static String validateAndFormat(String reference) {

        // Step 1: Check length
        if (reference.length() != 14) {

            return "Invalid: wrong length";
        }

        // Step 2: Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {

            if (!Character.isLetter(reference.charAt(i))) {

                return "Invalid: bank code must be 3 letters";
            }
        }

        // Step 3: Check remaining 11 characters are digits
        for (int i = 3; i < 14; i++) {

            if (!Character.isDigit(reference.charAt(i))) {

                return "Invalid: body must contain only digits";
            }
        }

        // Extract bank code
        String bankCode = reference.substring(0, 3);

        // Extract date
        String date = reference.substring(3, 9);

        // Extract sequence number
        String sequence = reference.substring(9, 14);

        // Convert DDMMYY to DD/MM/YY
        String formattedDate =
                date.substring(0, 2) + "/" +
                date.substring(2, 4) + "/" +
                date.substring(4, 6);

        // Build final output
        StringBuilder result = new StringBuilder();

        result.append("[");
        result.append(bankCode);
        result.append("] DATE: ");
        result.append(formattedDate);
        result.append(" | SEQ: ");
        result.append(sequence);

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String raw = sc.nextLine();

        String reference = normalizeReference(raw);

        System.out.println(validateAndFormat(reference));
    }
}