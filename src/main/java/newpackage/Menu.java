package newpackage;


import com.opencsv.exceptions.CsvValidationException;
import controlador.Reporte;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu{
  private static Scanner scanner = new Scanner(System.in);
  public static final String path ="src\\main\\resources\\empleados.csv";
  private static Sucursal sucursal;
  private static Reporte reporte;

  
  // Método para inicializar el sistema
  public static void inicializarSistema() throws CsvValidationException {
      
      LocalDate fechaCrea = LocalDate.of(2020, 3, 12);
      // Crear una instancia de Ministerio
      Ministerio ministerio = new Ministerio("Ministerio de Ejemplo","Id2013k", fechaCrea);
      
      // Crear una instancia de Sucursal
      sucursal = new Sucursal("Sucursal Central", "001", "Av. Principal 123", "Comuna Ejemplo", "Ciudad Ejemplo", "Región Ejemplo", ministerio);
      
      System.out.println("Cargando datos...");
      
      // Crear una instancia de Reporte
      reporte= new Reporte(path);
      // Leer los datos del archivo CSV
      leerReporte(sucursal);
      
      System.out.println("Sistema inicializado con éxito.");
      
  }
        // Método para agregar un nuevo empleado
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
    
    // Método para obtener el número de empleados
    public static int getSizeEmpleados(){
        return sucursal.getSizeEmpleado();
    }
    
    // Método para obtener un empleado por su índice
    public static Empleado getEmpleados(int index){
        return sucursal.getEmpleado(index);
    }
    
    // Método para convertir una fecha LocalDate a String
    public static String obtenerFechaCadena(LocalDate fecha){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaNacim = fecha.format(formatter);
        return fechaNacim;
    }
    
    // Métodos para obtener información específica de un empleado por su rut
    public static Empleado getEmpleadoPorRut(String rut){
        return sucursal.obtenerEmpleado(rut);
    }
    
    // Métodos para obtener información específica de un empleado por su índice
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