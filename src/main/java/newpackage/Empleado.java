package newpackage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/* 
   Clase que representa al empleado 
*/
public class Empleado {
   private String nombre;
   private String rut;
   private LocalDate fechaNaci;
   private LocalDate fechaContrato;
   private String cargo;
   private double salario;
   private String departamento;

   //Contructor de la clase Empleado
   
   public Empleado(String nombre,String rut,LocalDate fechaNaci,LocalDate fechaContrato,String cargo,double salario,String departamento){
    this.nombre= nombre;
    this.rut= rut;
    this.fechaNaci= fechaNaci;
    this.fechaContrato= fechaContrato;
    this.cargo= cargo;
    this.salario = salario;
    this.departamento = departamento;
    }
    //Metodos Getter para acceder a los atributos privados
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
    // Métodos setter para modificar los atributos privados
    
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
    
    /*
     Transfiere al empleado a un nuevo departamento y muestra un mensaje.
     
    */
    
    public void transferirDepartamento(String nuevoDepartamento) {
             String antiguoDepartamento = this.departamento;
             this.departamento = nuevoDepartamento;
             System.out.println("Empleado " + this.nombre + " transferido del departamento " + antiguoDepartamento + " al departamento " + nuevoDepartamento);
         }
    /*
     Muestra la información básica del empleado.
    */
    
    // Imprime el nombre, RUT y fecha de nacimiento del empleado
    public void leerEmpleado(){
        System.out.println("Nombre: " + nombre + " ||  Rut: " + rut + " ||  Fecha de Nacimiento: " + fechaNaci);
    }
}
