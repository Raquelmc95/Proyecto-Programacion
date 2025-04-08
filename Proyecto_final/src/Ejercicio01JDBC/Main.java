package Ejercicio01JDBC;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection con;
        Statement sentencia;
        ResultSet rs;
        String sql;
        String url ="jdbc:mysql://localhost/empresa";

        try{
            con= DriverManager.getConnection(url, "root", "");
            sentencia= con.createStatement();
            sql ="SELECT * FROM empleados";
            rs = sentencia.executeQuery(sql);
            System.out.println("Lista de empleados: ");
            while (rs.next()){
                int numemp = rs.getInt("numemp");
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                String puesto = rs.getString("puesto");
                Date contrato = rs.getDate("contrato");
                int oficina = rs.getInt("oficinas");
                System.out.println("Nº empleado: "+numemp+"\n"+
                "Nombre: "+nombre+"\n"+
                "Edad: "+edad+"\n"+
                "Puesto: "+puesto+"\n"+
                "Contrato: "+contrato+"\n"+
                "Oficina: "+oficina);
                System.out.println("--------------");
            }
            con.close();

        } catch (SQLException e) {
            System.out.println("Problemas con la conexion..");
        }
    }
}
