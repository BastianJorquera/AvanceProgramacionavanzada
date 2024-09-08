import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Menu.inicializarSistema();
        boolean continuar = true;
        while (continuar) {
            Menu.mostrarMenu();
            int opcion = Menu.obtenerOpcion();
            continuar = Menu.procesarOpcion(opcion);
        }
        scanner.close();
    }
}