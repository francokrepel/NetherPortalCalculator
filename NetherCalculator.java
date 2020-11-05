import java.util.Arrays;
import java.util.Scanner;

public class NetherCalculator {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int x, y, z;
        boolean calculatorOn = true;

        while (calculatorOn) {
            System.out.println("What is your current x-coordinate?");
            x = scanner.nextInt();
            System.out.println("What is your current y-coordinate?");
            y = scanner.nextInt();
            System.out.println("What is your current z-coordinate?");
            z = scanner.nextInt();
            System.out.println("(" + x + ", " + y + ", " + z + ")");
            int[] netherStart = netherValue(x, y, z);

            System.out.println("What is your destination x-coordinate?");
            x = scanner.nextInt();
            System.out.println("What is your destination y-coordinate?");
            y = scanner.nextInt();
            System.out.println("What is your destination z-coordinate?");
            z = scanner.nextInt();
            int[] netherEnd = netherValue(x, y, z);

            //System.out.println("You need to travel (" + Arrays.toString(distances(netherStart, netherEnd)) + ") in the x, y, z, respectively");
            System.out.println("Place your portal in the same direction at: " + Arrays.toString(resultCoords(netherStart, distances(netherStart, netherEnd))));
            System.out.println("-----\n1. Calculate Again\n2. Exit\n-----");

            while (true) { //menu loop
                int menuSelection = scanner.nextInt();
                if (menuSelection == 1)
                    break;
                else if (menuSelection == 2) {
                    calculatorOn = false;
                    break;
                } else {
                    System.out.println("invalid number, try again");
                    continue;
                }
            }
        }

    }

    public static int[] netherValue(int x, int y, int z) {
        int[] result = new int[3];
        result[0] = x / 8;
        result[1] = y;
        result[2] = z / 8;
        return result;
    }

    public static int[] distances(int[] start, int[] result) {
        int[] distances = new int[3];
        for (int i = 0; i < 3; i++) {
            distances[i] = result[i] - start[i];
            }
        return distances;
    }

    public static int[] resultCoords(int[] start, int[] distances) {
        int[] result = new int[3];
        for (int i = 0; i < 3; i++) {
            result[i] = start[i] + distances[i];
        }
        return result;

    }
}
