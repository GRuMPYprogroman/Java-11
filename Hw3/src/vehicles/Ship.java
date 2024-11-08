package vehicles;

public final class Ship extends Vehicle implements vehicleService<Ship> {
    static int atAll = 0;
    public shipBrands brand;
    public Ship(int currSpeed,int relSpeed,int price, int maxPassengers,int envHarm,shipBrands brand,int wheelAmount ){
        super(currSpeed,relSpeed,price,maxPassengers,envHarm,wheelAmount);
        this.brand = brand;
        ++atAll;
    }

    public void startEngine() {
        System.out.println(this.brand + "'s motor has been started");    
        this.currSpeed = 60;    
    }

    public void turnRight() {
        System.out.println(this.brand + "'s turned right");    
    }

    public void turnLeft() {
        System.out.println(this.brand + "'s turned left");   
    }

    public void stopVehicle() {
        System.out.println(this.brand + "'s motor has been stopped");    
        this.currSpeed = 0;    
    }

    public void accelerate() {
        System.out.println(this.brand + "'s speed has been increased, it's swimming faster");    
        this.currSpeed += 10;    
    }

    public void decelerate() {
        System.out.println(this.brand + "'s speed has been decreased, it's swimming slower");    
        this.currSpeed -= 10;    
    }

    static public void info() {
        System.out.print(atAll);  
    }

    @Override
    public void deleteInstance(Ship instance)
    {
        atAll--;
        instance = null;
    }
}
