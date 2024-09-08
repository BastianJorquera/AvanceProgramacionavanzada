package newpackage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Gobierno {

    private String nombrePais;
    private String nombrePresidente;
    private HashMap<String, Ministerio> ministerios;



    public Gobierno(String nombrePais, String nombrePresidente) {
        this.nombrePais = "Chile";
        this.nombrePresidente = "Gabriel Boric";
        this.ministerios = new HashMap<>();
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getNombrePresidente() {
        return nombrePresidente;
    }

    public void setNombrePresidente(String nombrePresidente) {
        this.nombrePresidente = nombrePresidente;
    }


    public void agregarMinisterio(Ministerio ministerio) {
        String idMinisterio = ministerio.getIdMinisterio();
        if (ministerios.containsKey(idMinisterio)) {
            System.out.println("Error: El Ministerio con id " + idMinisterio + " ya existe.");
        } else {
            ministerios.put(idMinisterio, ministerio);
            System.out.println("Éxito: Ministerio " + ministerio.getNameMinisterio() + " agregado correctamente.");
        }
    }

    public Ministerio obtenerMinisterio(String idMinisterio) {
        return ministerios.get(idMinisterio);
    }

    public Ministerio obtenerMinisterioPorNombre(String nombreMinisterio) {
        for (Ministerio ministerio : ministerios.values()) {
            if (ministerio.getNameMinisterio().equalsIgnoreCase(nombreMinisterio)) {
                return ministerio;
            }
        }
        System.out.println("Error: No se encontró un ministerio con el nombre " + nombreMinisterio);
        return null;
    }


    public void eliminarMinisterio(String idMinisterio) {
        if (ministerios.containsKey(idMinisterio)) {
            ministerios.remove(idMinisterio);
            System.out.println("Éxito: Ministerio con id " + idMinisterio + " eliminado correctamente.");
        } else {
            System.out.println("Error: El Ministerio con id " + idMinisterio + " no existe.");
        }
    }

    public void listarMinisterios() {
        for (String key : ministerios.keySet()) {
            Ministerio ministerio = ministerios.get(key);
            System.out.println(ministerio.getNameMinisterio());
        }
    }
}