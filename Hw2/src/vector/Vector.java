package vector;

import java.util.List;
import java.util.ArrayList;

public final class Vector {

    private double x;
    private double y;
    private double z;

    public Vector(double x0,double y0,double z0) {
        this.x = x0;
        this.y = y0;
        this.z = z0;
    }

    public Vector(){
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }

    public void setX(double x0) { this.x = x0; }
    public void setY(double y0) { this.y = y0; }
    public void setZ(double z0) { this.z = z0; }

    public double len(){
        return Math.sqrt(Math.pow(x,2) + Math.pow(y,2) + Math.pow(z,2));
    }

    public double scalarMultiplication(Vector another)
    {
        return (this.x * another.x + this.y * another.y + this.z * another.z);
    }

    public Vector vectorMultiplication(Vector another)
    {
        Vector newVector = new Vector(
                this.y*another.z-this.z*another.y,
                this.z*another.x-this.x*another.z,
                this.x*another.y-this.y*another.x);
        return newVector;
    }

    public double findAngle(Vector another) {
        double len1 = this.len();
        double len2 = another.len();

        if (len1 == 0 || len2 == 0) {
            throw new ArithmeticException("Невозможно вычислить угол с нулевым вектором.");
        }

        double numerator = scalarMultiplication(another);
        double denominator = len1 * len2;
        return numerator / denominator;
    }

    public Vector sumVec(Vector another){
        Vector newVector = new Vector(
                this.x+another.x,
                this.y+another.y,
                this.z+another.z);
        return newVector;
    }

    public Vector subtVec(Vector another){
        Vector newVector = new Vector(
                this.x-another.x,
                this.y-another.y,
                this.z-another.z);
        return newVector;
    }

    public static List<Vector> createVectors(int N){
        List<Vector> vectorsList = new ArrayList<>(N);

        for (int i = 0; i < N; ++i)
        {
            Vector newVector = new Vector(
                    Math.random() * 100 + 1,
                    Math.random() * 100 + 1,
                    Math.random() * 100 + 1
            );
            vectorsList.add(newVector);
        }

        return vectorsList;
    }

}
