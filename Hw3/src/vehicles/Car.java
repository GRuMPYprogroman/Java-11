package vehicles;

public final class Car extends Vehicle implements vehicleService<Car> {
    static int atAll = 0;
    public carBrands brand;
    public Car(int currSpeed,int relSpeed,int price, int maxPassengers,int envHarm,carBrands brand,int wheelAmount ){
        super(currSpeed,relSpeed,price,maxPassengers,envHarm,wheelAmount);
        this.brand = brand;
        ++atAll;
    }

    public void startEngine() {
        System.out.println(this.brand + "'s engine has been started");    
        this.currSpeed = 100;
    }

    public void turnRight() {
        System.out.println(this.brand + "'s turned right");    
    }

    public void turnLeft() {
        System.out.println(this.brand + "'s turned left");   
    }

    public void stopVehicle() {
        System.out.println(this.brand + "'s engine has been stopped");       
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

    public static void info() {
        System.out.print(atAll);  
    }


    @Override
    public void deleteInstance(Car instance)
    {
        atAll--;
        instance = null;
    }
}
