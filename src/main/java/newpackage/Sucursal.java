package newpackage;

import java.util.ArrayList;
import java.util.List;

public class Sucursal{
  // Atributos privados de la clase Sucursal
  private String nameSucursal;
  private String idSucursal;
  private String direccion;
  private String comuna;
  private String ciudad;
  private String region;
  private Ministerio ministerio;
  private ArrayList<Empleado> empleados;
   // Constructor de la clase Sucursal

  public Sucursal(String nameSucursal, String idSucursal, String direccion, String comuna, String ciudad, String region, Ministerio ministerio) {
    this.nameSucursal = nameSucursal;
    this.idSucursal = idSucursal;
    this.direccion = direccion;
    this.comuna = comuna;
    this.ciudad = ciudad;
    this.region = region;
    this.ministerio = ministerio;
    this.empleados = new ArrayList<>();
  }

  /*public void agregarEmpleado(Empleado empleado) {
      for (Empleado e : empleados) {
          if (e.getRut().equals(empleado.getRut())) {
              System.out.println("El empleado con RUT " + empleado.getRut() + " ya está en la sucursal.");
              return; 
          }
      }
    empleados.add(empleado);
    System.out.println("Empleado agregado a la sucursal: " + empleado.getNombre());
  }*/
  
  // Método para agregar un empleado a la sucursal
  public void agregarEmpleado(Empleado empleado){
      empleados.add(empleado);
  }
  // Método para obtener el número de empleados en la sucursal
  public int getSizeEmpleado(){
      System.out.println("tamaño arreglo empleados:" +empleados.size());
      return empleados.size();
  }
  
  
      public Empleado getEmpleado(int index){
        return this.empleados.get(index);
    }
    // Método para eliminar un empleado por su RUT
  public boolean eliminarEmpleado(String rut) {
    for (Empleado empleado : empleados) {
        if (empleado.getRut().equals(rut)) {
            empleados.remove(empleado);
            System.out.println("Empleado eliminado de la sucursal: " + empleado.getNombre());
            return true;
        }
    }
    return false;
  }
    // Método para listar todos los empleados de la sucursal
  public void listarEmpleados() {
    if (empleados.isEmpty()) {
        System.out.println("No hay empleados en la sucursal.");
    } else {
        System.out.println("Empleados en la sucursal " + nameSucursal + ":");
        for (Empleado empleado : empleados) {
            System.out.println("Empleado: " + empleado.getNombre() + ", RUT: " + empleado.getRut());
        }
    }
  }
  
  public void obtenerDatosEmpleado(String rut) {
    for (Empleado empleado : empleados) {
        if (empleado.getRut().equals(rut)) {
            mostrarDatosEmpleado(empleado);
            return;
        }
    }
    System.out.println("No se encontró ningún empleado con el RUT: " + rut);
  }
  public void obtenerDatosEmpleado(String nombre, String departamento) {
    for (Empleado empleado : empleados) {
        if (empleado.getNombre().equals(nombre)||empleado.getDepartamento().equals(departamento)) {
            mostrarDatosEmpleado(empleado);
            return;
        }
    }
    System.out.println("No se encontró ningún empleado con el Nombre: " + nombre + " o/y en el departamento: " + departamento);
  }
 // Método para listar todos los empleados de la sucursal
  private void mostrarDatosEmpleado(Empleado empleado) {
    System.out.println("\n===== Datos del Empleado =====");
    System.out.println("Nombre: " + empleado.getNombre());
    System.out.println("RUT: " + empleado.getRut());
    System.out.println("Fecha de Nacimiento: " + empleado.getFechaNaci());
    System.out.println("Fecha de Contrato: " + empleado.getFechaContrato());
    System.out.println("Cargo: " + empleado.getCargo());
    System.out.println("Salario: $" + empleado.getSalario());
    System.out.println("Departamento: " + empleado.getDepartamento());
    System.out.println("===============================");
  }
// Método para obtener y mostrar los datos de un empleado por su RUT
  public Empleado obtenerEmpleado(String rut) {
      for (Empleado empleado : empleados) {
          if (empleado.getRut().equals(rut)) {
              return empleado; 
          }
      }
      return null; 
  }
  
// Métodos getter y setter para los atributos de la clase
  public String getNameSucursal() {
    return nameSucursal;
  }
  public void setNameSucursal(String nameSucursal){
    this.nameSucursal = nameSucursal;
  }
  public String getIdSucursal(){
    return idSucursal;
  }
  public void setIdSucursal(String idSucursal){
    this.idSucursal = idSucursal;
  }

  public String getDireccion() {
    return direccion;
  }
  public void setDireccion(String direccion){
    this.direccion = direccion;
  }
  
  public String getComuna() {
    return comuna;
  }
  public void setComuna(String comuna){
    this.comuna = comuna;
  }

  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public Ministerio getMinisterio() {
    return ministerio;
  }

  public void setMinisterio(Ministerio ministerio) {
    this.ministerio = ministerio;
  }

  public List<Empleado> getEmpleados() {
    return empleados;
  }

// Método para obtener una lista de empleados ordenada por salario (de mayor a menor)
public List<Empleado> obtenerEmpleadosOrdenadosPorSalario() {
    List<Empleado> empleadosOrdenados = new ArrayList<>(empleados);
    empleadosOrdenados.sort((e1, e2) -> Double.compare(e2.getSalario(), e1.getSalario()));
    return empleadosOrdenados;
   }
}