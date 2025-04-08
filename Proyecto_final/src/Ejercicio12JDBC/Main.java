package Ejercicio12JDBC;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Introduce la superficie a partir de la cual quieres que se muestren las oficinas: ");
        String superficie = new Scanner(System.in).next();
        OficinaDAO.read(superficie);
    }
}
