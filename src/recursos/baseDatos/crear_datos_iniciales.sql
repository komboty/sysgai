\c sysgai

INSERT INTO TipoTicket (idTipoTicket, tipoTicket) VALUES
    (DEFAULT, 'Contrato'),
    (DEFAULT, 'Falla'),
    (DEFAULT, 'Toner');

INSERT INTO TipoEstadoTicket (idTipoEstadoTicket, tipoEstadoTicket) VALUES
    (DEFAULT, 'Nuevo'),
    (DEFAULT, 'En Contrato'),
    (DEFAULT, 'En Pedido'),
    (DEFAULT, 'Resuelto'),
    (DEFAULT, 'Cancelado');

INSERT INTO TipoPrioridad (idTipoPrioridad, tipoPrioridad) VALUES
    (DEFAULT, 'Baja'),
    (DEFAULT, 'Media'),
    (DEFAULT, 'Alta');

INSERT INTO TipoProducto (idTipoProducto, tipoProducto) VALUES
    (DEFAULT, 'Refacción'),
    (DEFAULT, 'Impresora'),
    (DEFAULT, 'Tóner');

INSERT INTO TipoEstadoProducto (idTipoEstadoProducto, TipoEstadoProducto) VALUES
    (DEFAULT, 'Nuevo'),
    (DEFAULT, 'Usado');

INSERT INTO TipoImpresion (idTipoImpresion, tipoImpresion) VALUES
    (DEFAULT, 'Blanco y Negro'),
    (DEFAULT, 'Color');

INSERT INTO TipoToner (idTipoToner, tipoToner) VALUES
    (DEFAULT, 'Original'),
    (DEFAULT, 'Genérico');

INSERT INTO TipoColorToner (idTipoColorToner, tipoColorToner) VALUES
    (DEFAULT, 'Negro'),
    (DEFAULT, 'Amarillo'),
    (DEFAULT, 'Cian'),
    (DEFAULT, 'Magenta');

INSERT INTO TipoNivelCliente (idTipoNivelCliente, tipoNivelCliente) VALUES
    (DEFAULT, 'A'),
    (DEFAULT, 'B'),
    (DEFAULT, 'C');

INSERT INTO TipoPago (idTipoPago, tipoPago) VALUES
    (DEFAULT, 'Efectivo'),
    (DEFAULT, 'Tarjeta de crédito'),
    (DEFAULT, 'Tarjeta de débito'),
    (DEFAULT, 'Cheque'),
    (DEFAULT, 'Transferencia'),
    (DEFAULT, 'A satisfacción del acreedor');

INSERT INTO TipoContrato (idTipoContrato, tipoContrato) VALUES
    (DEFAULT, 'Renta mensual'),
    (DEFAULT, 'Renta por bolsa'),
    (DEFAULT, 'Costo por páginas procesadas'),
    (DEFAULT, 'Soporte y Mantenimiento de equipos');

INSERT INTO TipoEstadoPedido (idTipoEstadoPedido, tipoEstadoPedido) VALUES
    (DEFAULT, 'Borrador'),
    (DEFAULT, 'En validación'),
    (DEFAULT, 'Rechazado'),
    (DEFAULT, 'Validado'),
    (DEFAULT, 'En almacén'),
    (DEFAULT, 'Surtido'),
    (DEFAULT, 'En distribución'),
    (DEFAULT, 'Entregado'),
    (DEFAULT, 'En instalación'),
    (DEFAULT, 'Instalado');

INSERT INTO TipoEstadoContrato (idTipoEstadoContrato, tipoEstadoContrato) VALUES
    (DEFAULT, 'Borrador'),
    (DEFAULT, 'En validación'),
    (DEFAULT, 'Rechazado'),
    (DEFAULT, 'Validado');
    
INSERT INTO TipoEstadoFactura (idTipoEstadoFactura, tipoEstadoFactura) VALUES
    (DEFAULT, 'Borrador'),
    (DEFAULT, 'Por pagar'),
    (DEFAULT, 'Pagada');

INSERT INTO Area (idArea, fechaCreacionArea, fechaModificacionArea, nombreArea) VALUES
    (DEFAULT, CURRENT_TIMESTAMP, NULL, 'Arrendamiento'),
    (DEFAULT, CURRENT_TIMESTAMP, NULL, 'Abogados'),
    (DEFAULT, CURRENT_TIMESTAMP, NULL, 'Contadores'),
    (DEFAULT, CURRENT_TIMESTAMP, NULL, 'Técnicos'),
    (DEFAULT, CURRENT_TIMESTAMP, NULL, 'Mesa de servicio'),
    (DEFAULT, CURRENT_TIMESTAMP, NULL, 'Almacén'),
    (DEFAULT, CURRENT_TIMESTAMP, NULL, 'Distribución'),
    (DEFAULT, CURRENT_TIMESTAMP, NULL, 'Administración');
    
INSERT INTO Usuario (idUsuario, idArea, fechaCreacionUsuario, fechaModificacionUsuario, nombreUsuario, telefonoUsuario, mailUsuario, direccionUsuario, contraseniaUsuario) VALUES
    (DEFAULT, 8, CURRENT_TIMESTAMP, NULL, 'Admin', '5512345678', 'admin@gncorp.com', 'CALLE: calle 1,NUM.EXT.: 1,NUM.INT.: Null,LOCALIDAD: colonia 1,MUNICIPIO: alcaldia 1,C.P.: 11111,ESTADO: estado 1', '123');
