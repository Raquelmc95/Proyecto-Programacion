package Ejercicio08JDBC;

public class Main {
    public static void main(String[] args) {
        Oficina oficina = new Oficina(1,"Malaga", "300", 2020);
        OficinaDAO.create(oficina);
    }
}
