package Ejercicio07JDBC;

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
        boolean existe = read(empleado.getNumemp());
        if (!existe) {
            try {
                Connection con = conexion();
                PreparedStatement sentencia;
                String sql = "INSERT INTO empleados (numemp, nombre, edad, puesto, contrato, oficinas) VALUES(?,?,?,?,?,?)";
                sentencia = con.prepareStatement(sql);
                sentencia.setInt(1, empleado.getNumemp());
                sentencia.setString(2, empleado.getNombre());
                sentencia.setInt(3, empleado.getEdad());
                sentencia.setString(4, empleado.getPuesto());
                sentencia.setDate(5, new Date(empleado.getContrato().getTime()));
                sentencia.setInt(6, empleado.getOficinas());

                sentencia.executeUpdate();
                System.out.println("Empleado insertado");
                con.close();

            } catch (SQLException e) {
                System.out.println("Problemas al insertar....");
            }
        }else {
            System.out.println("El empleado con ese numemp ya existe en la BBDD");
        }
    }
    public static boolean read(int numemp) {
        Connection con = conexion();
        PreparedStatement sentencia;
        String sql = "SELECT * FROM empleados WHERE numemp=?";
        boolean existe = false;

        try {
            sentencia = con.prepareStatement(sql);

            sentencia.setInt(1, numemp);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("numemp");
                if (id == numemp) {
                    existe = true;
                    return existe;
                }
            }


        } catch (SQLException e) {
            System.out.println("Problemas en la consulta...");
        }
        return existe;

    }
}
