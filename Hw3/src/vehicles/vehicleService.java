package vehicles;

public interface vehicleService<T> {
    public void startEngine();
    public void turnRight();
    public void turnLeft();
    public void stopVehicle();
    public void accelerate();
    public void decelerate();
    public void deleteInstance(T instance);
}