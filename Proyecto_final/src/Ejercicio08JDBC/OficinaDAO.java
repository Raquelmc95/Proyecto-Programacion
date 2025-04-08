package Ejercicio08JDBC;

import java.net.ConnectException;
import java.sql.*;

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
    public static void create(Oficina oficina){
        boolean existe = read(oficina.getOficina());
        if(!existe) {
            try {
                Connection con = conectar();
                PreparedStatement sentencia;
                String sql = "INSERT INTO oficina (oficina, ciudad, superficie, venta) VALUES (?,?,?,?)";
                sentencia = con.prepareStatement(sql);

                sentencia.setInt(1, oficina.getOficina());
                sentencia.setString(2, oficina.getCiudad());
                sentencia.setString(3, oficina.getSuperficie());
                sentencia.setInt(4, oficina.getVentas());

                sentencia.executeUpdate();

                System.out.println("Oficina añadida....");
            } catch (SQLException e) {
                System.out.println("Problemas al insertar");
            }
        }else {
            System.out.println("La oficina ya existe en la BBDD");
        }
    }
    public static boolean read(int oficina){
        Connection con = conectar();
        PreparedStatement sentencia;
        String sql = "SELECT * FROM oficina WHERE oficina=?";
        boolean existe = false;

        try {
            sentencia=con.prepareStatement(sql);

            sentencia.setInt(1,oficina);

            ResultSet rs = sentencia.executeQuery();

            while (rs.next()){
                int ofi = rs.getInt("oficina");
                if (ofi==oficina){
                    existe=true;
                    return existe;
                }
            }
        } catch (SQLException e) {
            System.out.println("Problema en la consulta....");
        }
        return existe;
    }
}
