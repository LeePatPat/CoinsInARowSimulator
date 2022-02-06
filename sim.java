import java.lang.Math;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of coin tosses in a row to count: ");
        int tossesInRow = sc.nextInt();

        System.out.println("Total number of tosses: ");
        int totalTosses = sc.nextInt();

        sc.close();

        if (totalTosses < tossesInRow) {
            System.out.println("Think you're funny, aye?");
            System.exit(0);
        }

        // run 10000 times for a solid sample size, ensuring good accuracy.
        int runsThatHadXTossesInRow = 0;
        for (int i = 1; i <= 10000; i++) {
            System.out.println("");
            if (doesRunHaveXHeadsInRow(tossesInRow, totalTosses)) {
                runsThatHadXTossesInRow++;
                System.out.println("Running sample #" + i + ": true");
            } else {
                System.out.println("Running sample #" + i + ": false");
            }
        }

        float p = ((float) runsThatHadXTossesInRow / 10000) * 100;

        System.out.println("SIMULATION FINISHED: " + runsThatHadXTossesInRow + "/10000 samples had " + tossesInRow
                + " heads in a row appear.");
        System.out.print("Probability of heads showing up " + tossesInRow + " times in a row for " + totalTosses
                + " total tosses: ");
        System.out.printf("%.2f %", p);
    }

    private static boolean doesRunHaveXHeadsInRow(int tossesInRow, int totalTosses) {
        Random r = new Random();

        int headsInRow = 0;
        for (int i = 0; i < totalTosses; i++) {
            boolean isHeads = r.nextBoolean();
            if (isHeads) {
                headsInRow++;
                if (headsInRow == tossesInRow)
                    return true;
            } else {
                headsInRow = 0;
            }
        }

        return false;
    }
}