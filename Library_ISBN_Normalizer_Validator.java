import java.util.Scanner;

public class Library_ISBN_Normalizer_Validator {

    static String normalizeCode(String raw) {

        // Remove spaces from beginning and end
        raw = raw.trim();

        // Convert first 3 characters to uppercase
        if (raw.length() >= 3) {

            String publisherCode =
                    raw.substring(0, 3).toUpperCase();

            String remaining =
                    raw.substring(3);

            raw = publisherCode + remaining;
        }

        return raw;
    }

    static String validateAndFormat(String code) {

        // Check length
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {

            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Check remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {

            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        // Extract publisher code
        String publisherCode =
                code.substring(0, 3);

        // Extract year
        String year =
                code.substring(3, 7);

        // Extract catalog number
        String catalog =
                code.substring(7, 13);

        // Build final output
        StringBuilder result = new StringBuilder();

        result.append("[");
        result.append(publisherCode);
        result.append("] YEAR: ");
        result.append(year);
        result.append(" | CATALOG: ");
        result.append(catalog);

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String raw = sc.nextLine();

        String code = normalizeCode(raw);

        System.out.println(validateAndFormat(code));
    }
}