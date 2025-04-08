package Ejercicio05JDBC;

import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection con;
        PreparedStatement sentencia;
        String sql;
        String url = "jdbc:mysql://localhost/empresa";

        try{
            con = DriverManager.getConnection(url,"root", "");


            System.out.println("Nº empleado: ");
            int numemp = new Scanner(System.in).nextInt();
            System.out.println("Nombre: ");
            String nombre = new Scanner(System.in).next();
            System.out.println("Edad: ");
            int edad = new Scanner(System.in).nextInt();
            System.out.println("Puesto: ");
            String puesto = new Scanner(System.in).next();
            System.out.println("Nº oficina: ");
            int oficina = new Scanner(System.in).nextInt();
            Date contrato = Date.valueOf(LocalDate.now());

            sql="INSERT INTO empleados (numemp, nombre, edad, puesto, contrato, oficinas) VALUES (?,?,?,?,?,?)";
            sentencia=con.prepareStatement(sql);
            sentencia.setInt(1, numemp);
            sentencia.setString(2, nombre);
            sentencia.setInt(3,edad);
            sentencia.setString(4,puesto);
            sentencia.setDate(5, contrato);
            sentencia.setInt(6, oficina);

            sentencia.executeUpdate();
            System.out.println("Empleado creado....");
            con.close();
            System.out.println("Registro añadido....");


        } catch (SQLException e) {
            System.out.println("Error al insertar.....");
        }
    }
}
