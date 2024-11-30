package main;
import vehicles.*;
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner console = new Scanner(System.in);
        List<Car> carInstances = new ArrayList<>();
        List<Plane> planeInstances = new ArrayList<>();
        List<Ship> shipInstances = new ArrayList<>();
        List<Bicycle> bicycleInstances = new ArrayList<>();

        while (true) {
            try {
                System.out.println("""
                    Enter desired action: 
                    1) Create instance of vehicle
                    2) Delete instance of vehicle
                    3) Get info about all vehicles
                    4) Exit
                    """);
                String response = console.nextLine().trim();

                switch (response) {
                    case "1":
                        createVehicle(console, carInstances, planeInstances, shipInstances, bicycleInstances);
                        break;

                    case "2":
                        deleteVehicle(console, carInstances, planeInstances, shipInstances, bicycleInstances);
                        break;

                    case "3":
                        Vehicle.info();
                        break;

                    case "4":
                        System.out.println("Exiting program...");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                console.nextLine(); // Clear buffer
            } catch (IndexOutOfBoundsException e) {
                System.out.println("No instances available to delete in the selected category.");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    private static void createVehicle(Scanner console, List<Car> cars, List<Plane> planes, List<Ship> ships, List<Bicycle> bicycles) {
        try {
            System.out.println("""
                Which one?: 
                1) Car
                2) Plane
                3) Ship
                4) Bicycle
                """);
            String vecResp = console.nextLine().trim();

            switch (vecResp) {
                case "1":
                    cars.add(new Car(1, 2, 3, 4, 5, carBrands.Toyota, 4));
                    System.out.println("Car instance created.");
                    break;

                case "2":
                    planes.add(new Plane(1, 2, 3, 470, 5, planeBrands.Airbus, 6));
                    System.out.println("Plane instance created.");
                    break;

                case "3":
                    ships.add(new Ship(1, 2, 3, 45, 5, shipBrands.Maersk, 0));
                    System.out.println("Ship instance created.");
                    break;

                case "4":
                    bicycles.add(new Bicycle(1, 2, 3, 2, 5, bicycleBrands.Canyon, 2));
                    System.out.println("Bicycle instance created.");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } catch (Exception e) {
            System.out.println("Failed to create vehicle: " + e.getMessage());
        }
    }

    private static void deleteVehicle(Scanner console, List<Car> cars, List<Plane> planes, List<Ship> ships, List<Bicycle> bicycles) {
        try {
            System.out.println("""
                Which one to delete?: 
                1) Car
                2) Plane
                3) Ship
                4) Bicycle
                """);
            String vecResp = console.nextLine().trim();

            switch (vecResp) {
                case "1":
                    if (!cars.isEmpty()) {
                        Car toDelete1 = cars.remove(cars.size() - 1);
                        toDelete1.deleteInstance(null);
                        System.out.println("Car instance deleted.");
                    } else {
                        System.out.println("No cars to delete.");
                    }
                    break;

                case "2":
                    if (!planes.isEmpty()) {
                        Plane toDelete2 = planes.remove(planes.size() - 1);
                        toDelete2.deleteInstance(null);
                        System.out.println("Plane instance deleted.");
                    } else {
                        System.out.println("No planes to delete.");
                    }
                    break;

                case "3":
                    if (!ships.isEmpty()) {
                        Ship toDelete3 = ships.remove(ships.size() - 1);
                        toDelete3.deleteInstance(null);
                        System.out.println("Ship instance deleted.");
                    } else {
                        System.out.println("No ships to delete.");
                    }
                    break;

                case "4":
                    if (!bicycles.isEmpty()) {
                        Bicycle toDelete4 = bicycles.remove(bicycles.size() - 1);
                        toDelete4.deleteInstance(null);
                        System.out.println("Bicycle instance deleted.");
                    } else {
                        System.out.println("No bicycles to delete.");
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } catch (Exception e) {
            System.out.println("Failed to delete vehicle: " + e.getMessage());
        }
    }
}
