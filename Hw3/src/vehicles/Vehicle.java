package vehicles;

public abstract sealed class Vehicle permits Car, Plane, Bicycle, Ship
{
    protected int currSpeed;
    protected final int relativeSpeed;
    protected final double costPrice;
    protected final int maxPassengers;
    protected final int envHarm;
    protected final int wheelAmount;


    Vehicle(int currSpeed, int relativeSpeed,int price, int maxPassengers,int envHarm,int wheelAmount){
        this.currSpeed = currSpeed;
        this.relativeSpeed = relativeSpeed;
        this.costPrice = price;
        this.maxPassengers = maxPassengers;
        this.envHarm = envHarm;
        this.wheelAmount = wheelAmount;
    }

    public static void info() {
        System.out.println("Now, you have:\nCars: ");
        Car.info();
        System.out.println("\nShips: ");
        Ship.info();
        System.out.println("\nPlanes: ");
        Plane.info();
        System.out.println("\nBicycles: ");
        Bicycle.info();
    }

    
}