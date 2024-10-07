package newpackage;
import java.time.LocalDate;
import java.util.ArrayList;

public class Ministerio {
    // Atributos privados de la clase
    private String nameMinisterio;
    private String idMinisterio;
    private LocalDate anioCreacion;
    private ArrayList<Sucursal> sucursales;

    // Constructor de la clase
    public Ministerio(String nameMinisterio, String idMinisterio, LocalDate anioCreacion){
        this.nameMinisterio = nameMinisterio;
        this.idMinisterio = idMinisterio;
        this.anioCreacion = anioCreacion;
        this.sucursales = new ArrayList<>(); // Inicializa la lista de sucursales
    }

    // Método para agregar una sucursal
    public void agregarSucursal(Sucursal sucursal){
        // Verifica si la sucursal ya existe
        for(Sucursal s : sucursales){
            if(s.getIdSucursal().equals(sucursal.getIdSucursal())){
                System.out.println("La sucursal con ID " + sucursal.getIdSucursal() + "ya existe en el Ministerio.");
                return;
            }
        }
        // Si no existe, la agrega
        sucursales.add(sucursal);
        System.out.println("Sucursal agregada al " + getNameMinisterio() + " : " + sucursal.getNameSucursal());
    }

    // Método para eliminar una sucursal
    public boolean eliminarSucursal(String idSucursal){
        for (Sucursal sucursal : sucursales){
            if (sucursal.getIdSucursal().equals(idSucursal)){
                sucursales.remove(sucursal);
                System.out.println("Sucursal eliminada del " + getNameMinisterio());
                return true;
            }
        }
        System.out.println("Sucursal con Id: "+ idSucursal + "no existe en el Ministerio");
        return false;
    }

    // Método para listar todas las sucursales
    public void listarSucursales(){
        if(sucursales.isEmpty()){
            System.out.println("No hay sucursales en el Ministerio.");
        } else {
            System.out.println("Sucursales del "+ getNameMinisterio());
            for(Sucursal sucursal : sucursales){
                System.out.println("Sucursal: " + sucursal.getIdSucursal() + " - " + sucursal.getNameSucursal());
            }
        }
    }

    // Métodos getter y setter para los atributos
    public String getNameMinisterio() {
        return nameMinisterio;
    }

    public String getIdMinisterio(){
        return idMinisterio;
    }

    public LocalDate getAnioCreacion() {
        return anioCreacion;
    }

    public void setNameMinisterio(String nameMinisterio) {
        this.nameMinisterio = nameMinisterio;
    }

    public void setIdMinisterio(String idMinisterio){
        this.idMinisterio = idMinisterio;
    }

    public void setAnioCreacion(LocalDate anioCreacion) {
        this.anioCreacion = anioCreacion;
    }
}