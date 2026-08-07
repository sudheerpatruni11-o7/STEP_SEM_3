public class STEP_Q4 {

    static void analyzeInventory(int[] sectionA, int[] sectionB) {

        int totalA = 0, totalB = 0;
        int max = sectionA[0];
        int index = 0;
        String section = "Section A";

        // Calculate total of Section A and find highest value
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];

            if (sectionA[i] > max) {
                max = sectionA[i];
                index = i;
                section = "Section A";
            }
        }

        // Calculate total of Section B and find highest value
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];

            if (sectionB[i] > max) {
                max = sectionB[i];
                index = i;
                section = "Section B";
            }
        }

        System.out.println("Section A Total: " + totalA);
        System.out.println("Section B Total: " + totalB);

        if (totalA == totalB) {
            System.out.println("Status: Balanced");
        } else {
            System.out.println("Status: Not Balanced");
        }

        System.out.println("Highest Quantity: " + max + " (" + section + ", Item " + (index + 1) + ")");
    }

    public static void main(String[] args) {

        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};

        analyzeInventory(sectionA, sectionB);
    }
}