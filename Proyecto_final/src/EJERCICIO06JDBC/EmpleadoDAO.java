package Ejercicio06JDBC;

import java.sql.*;

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
    public static void create(Empleado empleado){
        Connection con = conexion();
        PreparedStatement sentencia;
        String sql = "INSERT INTO empleados (numemp, nombre, edad, puesto, contrato, oficinas) VALUES(?,?,?,?,?,?)";

        try {
            sentencia=con.prepareStatement(sql);
            sentencia.setInt(1,empleado.getNumemp());
            sentencia.setString(2,empleado.getNombre());
            sentencia.setInt(3,empleado.getEdad());
            sentencia.setString(4,empleado.getPuesto());
            sentencia.setDate(5,new java.sql.Date(empleado.getContrato().getTime()));
            sentencia.setInt(6,empleado.getOficinas());

            sentencia.executeUpdate();
            System.out.println("Empleado insertado");
            con.close();

        } catch (SQLException e) {
            System.out.println("Problemas al insertar....");
        }
    }
}
