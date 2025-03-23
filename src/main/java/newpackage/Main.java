package newpackage;

import com.opencsv.exceptions.CsvValidationException;
import vistas.MenuEmpleados;

public class Main {


    public static void main(String[] args) throws CsvValidationException {
        Menu.inicializarSistema();
        MenuEmpleados.iniciar();
    }
}