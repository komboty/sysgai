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
    private List<Integer> idTickets;
    private List<Integer> idPedidos;

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

    public List<Integer> getIdTickets() {
        return idTickets;
    }

    public void setIdTickets(List<Integer> idTickets) {
        this.idTickets = idTickets;
    }

    public List<Integer> getIdPedidos() {
        return idPedidos;
    }

    public void setIdPedidos(List<Integer> idPedidos) {
        this.idPedidos = idPedidos;
    }

}
