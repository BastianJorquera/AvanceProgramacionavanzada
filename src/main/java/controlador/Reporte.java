
package controlador;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import newpackage.Empleado;
import static newpackage.Menu.obtenerFecha;
import newpackage.Sucursal;

/**
 *
 * @author bajog
 */
public class Reporte {
    // Atributo que almacena la ruta del archivo CSV
    private final String path;
    
    //Constructor
    public Reporte(String path) {
        this.path = path;
    }
    
    
    // Método para leer datos del archivo CSV y agregarlos a la Sucursal
    public void Leer(Sucursal empleados) throws CsvValidationException{
        File file = new File(this.path);
        
        try{
            FileReader inputFile = new FileReader(file);
             // Configurar el parser CSV para usar punto y coma como separador
            CSVParser parser = new CSVParserBuilder()
                                    .withSeparator(';')
                                    .build();
            
             // Construir el lector CSV
            CSVReader csvReader = new CSVReaderBuilder(inputFile)
                                                .withCSVParser(parser)
                                                .build();
            
            String[] datos;
            System.out.println("leyendo csv");
            int i=0; //Primer linea es un header, por lo que se salta
            while((datos = csvReader.readNext())!= null){
                if(i>0){
                    Empleado empleado = new Empleado(datos[0],datos[1],obtenerFecha(datos[2]),obtenerFecha(datos[3]), datos[4], Double.parseDouble(datos[5]), datos[6]);
                    empleados.agregarEmpleado(empleado);
                }
                i++;
            }      
            System.out.println("Datos cargados desde csv");
            csvReader.close();
            inputFile.close();
        }catch(IOException e){
            System.out.print("Hola, esto es un error");
            e.printStackTrace();
        }catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }finally{
            System.out.println("Programa corriendo...");
        }
    }
    
    // Método para escribir un nuevo registro en el archivo CSV
   public boolean Escribir(String[] registro, Sucursal empleados) {
    File file = new File(this.path);
    try {
        FileWriter outputFile = new FileWriter(file, true);
        CSVWriter csvWriter = new CSVWriter(outputFile, ';',
                                 CSVWriter.NO_QUOTE_CHARACTER,
                                 CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                                 "\n");
        
        // Verificar si el empleado ya existe
        if(usuarioYaExistente(registro[1], empleados)){
            return false;
        }
        // Crear un nuevo empleado y agregarlo a la sucursal
        Empleado empleado = new Empleado(registro[0],registro[1],obtenerFecha(registro[2]),obtenerFecha(registro[3]), registro[4], Double.parseDouble(registro[5]), registro[6]);
        empleados.agregarEmpleado(empleado);
        csvWriter.writeNext(registro);
        
        outputFile.close();
        System.out.println("Nuevo registro añadido exitosamente.");
    } catch(IOException e) {
        System.out.print("Error al escribir en el archivo: ");
        e.printStackTrace();
    } finally {
        System.out.println("Operación de escritura completada.");
    }
    return true;
    }

   
   public boolean EscribirCSV(Sucursal empleado, Empleado u ){
       File file = new File(this.path);
    try {
        FileWriter outputFile = new FileWriter(file, true);
        CSVWriter csvWriter = new CSVWriter(outputFile, ';',
                                 CSVWriter.NO_QUOTE_CHARACTER,
                                 CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                                 "\n");
        
        if(usuarioYaExistente(u.getRut(), empleado)){
            return false;
        }
        
        String[] registro = {u.getNombre(),u.getRut(), obtenerFechaCadena(u.getFechaNaci()), obtenerFechaCadena(u.getFechaContrato()), u.getCargo(), Double.toString(u.getSalario()), u.getDepartamento()};
        csvWriter.writeNext(registro);
        
        outputFile.close();
        System.out.println("Registro añadido exitosamente.");
    } catch(IOException e) {
        System.out.print("Error al escribir en el archivo: ");
        e.printStackTrace();
    } finally {
        System.out.println("Operación de escritura completada.");
    }
    return true;
   }
    
   
   private boolean usuarioYaExistente(String rut, Sucursal empleados){
       
       if(empleados.obtenerEmpleado(rut)!=null){
           return true;
       }
          return false;
   }
   
       public void actualizarCSV(Sucursal sucursal) {
           ArrayList<Empleado> listaEmpleados = sucursal.getListaEmpleados();
           if (listaEmpleados == null) {
           System.out.println("Error: La lista de empleados es nula.");
           return;}
        try {
            // Abrir el archivo en modo de escritura, eliminando el contenido existente
            FileWriter outputFile = new FileWriter(this.path, false);  // 'false' indica que no se debe hacer append, se sobrescribe

            // Crear el escritor CSV con el separador de campos
            CSVWriter csvWriter = new CSVWriter(outputFile, ';', 
                                                CSVWriter.NO_QUOTE_CHARACTER, 
                                                CSVWriter.DEFAULT_ESCAPE_CHARACTER, 
                                                CSVWriter.DEFAULT_LINE_END);

            // Escribir una fila vacía al inicio para usarla como índice
            String[] filaVacia = { "", "", "", "", "", "", "" }; // Número de columnas según tu CSV
            csvWriter.writeNext(filaVacia);

            // Escribir los datos del ArrayList en el CSV
            for (Empleado empleado : listaEmpleados) {
                String[] registro = {
                    empleado.getNombre(),
                    empleado.getRut(),
                    obtenerFechaCadena(empleado.getFechaNaci()),
                    obtenerFechaCadena(empleado.getFechaContrato()),
                    empleado.getCargo(),
                    Double.toString(empleado.getSalario()),
                    empleado.getDepartamento()
                };
                csvWriter.writeNext(registro);
            }

            // Cerrar el escritor CSV y el archivo
            csvWriter.close();
            outputFile.close();
            
            System.out.println("Archivo CSV actualizado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al sobrescribir el archivo CSV.");
            e.printStackTrace();
        }
    }

    // Método para formatear fechas en cadena (similar al que usaste antes)
    public static String obtenerFechaCadena(LocalDate fecha) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return fecha.format(formatter);
    }
   
}

