package servicios.dtos;

import java.util.List;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class ClienteDTO {

    private int id;
    private String fechaCreacion;
    private String fechaModificacion;
    private String nombre;
    private String telefono;
    private String mail;
    private String direccion;
    private String nivel;
    private List<Integer> idsAlmacenes;
    private List<Integer> idsContratos;

    public ClienteDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public List<Integer> getIdsAlmacenes() {
        return idsAlmacenes;
    }

    public void setIdsAlmacenes(List<Integer> idsAlmacenes) {
        this.idsAlmacenes = idsAlmacenes;
    }

    public List<Integer> getIdsContratos() {
        return idsContratos;
    }

    public void setIdsContratos(List<Integer> idsContratos) {
        this.idsContratos = idsContratos;
    }

}
