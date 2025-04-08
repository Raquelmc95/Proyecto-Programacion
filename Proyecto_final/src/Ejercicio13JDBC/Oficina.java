package Ejercicio13JDBC;

public class Oficina {
    private int oficina;
    private String ciudad;
    private String superficie;
    private int ventas;

    public Oficina(int oficina, String ciudad, String superficie, int ventas){
        this.oficina=oficina;
        this.ciudad=ciudad;
        this.superficie=superficie;
        this.ventas=ventas;
    }
    public int getOficina(){
        return oficina;
    }
    public String getCiudad(){
        return ciudad;
    }
    public String getSuperficie(){
        return superficie;
    }
    public int getVentas(){
        return ventas;
    }
    public void setOficina(int nuevo){
        this.oficina=nuevo;
    }
    public void setCiudad(String nuevo){
        this.ciudad=nuevo;
    }
    public void setSuperficie(String nuevo){
        this.superficie=nuevo;
    }
    public void setVentas(int nuevo){
        this.ventas=nuevo;
    }

    @Override
    public String toString(){
        return "Oficina {Oficina= "+oficina+", Ciudad= "+ciudad+", Superficie= "+superficie+", Ventas= "+ventas+"}\n";
    }
}
