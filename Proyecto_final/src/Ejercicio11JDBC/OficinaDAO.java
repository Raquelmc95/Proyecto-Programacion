package Ejercicio11JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OficinaDAO {
    public static Connection conectar(){
        Connection con =null;
        String url ="jdbc:mysql://localhost/empresa";

        try {
            con= DriverManager.getConnection(url, "root", "");

        } catch (SQLException e) {
            System.out.println("Problemas con la conexion....");
        }
        return con;
    }

    public static void read(){
        List<Oficina> oficina = new ArrayList<>();
        Connection con = conectar();
        PreparedStatement sentencia;
        String sql = "SELECT * FROM oficina";

        try {
            sentencia=con.prepareStatement(sql);

            ResultSet rs = sentencia.executeQuery();

            while (rs.next()){
                int ofi = rs.getInt("oficina");
                String ciudad = rs.getString("ciudad");
                String superficie = rs.getString("superficie");
                int ventas = rs.getInt("ventas");
                oficina.add(new Oficina(ofi, ciudad, superficie, ventas));
            }
            System.out.println(oficina);

        } catch (SQLException e) {
            System.out.println("Problema en la consulta....");
        }

    }
}
