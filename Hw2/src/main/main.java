package main;

import vector.Vector;

public class main {
    public static void main(String[] args) {
        Vector first = new Vector(3.0,4.0,5.0);
        Vector second = new Vector(6.0,8.0,10.0);
        System.out.println("first Vector length = " + first.len());
        System.out.println("second Vector length = " + second.len());
        System.out.println("Scalar multiplication = " + first.scalarMultiplication(second));
        System.out.println("Angle cos:" + first.findAngle(second));
    }    
}
