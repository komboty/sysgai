package servicios.interfaces;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface ProductoServicio<T, K> extends GenericServicio<T> {

//    public Producto crearProducto(int idTipoProducto, int idTipoImpresion, int idTipoToner, 
//            int idTipoColorToner, String modelo, double costo, double volumen, double peso, int rendimiento);
    public K crearImpresora(int idTipoImpresion, String modelo, double costo, double volumen, double peso);

    public K crearRefaccion(String modelo, double costo, double volumen, double peso);

    public K crearToner(int idTipoToner, int idTipoColorToner, String modelo,
            double costo, double volumen, double peso, int rendimiento);
}
