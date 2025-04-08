package Ejercicio04JDBC;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection con;
        PreparedStatement sentencia;
        ResultSet rs;
        String sql;
        String url = "jdbc:mysql://localhost/empresa";

        try{
            con = DriverManager.getConnection(url, "root", "");

            sql="SELECT nombre, edad FROM empleados WHERE edad BETWEEN ? AND ?";
            sentencia=con.prepareStatement(sql);

            System.out.println("Introduce una edad minima: ");
            int min = new Scanner(System.in).nextInt();
            System.out.println("Introduce una edad maxima: ");
            int max = new Scanner(System.in).nextInt();

            sentencia.setInt(1, min);
            sentencia.setInt(2, max);

            rs= sentencia.executeQuery();

            while (rs.next()){
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                System.out.println("Nombre: "+nombre+"\t"+"Edad: "+edad);
            }
            con.close();


        } catch (SQLException e) {
            System.out.println("Error de conexion...");
        }
    }
}
