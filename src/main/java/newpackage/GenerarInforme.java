package newpackage;

import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

public class GenerarInforme {
    // Método estático para generar un informe de empleados de una sucursal
    public static void generarInformeEmpleados(Sucursal sucursal, String rutaArchivo) {
        List<Empleado> empleadosOrdenados = sucursal.obtenerEmpleadosOrdenadosPorSalario();
        // Utiliza un try-with-resources para manejar el FileWriter y asegurar que se cierre correctamente
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            // Escribe el encabezado del informe

            writer.write("Informe de Empleados (Ordenados por Salario de Mayor a Menor)\n");
            writer.write("===========================================================\n\n");
            // Itera sobre cada empleado en la lista ordenada
            for (Empleado empleado : empleadosOrdenados) {
                // Escribe los detalles de cada empleado en el archivo
                writer.write(String.format("Nombre: %s\n", empleado.getNombre()));
                writer.write(String.format("RUT: %s\n", empleado.getRut()));
                writer.write(String.format("Cargo: %s\n", empleado.getCargo()));
                writer.write(String.format("Departamento: %s\n", empleado.getDepartamento()));
                writer.write(String.format("Salario: $%.2f\n", empleado.getSalario()));
                writer.write(String.format("Fecha de Contrato: %s\n", empleado.getFechaContrato()));
                writer.write("-------------------------------------------\n");
            }
            
            System.out.println("Informe generado exitosamente en: " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al generar el informe: " + e.getMessage());
        }
    }
}