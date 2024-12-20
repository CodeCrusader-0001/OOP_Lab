import java.util.Scanner;

public class GasMileage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double totalMiles = 0, totalGallons = 0;

        while (true) {
            System.out.print("Enter miles driven (-1 to quit): ");
            int miles = sc.nextInt();
            if (miles == -1) break;

            System.out.print("Enter gallons used: ");
            double gallons = sc.nextDouble();

            totalMiles += miles;
            totalGallons += gallons;

            System.out.printf("Miles per gallon for this trip: %.2f%n", miles / gallons);
            System.out.printf("Combined miles per gallon: %.2f%n", totalMiles / totalGallons);
        }
    }
}
