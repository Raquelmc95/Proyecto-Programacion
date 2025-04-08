package Ejercicio09JDBC;

import java.sql.*;

public class Update {
    public static void update(int nueva_oficina, int anterior_oficina) {
        Connection con;
        PreparedStatement sentencia;
        String sql = "UPDATE empleados SET oficinas=? WHERE oficinas=?";
        String url = "jdbc:mysql://localhost/empresa";

        try {
            con = DriverManager.getConnection(url, "root", "");
            sentencia=con.prepareStatement(sql);
            System.out.println("Antes de la actualización");
            read(anterior_oficina);
            sentencia.setInt(1,nueva_oficina);
            sentencia.setInt(2, anterior_oficina);

            sentencia.executeUpdate();

            con.close();
            System.out.println("Empleados actualizados");
            read(nueva_oficina);

        } catch (
                SQLException e) {
            System.out.println("Error al actualizar a los empleados...");
        }
    }
    public static void read(int ofi){
        Connection con;
        PreparedStatement sentencia;
        String sql = "SELECT * FROM empleados WHERE oficinas=?";
        String url="jdbc:mysql://localhost/empresa";

        try {
            con = DriverManager.getConnection(url, "root", "");
            sentencia=con.prepareStatement(sql);
            sentencia.setInt(1,ofi);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()){
                int numemp = rs.getInt("numemp");
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                String puesto = rs.getString("puesto");
                Date contrato = rs.getDate("contrato");
                int oficinas = rs.getInt("oficinas");
                System.out.println("Nombre: "+nombre+"\n"+"Edad: "+edad+"\n"+"Puesot: "+puesto+"\n"+"Contrato: "+contrato+"\n"+"Oficina: "+oficinas);
                System.out.println("-----------------");
            }
        } catch (SQLException e) {
            System.out.println("Problema en la consulta...");
        }

    }
}
