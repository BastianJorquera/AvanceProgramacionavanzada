package newpackage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Empleado {
   private String nombre;
   private String rut;
   private LocalDate fechaNaci;
   private LocalDate fechaContrato;
   private String cargo;
   private double salario;
   private String departamento;

   public Empleado(String nombre,String rut,LocalDate fechaNaci,LocalDate fechaContrato,String cargo,double salario,String departamento){
    this.nombre= nombre;
    this.rut= rut;
    this.fechaNaci= fechaNaci;
    this.fechaContrato= fechaContrato;
    this.cargo= cargo;
    this.salario = salario;
    this.departamento = departamento;
    }
       
    public String getNombre() {
        return nombre;
    }
    public String getRut() {
        return rut;
    }
    public LocalDate getFechaNaci() {
        return fechaNaci;
    }
    
    public LocalDate getFechaContrato() {
        return fechaContrato;
    }
    public String getCargo() {
        return cargo;
    }
    public double getSalario() {
         return salario;
    }
    public String getDepartamento() {
        return departamento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setRut(String rut) {
        this.rut = rut;
    }
    public void setFechaNaci(LocalDate fechaNaci) {
        this.fechaNaci = fechaNaci;
    }
    public void setFechaContrato(LocalDate fechaContrato) {
        this.fechaContrato = fechaContrato;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public void setSalario(double salario) {
             this.salario = salario;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    
    public void transferirDepartamento(String nuevoDepartamento) {
             String antiguoDepartamento = this.departamento;
             this.departamento = nuevoDepartamento;
             System.out.println("Empleado " + this.nombre + " transferido del departamento " + antiguoDepartamento + " al departamento " + nuevoDepartamento);
         }
    public void leerEmpleado(){
        System.out.println("Nombre: " + nombre + " ||  Rut: " + rut + " ||  Fecha de Nacimiento: " + fechaNaci);
    }
}
