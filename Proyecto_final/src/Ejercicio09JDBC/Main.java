package Ejercicio09JDBC;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Nueva oficina");
        int nueva_oficina = new Scanner(System.in).nextInt();
        System.out.println("Anterior oficina");
        int anterior_oficina = new Scanner(System.in).nextInt();

        Update.update(nueva_oficina, anterior_oficina);
    }


}
