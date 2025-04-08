package Ejercicio10JDBC;

import Ejercicio07JDBC.Empleado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {
    private static Connection conexion(){
        Connection con=null;
        String url="jdbc:mysql://localhost/empresa";

        try {
            con= DriverManager.getConnection(url,"root","");


        } catch (SQLException e) {
            System.out.println("Problemas de conexion...");
        }
        return con;
    }
    public static void read() {
        List<Empleado> emppleado = new ArrayList<>();
        Connection con = conexion();
        PreparedStatement sentencia;
        String sql = "SELECT * FROM empleados";


        try {
            sentencia = con.prepareStatement(sql);

            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("numemp");
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                String puesto = rs.getString("puesto");
                Date contrato = rs.getDate("contrato");
                int oficinas = rs.getInt("oficinas");

                emppleado.add(new Empleado(id,nombre,edad, puesto,contrato, oficinas));

            }
            System.out.println(emppleado);


        } catch (SQLException e) {
            System.out.println("Problemas en la consulta...");
        }

    }
    public static void delete(int nuemp){

        PreparedStatement sentencia;
        String sql="DELETE FROM empleados WHERE numemp=?";

        try {
            Connection con = conexion();
            sentencia=con.prepareStatement(sql);
            sentencia.setInt(1,nuemp);
            sentencia.executeUpdate();
            con.close();
            System.out.println("Empleado eliminado");

        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error al eliminar...");
        }
    }
}
