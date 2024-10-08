package newpackage;

import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import controlador.Reporte;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu{
  private static Scanner scanner = new Scanner(System.in);
  public static final String path ="src\\main\\resources\\empleados.csv";
  private static Sucursal sucursal;
  private static Reporte reporte;

  public static void inicializarSistema() throws CsvValidationException {
      
      LocalDate fechaCrea = LocalDate.of(2020, 3, 12);
      Ministerio ministerio = new Ministerio("Ministerio de Ejemplo","Id2013k", fechaCrea);
      sucursal = new Sucursal("Sucursal Central", "001", "Av. Principal 123", "Comuna Ejemplo", "Ciudad Ejemplo", "Región Ejemplo", ministerio);
      System.out.println("Cargando datos...");
      reporte= new Reporte(path);
      leerReporte(sucursal);
      System.out.println("Sistema inicializado con éxito.");
      
  }
        //al tener la verificacion en la clase Reporte, no la necesito en la clase sucursal, pasa directamente a guardarse en el array
        //pero si necesito un boolean para retornar al jFrame de AgregarEmpleado
    public static boolean agregarRegistro(Empleado a){
        if(reporte.EscribirCSV(sucursal, a)){
          sucursal.agregarEmpleado(a);
          return true;
      }
      return false;
    }
    
    public static void ActualizarCSVEmpleados(){
        reporte.actualizarCSV(sucursal);
    }
    
    public static ArrayList<Empleado> getEmpleadosSucursal() {
        return sucursal.getListaEmpleados();  // Suponiendo que Sucursal tiene este método
    }   
    
    public static int getSizeEmpleados(){
        return sucursal.getSizeEmpleado();
    }
    
    public static Empleado getEmpleados(int index){
        return sucursal.getEmpleado(index);
    }
    
    public static String obtenerFechaCadena(LocalDate fecha){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaNacim = fecha.format(formatter);
        return fechaNacim;
    }
    
    public static Empleado getEmpleadoPorRut(String rut){
        return sucursal.obtenerEmpleado(rut);
    }
    
    public static String getNombreEmpleado(int index){
        return sucursal.getEmpleado(index).getNombre();
    }
    
    public static String getRutEmpleado(int index){
        return sucursal.getEmpleado(index).getRut();
    }
        
    public static String getMinisterioEmpleado(int index){
        return sucursal.getEmpleado(index).getDepartamento();
    }
            
    public static String getCargoEmpleado(int index){
        return sucursal.getEmpleado(index).getCargo();
    }   
    
        public static void leerReporte(Sucursal sucursal) throws CsvValidationException{
        reporte.Leer(sucursal);     
        System.out.println("Empleados registrados: ");
        for(int i=0;i<sucursal.getSizeEmpleado();i++){
            sucursal.getEmpleado(i).leerEmpleado();
        }
    }
        


  
  /*public static void mostrarMenu() {
      System.out.println("\n===== Menú Principal =====");
      System.out.println("1. Ingresar datos de empleado");
      System.out.println("2. Leer datos de empleados");
      System.out.println("3. Buscar empleado");
      System.out.println("4. Modificar datos de empleado");
      System.out.println("5. Eliminar datos de empleado");
      System.out.println("6. Salir");
      System.out.print("Seleccione una opción: ");
  }

  public static int obtenerOpcion() {
      while (true) {
          try {
              return Integer.parseInt(scanner.nextLine());
          } catch (NumberFormatException e) {
              System.out.print("Por favor, ingrese un número válido: ");
          }
      }
  }

  public static boolean procesarOpcion(int opcion) {
      switch (opcion) {
          case 1:
              ingresarDatosEmpleado();
              break;
          case 2:
              sucursal.listarEmpleados();
              break;
          case 3:
              buscarEmpleado();
              break;
          case 4:
              modificarDatosEmpleado();
              break;
          case 5:
              eliminarEmpleado();
              break;
          case 6:
              System.out.println("Gracias por usar el sistema. ¡Hasta luego!");
              return false;
          default:
              System.out.println("Opción no válida. Inténtelo de nuevo.");
      }
      return true;
  }

  public static void ingresarDatosEmpleado() {
      String nombreEmpleado = obtenerDato("Ingrese el nombre del empleado: ");
      String rutEmpleado = obtenerDato("Ingrese el RUT del empleado (formato XX.XXX.XXX-X): ");
      LocalDate fechaNaciEmpleado = obtenerFecha("Ingrese la fecha de nacimiento del empleado (YYYY-MM-DD): ");
      LocalDate fechaContratoEmpleado = obtenerFecha("Ingrese la fecha de contrato del empleado (YYYY-MM-DD): ");
      String cargoEmpleado = obtenerDato("Ingrese el cargo del empleado: ");
      double salarioEmpleado = obtenerSalario("Ingrese el salario del empleado: ");
      String departamentoEmpleado = obtenerDato("Ingrese el departamento del empleado: ");

      Empleado empleado = new Empleado(nombreEmpleado, rutEmpleado, fechaNaciEmpleado, fechaContratoEmpleado, cargoEmpleado, salarioEmpleado, departamentoEmpleado);
      sucursal.agregarEmpleado(empleado);
  }*/
  
  //crear funcion para agregar empleado a

  /*public static void buscarEmpleado() {
      boolean continuar = true;
      System.out.print("\nElija el método de búsqueda que más le favorezca: ");
      System.out.println("\n1. Buscar empleado mediante RUT");
      System.out.println("2. Buscar empleado mediante su Nombre y su Departamento");

      while (continuar) {
          System.out.print("\nSeleccione una opción: ");
          int opcionDos = obtenerOpcion();
          continuar = procesarOpcionDos(opcionDos);
      }
  }

  public static boolean procesarOpcionDos(int opcionDos) {
      switch (opcionDos) {
          case 1:
              String rutBuscar = obtenerDato("Ingrese el RUT del empleado a buscar: ");
              sucursal.obtenerDatosEmpleado(rutBuscar);
              return false;
          case 2:
              String nombreBuscar = obtenerDato("Ingrese el nombre del empleado a buscar:");
              String departamento = obtenerDato("Ingrese el departamento del empleado a buscar:");
              sucursal.obtenerDatosEmpleado(nombreBuscar, departamento);
              return false;
          default:
              System.out.println("Opción no válida. Inténtelo de nuevo.");
              return true;
      }
  }

  public static void modificarDatosEmpleado() {
      String rut = obtenerDato("Ingrese el RUT del empleado a modificar: ");
      Empleado empleado = sucursal.obtenerEmpleado(rut);  
      if (empleado != null) {
          System.out.println("Empleado encontrado. Ingrese los nuevos datos (deje en blanco para no modificar):");

          String nuevoNombre = obtenerDatoOpcional("Nuevo nombre (" + empleado.getNombre() + "): ");
          if (!nuevoNombre.isEmpty()) empleado.setNombre(nuevoNombre);

          String nuevoCargo = obtenerDatoOpcional("Nuevo cargo (" + empleado.getCargo() + "): ");
          if (!nuevoCargo.isEmpty()) empleado.setCargo(nuevoCargo);

          double nuevoSalario = obtenerSalarioOpcional("Nuevo salario (" + empleado.getSalario() + "): ");
          if (nuevoSalario != -1) empleado.setSalario(nuevoSalario);

          String nuevoDepartamento = obtenerDatoOpcional("Nuevo departamento (" + empleado.getDepartamento() + "): ");
          if (!nuevoDepartamento.isEmpty()) empleado.setDepartamento(nuevoDepartamento);

          System.out.println("Datos del empleado actualizados con éxito.");
      } else {
          System.out.println("No se encontró ningún empleado con el RUT proporcionado.");
      }
  }*/


  
    public static Empleado eliminarEmpleado(String rut){
        Empleado empleadoEliminado;
        return empleadoEliminado= sucursal.eliminarGetEmpleado(rut);
    }

    public static String obtenerDato(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public static String obtenerDatoOpcional(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public static LocalDate obtenerFecha(String mensaje) {
        LocalDate fecha = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            fecha = LocalDate.parse(mensaje, formatter);  // Intenta parsear
        } catch (DateTimeParseException e) {
            System.out.println("Fecha inválida. Asegúrate de usar el formato YYYY-MM-DD.");
        }
        
        return fecha;  // Retorna null si la fecha es inválida
    }

  public static double obtenerSalario(String mensaje) {
      while (true) {
          try {
              System.out.print(mensaje);
              return Double.parseDouble(scanner.nextLine());
          } catch (NumberFormatException e) {
              System.out.println("Por favor, ingrese un número válido para el salario.");
          }
      }
  }

  public static double obtenerSalarioOpcional(String mensaje) {
      String input = obtenerDatoOpcional(mensaje);
      if (input.isEmpty()) {
          return -1; 
      }
      try {
          return Double.parseDouble(input);
      } catch (NumberFormatException e) {
          System.out.println("Valor no válido. El salario no se modificará.");
          return -1;
      }
  }
}