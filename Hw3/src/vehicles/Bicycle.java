package vehicles;

public final class Bicycle extends Vehicle implements vehicleService<Bicycle> {
    static int atAll = 0;
    public bicycleBrands brand;
    public Bicycle(int currSpeed,int relSpeed,int price, int maxPassengers,int envHarm,bicycleBrands brand,int wheelAmount ){
        super(currSpeed,relSpeed,price,maxPassengers,envHarm,wheelAmount);
        this.brand = brand;
        ++atAll;
    }

    public void startEngine() {
        System.out.println("You started working with your legs on " + this.brand);    
        this.currSpeed = 40;    
    }

    public void turnRight() {
        System.out.println(this.brand + "'s turned right");    
    }

    public void turnLeft() {
        System.out.println(this.brand + "'s turned left");   
    }

    public void stopVehicle() {
        System.out.println(this.brand + " has just stopped");    
        this.currSpeed = 0;    
    }

    public void accelerate() {
        System.out.println(this.brand + "'s speed has been increased");    
        this.currSpeed += 10;    
    }

    public void decelerate() {
        System.out.println(this.brand + "'s speed has been decreased");    
        this.currSpeed -= 10;    
    }

    static public void info() {
        System.out.print(atAll);  
    }
    
    @Override
    public void deleteInstance(Bicycle instance)
    {
        atAll--;
        instance = null;
    }
}
