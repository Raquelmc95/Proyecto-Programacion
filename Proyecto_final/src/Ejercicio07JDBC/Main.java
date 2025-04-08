package Ejercicio07JDBC;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date contrato = f.parse("2025-09-10");
        Empleado empleado = new Empleado(10,"pepe",26, "Conserje", contrato, 3 );
        EmpleadoDAO.create(empleado);

    }
}
