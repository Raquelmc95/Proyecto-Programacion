package Ejercicio10JDBC;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Empleado {
    private int numemp;
    private String nombre;
    private int edad;
    private String puesto;
    private Date contrato;
    private int oficinas;

    public Empleado(int numemp, String nombre, int edad, String puesto, Date contrato, int oficinas){
        this.numemp=numemp;
        this.nombre=nombre;
        this.edad=edad;
        this.puesto=puesto;
        this.contrato=contrato;
        this.oficinas=oficinas;
    }

    public int getNumemp(){
        return numemp;
    }
    public String getNombre(){
        return nombre;
    }
    public int getEdad(){
        return edad;
    }
    public String getPuesto(){
        return puesto;
    }
    public Date getContrato(){
        return contrato;
    }
    public int getOficinas(){
        return oficinas;
    }
    public void setNumemp(int nuevo){
        this.numemp=nuevo;
    }
    public void setNombre(String nuevo){
        this.nombre=nuevo;
    }
    public void setEdad(int nuevo){
        this.edad=nuevo;
    }
    public void setPuesto(String nuevo){
        this.puesto=nuevo;
    }
    public void setContrato(Date nuevo){
        this.contrato=nuevo;
    }
    public void setOficinas(int nuevo){
        this.oficinas=nuevo;
    }

    @Override
    public String toString(){
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        return "Empleado: {Nº Emp= "+numemp+", Nombre= "+nombre+", Edad= "+edad+", Puesto= "+puesto+", Contrato= "+f.format(contrato)+", Oficina="+oficinas+"}\n";
    }
}
