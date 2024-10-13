package zero1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class zero2_ClosestCoordinateFinder {
    public static double calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> coordinatesSet = new HashSet<>();

        System.out.print("나의 x 좌표: ");
        int myX = scanner.nextInt();
        System.out.print("나의 y 좌표: ");
        int myY = scanner.nextInt();

        int[][] coordinates = new int[10][2];
        int count = 0;

        while (count < 10) {
            System.out.println("임의의 좌표 입력 (x, y): ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            String coordString = x + "," + y;
            if (coordinatesSet.contains(coordString)) {
                System.out.println("이미 입력된 좌표입니다. 다른 좌표를 입력하세요.");
            } else {
                coordinatesSet.add(coordString);
                coordinates[count][0] = x;
                coordinates[count][1] = y;
                count++;
            }
        }

        double minDistance = Double.MAX_VALUE;
        int closestX = 0, closestY = 0;

        for (int i = 0; i < coordinates.length; i++) {
            int x = coordinates[i][0];
            int y = coordinates[i][1];
            double distance = calculateDistance(myX, myY, x, y);

            if (distance < minDistance) {
                minDistance = distance;
                closestX = x;
                closestY = y;
            }
        }

        System.out.printf("나와 가장 가까운 좌표값은 (%d, %d)입니다.\n", closestX, closestY);
    }
}
