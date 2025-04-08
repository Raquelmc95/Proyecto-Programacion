package Ejercicio03JDBC;

import java.sql.*;

public class Oficina {
    int oficina;
    String ciudad;
    String superficie;
    int ventas;

    public Oficina(int oficina, String ciudad, String superficie, int ventas){
        this.oficina=oficina;
        this.ciudad=ciudad;
        this.superficie=superficie;
        this.ventas=ventas;
    }
    public static void read(String c){
        Oficina lista=null;
        Connection con;
        Statement sentencia;
        ResultSet rs;
        String sql;
        String url="jdbc:mysql://localhost/empresa";

        try{
            con= DriverManager.getConnection(url, "root", "");
            sentencia=con.createStatement();
            sql="SELECT * FROM oficina WHERE UPPER(ciudad)='"+c+"'";
            rs= sentencia.executeQuery(sql);
            while (rs.next()){
                int oficina = rs.getInt("oficina");
                String ciudad = rs.getString("ciudad");
                String superficie = rs.getString("superficie");
                int ventas = rs.getInt("ventas");
                lista= new Oficina(oficina,ciudad,superficie,ventas);
                System.out.println(lista);
            }

        } catch (SQLException e) {
            System.out.println("Problemas con la conexion..");
        }
    }
    
    @Override
    public String toString(){
        return "Oficina: "+oficina+"\n"+"Ciudad: "+ciudad+"\n"+"Superficie: "+superficie+"\n"+"Ventas: "+ventas;
    }
}
