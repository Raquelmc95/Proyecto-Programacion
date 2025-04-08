package Ejercicio03JDBC;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Introduce la ciudad que quieres que te mostremos las oficinas: ");
        String ciudad = new Scanner(System.in).next().toLowerCase();

        Oficina.read(ciudad);
    }
}
