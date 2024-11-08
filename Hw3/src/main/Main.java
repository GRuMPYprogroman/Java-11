package main;
import vehicles.Bicycle;
import vehicles.Car;
import vehicles.Vehicle;
import vehicles.carBrands;
import vehicles.shipBrands;
import vehicles.bicycleBrands;
import vehicles.planeBrands;
import vehicles.Ship;
import vehicles.Plane;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        Scanner console = new Scanner(System.in);
        List<Car> carInstances = new ArrayList<>();
        List<Plane> planeInstances = new ArrayList<>();
        List<Ship> shipInstances = new ArrayList<>();
        List<Bicycle> bicycleInstances = new ArrayList<>();

        while (true)
        {
            System.out.println("""
                Enter desired action: 
                1) Create instance of vehicle
                2) Delete instance of vehicle
                3) Get info about all vehicles
                4) Exit
                """);
            int response = console.nextInt();
            switch(response)
            {
                case 1:
                System.out.println("""
                    Which one?: 
                    1) Car
                    2) Plane
                    3) Ship
                    4) Bicycle
                    """);
                int vecResp = console.nextInt();
                switch(vecResp){
                    case 1:
                    Car car = new Car(1,2,3,4,5,carBrands.Toyota,4);
                    carInstances.add(car);
                        break;
                    case 2:
                    Plane plane = new Plane(1,2,3,4,5,planeBrands.Airbus,4);
                    planeInstances.add(plane);
                        break;
                    case 3:
                    Ship ship = new Ship(1,2,3,4,5,shipBrands.Maersk,4);
                    shipInstances.add(ship);
                        break;
                    case 4:
                    Bicycle bike = new Bicycle(1,2,3,4,5,bicycleBrands.Canyon,4);
                    bicycleInstances.add(bike);
                        break;
                }
                    break;
                case 2:
                System.out.println("""
                    Which one?: 
                    1) Car
                    2) Plane
                    3) Ship
                    4) Bicycle
                    """);
                int vecResp2 = console.nextInt();
                switch(vecResp2){
                    case 1:
                        Car toDelete1 = carInstances.get(carInstances.size()-1);
                        carInstances.remove(carInstances.size()-1);
                        toDelete1.deleteInstance(null);
                        break;
                    case 2:
                        Plane toDelete2 = planeInstances.get(planeInstances.size()-1);
                        planeInstances.remove(planeInstances.size()-1);
                        toDelete2.deleteInstance(null);
                        break;
                    case 3:
                        Ship toDelete3 = shipInstances.get(shipInstances.size()-1);
                        shipInstances.remove(shipInstances.size()-1);
                        toDelete3.deleteInstance(null);
                        break;
                    case 4:
                        Bicycle toDelete4 = bicycleInstances.get(bicycleInstances.size()-1);
                        bicycleInstances.remove(bicycleInstances.size()-1);
                        toDelete4.deleteInstance(null);    
                        break;
                }
                    break;
                case 3:
                    Vehicle.info();
                    break;
                case 4:
                    System.exit(response);
            } 
        }
    }   
}
