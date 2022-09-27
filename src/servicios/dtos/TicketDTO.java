package servicios.dtos;

import java.util.List;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public class TicketDTO {

    private int id;
    private String fechaCreacion;
    private String fechaModificacion;
    private String tipo;
    private String prioridad;
    private String estado;
    private String descripcion;
    private String nombreAreaAsignada;
    private String mailUsuarioAsignado;
    private List<Integer> idsEvidencias;
    private int idPedido;

    public TicketDTO() {
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreAreaAsignada() {
        return nombreAreaAsignada;
    }

    public void setNombreAreaAsignada(String nombreAreaAsignada) {
        this.nombreAreaAsignada = nombreAreaAsignada;
    }

    public String getMailUsuarioAsignado() {
        return mailUsuarioAsignado;
    }

    public void setMailUsuarioAsignado(String mailUsuarioAsignado) {
        this.mailUsuarioAsignado = mailUsuarioAsignado;
    }

    public List<Integer> getIdsEvidencias() {
        return idsEvidencias;
    }

    public void setIdsEvidencias(List<Integer> idsEvidencias) {
        this.idsEvidencias = idsEvidencias;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

}
