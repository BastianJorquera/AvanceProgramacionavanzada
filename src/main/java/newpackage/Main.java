package newpackage;

import com.opencsv.exceptions.CsvValidationException;
import java.util.Scanner;
import vistas.MenuEmpleados;

public class Main {
    //private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws CsvValidationException {
        // Inicializa el sistema llamando al método estático inicializarSistema de la clase Menu
        Menu.inicializarSistema();
        // Inicia el menú de empleados llamando al método iniciar de la clase MenuEmpleados
        MenuEmpleados.iniciar();
        //boolean continuar = true;
        //while (continuar) {
            //Menu.mostrarMenu();
            //int opcion = Menu.obtenerOpcion();
            //continuar = Menu.procesarOpcion(opcion);
        //}
        //scanner.close();
    }
}