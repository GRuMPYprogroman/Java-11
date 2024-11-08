package vehicles;

public final class Plane extends Vehicle implements vehicleService<Plane> {
    static int atAll = 0;
    public int height;
    public planeBrands brand;
    public Plane(int currSpeed,int relSpeed,int price, int maxPassengers,int envHarm,planeBrands brand,int wheelAmount ){
        super(currSpeed,relSpeed,price,maxPassengers,envHarm,wheelAmount);
        this.brand = brand;
        ++atAll;
        this.height = 0;
    }

    public void startEngine() {
        System.out.println(this.brand + "'s engine has been started");    
        this.currSpeed = 150;    
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
        System.out.println(this.brand + "'s flying faster");    
        this.currSpeed += 10;    
    }

    public void decelerate() {
        System.out.println(this.brand + "'s flying slower");    
        this.currSpeed -= 10;    
    }

    public void heightIncrease()
    {
        System.out.println(this.brand + "'s height is increased");    
        this.height += 50;    
    }

    public void heightDecrease()
    {
        System.out.println(this.brand + "'s height is decreased");    
        this.currSpeed -= 50;    
    }

    static public void info() {
        System.out.print(atAll);  
    }
    
    @Override
    public void deleteInstance(Plane instance)
    {
        atAll--;
        instance = null;
    }
}
