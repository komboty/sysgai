package servicios.interfaces;

import servicios.dtos.ProductoDTO;

/**
 * @author Jose Alberto Salvador Cruz y Giovanni Pavón Callejas
 */
public interface ProductoServicio extends GenericServicio<ProductoDTO> {

//    public Producto crearProducto(int idTipoProducto, int idTipoImpresion, int idTipoToner, 
//            int idTipoColorToner, String modelo, double costo, double volumen, double peso, int rendimiento);
    public ProductoDTO crearImpresora(int idTipoImpresion, String modelo, double costo, double volumen, double peso);

    public ProductoDTO crearRefaccion(String modelo, double costo, double volumen, double peso);

    public ProductoDTO crearToner(int idTipoToner, int idTipoColorToner, String modelo, 
            double costo, double volumen, double peso, int rendimiento);
}
