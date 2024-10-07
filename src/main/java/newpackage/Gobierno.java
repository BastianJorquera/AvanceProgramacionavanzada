package newpackage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase que representa el gobierno de un país.
 */

public class Gobierno {

    private String nombrePais;
    private String nombrePresidente;
    private HashMap<String, Ministerio> ministerios;
    
    // Contructor de la clase Gobierno

    public Gobierno(String nombrePais, String nombrePresidente) {
        this.nombrePais = "Chile";
        this.nombrePresidente = "Gabriel Boric";
        this.ministerios = new HashMap<>();
    }
    
    //Metodos Getter para acceder a los atributos privados

    public String getNombrePais() {
        return nombrePais;
    }

    public String getNombrePresidente() {
        return nombrePresidente;
    }
     // Métodos setter para modificar los atributos privados
    
     public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public void setNombrePresidente(String nombrePresidente) {
        this.nombrePresidente = nombrePresidente;
    }
    
    /**
     * Agrega un ministerio al gobierno.
     *
     * @param ministerio El ministerio a agregar
     */

    public void agregarMinisterio(Ministerio ministerio) {
        String idMinisterio = ministerio.getIdMinisterio();// Obtiene el ID del ministerio
        // Verifica si el ministerio ya existe en el HashMap
        if (ministerios.containsKey(idMinisterio)) {
            System.out.println("Error: El Ministerio con id " + idMinisterio + " ya existe.");
        } else {
            ministerios.put(idMinisterio, ministerio);// Agrega el ministerio al HashMap
            System.out.println("Éxito: Ministerio " + ministerio.getNameMinisterio() + " agregado correctamente.");
        }
    }
    
    //Obtiene un ministerio por su ID

    public Ministerio obtenerMinisterio(String idMinisterio) {
        return ministerios.get(idMinisterio);// Devuelve el ministerio correspondiente al ID
    }
     
    //Obtiene un ministerio por su nombre
    
    public Ministerio obtenerMinisterioPorNombre(String nombreMinisterio) {
         // Recorre todos los ministerios en el HashMap
        for (Ministerio ministerio : ministerios.values()) {
            // Verifica si el nombre del ministerio coincide
            if (ministerio.getNameMinisterio().equalsIgnoreCase(nombreMinisterio)) {
                return ministerio;// Devuelve el ministerio encontrado
            }
        }
        System.out.println("Error: No se encontró un ministerio con el nombre " + nombreMinisterio);
        return null;// Devuelve null si no se encuentra el ministerio
    }
    
    //Elimina un ministerio por su ID.
    
    public void eliminarMinisterio(String idMinisterio) {
        // Verifica si el ministerio existe en el HashMap

        if (ministerios.containsKey(idMinisterio)) {
            ministerios.remove(idMinisterio);// Elimina el ministerio del HashMap
            System.out.println("Éxito: Ministerio con id " + idMinisterio + " eliminado correctamente.");
        } else {
            System.out.println("Error: El Ministerio con id " + idMinisterio + " no existe.");
        }
    }
    
    /**
     * Lista todos los ministerios registrados en el gobierno.
     */

    public void listarMinisterios() {
        // Recorre las claves del HashMap (IDs de ministerios)
        for (String key : ministerios.keySet()) {
            Ministerio ministerio = ministerios.get(key);// Obtiene el ministerio correspondiente a la clave
            System.out.println(ministerio.getNameMinisterio());
        }
    }
}