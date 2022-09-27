package servicios.interfaces;

import modelo.entidades.Producto;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface ProductoServicio extends GenericServicio<Producto> {

//    public Producto crearProducto(int idTipoProducto, int idTipoImpresion, int idTipoToner, 
//            int idTipoColorToner, String modelo, double costo, double volumen, double peso, int rendimiento);
    public Producto crearImpresora(int idTipoImpresion, String modelo, double costo, double volumen, double peso);

    public Producto crearRefaccion(String modelo, double costo, double volumen, double peso);

    public Producto crearToner(int idTipoToner, int idTipoColorToner, String modelo, 
            double costo, double volumen, double peso, int rendimiento);
}
