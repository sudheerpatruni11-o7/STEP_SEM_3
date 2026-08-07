import java.util.Scanner;
public class STEP_Q1 {
     static void checkDuplicateSeats(int[] seatNumbers) {
        boolean found = false;
        for(int i = 0; i < seatNumbers.length; i++) {
            for(int j = i + 1; j < seatNumbers.length; j++) {
                if(seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate seats found" + seatNumbers[i]);
                    found = true;
                    return;
                }
                if(!found) {
                    System.out.println("There are no Duplicate seats found");
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] seatNumbers = {201,222,433,122,422};
        checkDuplicateSeats(seatNumbers);
    }
}