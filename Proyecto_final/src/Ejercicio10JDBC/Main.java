package Ejercicio10JDBC;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Introduce el nº de empleado que quieres borrar: ");
        int numemp = new Scanner(System.in).nextInt();

        EmpleadoDAO.delete(numemp);
        EmpleadoDAO.read();

    }
}
