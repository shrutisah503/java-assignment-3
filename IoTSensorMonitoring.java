import java.util.Random;
import java.util.Scanner;

class RandomNumberGenerator extends Thread {

    public void run() {

        Random random = new Random();

        for (int i = 1; i <= 5; i++) {

            int number = random.nextInt(10) + 1;

            System.out.println("Generated: " + number);

            if (number % 2 == 0) {
                SquareCalculator square = new SquareCalculator(number);
                square.start();
            } else {
                CubeCalculator cube = new CubeCalculator(number);
                cube.start();
            }

            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                System.out.println("Generator interrupted");
            }
        }
    }
}


class SquareCalculator extends Thread {

    int number;

    SquareCalculator(int number) {
        this.number = number;
    }

    public void run() {

        int square = number * number;

        System.out.println("Square: " + square);
    }
}


class CubeCalculator extends Thread {

    int number;

    CubeCalculator(int number) {
        this.number = number;
    }

    public void run() {

        int cube = number * number * number;

        System.out.println("Cube: " + cube);
    }
}


public class IoTSensorMonitoring {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1. Start Simulation");
        System.out.println("2. Exit");

        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        if (choice == 1) {

            RandomNumberGenerator generator =
                new RandomNumberGenerator();

            generator.start();

        } else {

            System.out.println("Simulation exited.");
        }

        sc.close();
    }
}