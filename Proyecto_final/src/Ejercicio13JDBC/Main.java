package Ejercicio13JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        update();
        incrementar_ventas();


    }
    public static void update(){
        Connection con;
        PreparedStatement sentencia;
        System.out.println("Introduce nueva ciudad: ");
        String nueva_ciudad = new Scanner(System.in).next();
        System.out.println("Introduce id de la oficina: ");
        int id = new Scanner(System.in).nextInt();
        String sql ="UPDATE oficina SET ciudad=? WHERE oficina=?";
        String url ="jdbc:mysql://localhost/empresa";

        try {
            con = DriverManager.getConnection(url, "root", "");
            sentencia=con.prepareStatement(sql);
            sentencia.setString(1, nueva_ciudad);
            sentencia.setInt(2, id);
            sentencia.executeUpdate();
            con.close();
            System.out.println("Ciudad actualizada correctamente");

        } catch (SQLException e) {
            System.out.println("Error al actualizar...");
        }

    }
    public static void incrementar_ventas(){
        Connection con;
        PreparedStatement sentencia;
        System.out.println("Introduce una oficina que quieras incrementar sus ventas: ");
        int una_oficina = new Scanner(System.in).nextInt();
        System.out.println("Introduce otra oficina que quieras incrementar sus ventas: ");
        int otra_oficina = new Scanner(System.in).nextInt();
        String sql ="SELECT * FROM oficina WHERE oficina=? OR oficina=?";
        String url ="jdbc:mysql://localhost/empresa";

        try {
            con = DriverManager.getConnection(url, "root", "");
            sentencia=con.prepareStatement(sql);
            sentencia.setInt(1, una_oficina);
            sentencia.setInt(2, otra_oficina);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()){
                int ofi = rs.getInt("oficina");
                String ciudad = rs.getString("ciudad");
                String superficie = rs.getString("superficie");
                int ventas = rs.getInt("ventas");
                for (int i=1; i<=2; i++){
                    ventas+=100;
                }
                actualizar_ventas(ventas, una_oficina, otra_oficina);

            }
            OficinaDAO.read();

        } catch (SQLException e) {
            System.out.println("Error al incrementar...");
        }

    }

    private static void actualizar_ventas(int ventas, int unaOficina, int otraOficina) {
        Connection con;
        PreparedStatement sentencia;
        String sql ="UPDATE oficina SET ventas=? WHERE oficina=? OR oficina=?";
        String url ="jdbc:mysql://localhost/empresa";

        try {
            con = DriverManager.getConnection(url, "root", "");
            sentencia=con.prepareStatement(sql);
            sentencia.setInt(1, ventas);
            sentencia.setInt(2, unaOficina);
            sentencia.setInt(3, otraOficina);
            sentencia.executeUpdate();
            con.close();
            System.out.println("Ventas actualizada correctamente");

        } catch (SQLException e) {
            System.out.println("Error al actualizar las ventas...");
        }
    }
}
