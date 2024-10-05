
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
import java.util.ArrayList;
import newpackage.Empleado;
import static newpackage.Menu.obtenerFecha;
import static newpackage.Menu.obtenerFechaCadena;
import newpackage.Sucursal;

/**
 *
 * @author bajog
 */
public class Reporte {
    //Atributos
    private final String path;
    private final ArrayList<Empleado> listaEmpleados;
    
    //Constructor
    public Reporte(String path) {
        this.path = path;
        this.listaEmpleados = new ArrayList<>();
    }
    
    //Getters y Setters

    public Empleado getEmpleado(int index){
        return this.listaEmpleados.get(index);
    }
    
    public int getSizeEmpleado(){
        return this.listaEmpleados.size();
    }
    
    
    //Metodos
    public void Leer() throws CsvValidationException{
        File file = new File(this.path);
        try{
            FileReader inputFile = new FileReader(file);
            CSVParser parser = new CSVParserBuilder()
                                    .withSeparator(';')
                                    .build();
            
            CSVReader csvReader = new CSVReaderBuilder(inputFile)
                                                .withCSVParser(parser)
                                                .build();
            
            String[] datos;
            int i=0; //Primer linea es un header, por lo que se salta
            while((datos = csvReader.readNext())!= null){
                if(i>0){
                    Empleado empleado = new Empleado(datos[0],datos[1],obtenerFecha(datos[2]),obtenerFecha(datos[3]), datos[4], Double.parseDouble(datos[5]), datos[6]);
                    listaEmpleados.add(empleado);
                }
                i++;
            }      
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
    
   public boolean Escribir(String[] registro) {
    File file = new File(this.path);
    try {
        FileWriter outputFile = new FileWriter(file, true);
        CSVWriter csvWriter = new CSVWriter(outputFile, ';',
                                 CSVWriter.NO_QUOTE_CHARACTER,
                                 CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                                 "\n");
        
        if(usuarioYaExistente(registro[0])){
            return false;
        }
        Empleado empleado = new Empleado(registro[0],registro[1],obtenerFecha(registro[2]),obtenerFecha(registro[3]), registro[4], Double.parseDouble(registro[5]), registro[6]);
        listaEmpleados.add(empleado);
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

   
   public boolean Escribir(Sucursal empleado, Empleado u) {
    File file = new File(this.path);
    try {
        FileWriter outputFile = new FileWriter(file, true);
        CSVWriter csvWriter = new CSVWriter(outputFile, ';',
                                 CSVWriter.NO_QUOTE_CHARACTER,
                                 CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                                 "\n");
        
        if(usuarioYaExistente(u.getRut())){
            return false;
        }
        empleado.agregarEmpleado(u);
        String[] registro = {u.getNombre(),u.getRut(), obtenerFechaCadena(u.getFechaNaci()), obtenerFechaCadena(u.getFechaContrato()), u.getCargo(), Double.toString(u.getSalario()), u.getDepartamento()};
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
    
   
   private boolean usuarioYaExistente(String rut){
       
       for(Empleado u : this.listaEmpleados){
           if(u.getRut().equals(rut)){
               System.out.println("Usuario ya existente");
               return true;
           }
       }
       return false;
   }
}
