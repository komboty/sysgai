package servicios.dtos;

import java.util.List;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class UsuarioDTO {

    private int id;
    private String fechaCreacion;
    private String fechaModificacion;
    private String nombre;
    private String telefono;
    private String mail;
    private String direccion;
    private String nombreArea;
    private List<Integer> idsTickets;
    private List<Integer> idsPedidos;

    public UsuarioDTO() {
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

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

    public List<Integer> getIdsTickets() {
        return idsTickets;
    }

    public void setIdsTickets(List<Integer> idTickets) {
        this.idsTickets = idTickets;
    }

    public List<Integer> getIdsPedidos() {
        return idsPedidos;
    }

    public void setIdsPedidos(List<Integer> idPedidos) {
        this.idsPedidos = idPedidos;
    }

}
