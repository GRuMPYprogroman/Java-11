package main;

import vector.Vector;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vector first = null;
        Vector second = null;

        try {
            System.out.println("Введите компоненты первого вектора (x y z):");
            double x1 = scanner.nextDouble();
            double y1 = scanner.nextDouble();
            double z1 = scanner.nextDouble();
            first = new Vector(x1, y1, z1);

            System.out.println("Введите компоненты второго вектора (x y z):");
            double x2 = scanner.nextDouble();
            double y2 = scanner.nextDouble();
            double z2 = scanner.nextDouble();
            second = new Vector(x2, y2, z2);

            System.out.println("Длина первого вектора = " + first.len());
            System.out.println("Длина второго вектора = " + second.len());
            System.out.println("Скалярное произведение = " + first.scalarMultiplication(second));
            System.out.println("Косинус угла между векторами: " + first.findAngle(second));

        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода! Пожалуйста, введите числовые значения для компонентов вектора.");
        } catch (ArithmeticException e) {
            System.out.println("Арифметическая ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}