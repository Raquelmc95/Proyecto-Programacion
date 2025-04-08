package Ejercicio06JDBC;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date contrato = f.parse("2025-10-10");
        Empleado empleado = new Empleado(12,"Gonzalo", 20, "Desarrollador", contrato, 1);

        EmpleadoDAO.create(empleado);
    }
}
