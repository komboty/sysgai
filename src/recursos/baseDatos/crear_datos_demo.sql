\c sysgai

INSERT INTO Usuario (idUsuario, idArea, fechaCreacionUsuario, fechaModificacionUsuario, nombreUsuario, telefonoUsuario, mailUsuario, direccionUsuario, contraseniaUsuario) VALUES
    (DEFAULT, 1, CURRENT_TIMESTAMP, NULL, 'Arrendador', '5524345678', 'arrendador@gncorp.com', 'CALLE: calle 2,NUM.EXT.: 2,NUM.INT.: Null,LOCALIDAD: colonia 2,MUNICIPIO: alcaldia 2,C.P.: 22222,ESTADO: estado 1', '123'),
    (DEFAULT, 2, CURRENT_TIMESTAMP, NULL, 'Abogado', '5532675678', 'abogado@gncorp.com', 'CALLE: calle3,NUM.EXT.: 3,NUM.INT.: Null,LOCALIDAD: colonia 3,MUNICIPIO: alcaldia 3,C.P.: 33333,ESTADO: estado 1', '123'),
    (DEFAULT, 3, CURRENT_TIMESTAMP, NULL, 'Contador', '5542349378', 'contador@gncorp.com', 'CALLE: calle 4,NUM.EXT.: 4,NUM.INT.: Null,LOCALIDAD: colonia 4,MUNICIPIO: alcaldia 4,C.P.: 44444,ESTADO: estado 1', '123'),
    (DEFAULT, 4, CURRENT_TIMESTAMP, NULL, 'Técnico', '5558345678', 'tecnico@gncorp.com', 'CALLE: calle 5,NUM.EXT.: 5,NUM.INT.: Null,LOCALIDAD: colonia 5,MUNICIPIO: alcaldia 5,C.P.: 55555,ESTADO: estado 1', '123'),
    (DEFAULT, 5, CURRENT_TIMESTAMP, NULL, 'Mesa de servicio', '5562346678', 'mesaservicio@gncorp.com', 'CALLE: calle 6,NUM.EXT.: 6,NUM.INT.: Null,LOCALIDAD: colonia 6,MUNICIPIO: alcaldia 6,C.P.: 66666,ESTADO: estado 1', '123'),
    (DEFAULT, 6, CURRENT_TIMESTAMP, NULL, 'Almacenista', '5582379678', 'almacenista@gncorp.com', 'CALLE: calle 7,NUM.EXT.: 7,NUM.INT.: Null,LOCALIDAD: colonia 7,MUNICIPIO: alcaldia 7,C.P.: 77777,ESTADO: estado 1', '123'),
    (DEFAULT, 7, CURRENT_TIMESTAMP, NULL, 'Chofer', '5576365678', 'chofer@gncorp.com', 'CALLE: calle 8,NUM.EXT.: 8,NUM.INT.: Null,LOCALIDAD: colonia 8,MUNICIPIO: alcaldia 8,C.P.: 88888,ESTADO: estado 1', '123');

INSERT INTO Cliente (idCliente, idTipoNivelCliente, fechaCreacionCliente, fechaModificacionCliente, nombreCliente, telefonoCliente, mailCliente, direccionCliente) VALUES
    (DEFAULT, 1, CURRENT_TIMESTAMP, NULL, 'Cliente 1', '5504346678', 'cliente1@gmail.com', 'CALLE: calle9,NUM.EXT.: 9,NUM.INT.: Null,LOCALIDAD: colonia 9,MUNICIPIO: alcaldia 9,C.P.: 99999,ESTADO: estado 2'),
    (DEFAULT, 2, CURRENT_TIMESTAMP, NULL, 'Cliente 2', '5514346678', 'cliente2@gmail.com', 'CALLE: calle 123,NUM.EXT.: 123,NUM.INT.: Null,LOCALIDAD: colonia 123,MUNICIPIO: alcaldia 123,C.P.: 99999,ESTADO: estado 3'),
    (DEFAULT, 3, CURRENT_TIMESTAMP, NULL, 'Cliente 3', '5524346678', 'cliente3@gmail.com', 'CALLE: calle 345,NUM.EXT.: 345,NUM.INT.: Null,LOCALIDAD: colonia 345,MUNICIPIO: alcaldia 345,C.P.: 99999,ESTADO: estado 2'),
    (DEFAULT, 2, CURRENT_TIMESTAMP, NULL, 'Cliente 4', '5534346678', 'cliente3@gmail.com', 'CALLE: calle 45,NUM.EXT.: 45,NUM.INT.: Null,LOCALIDAD: colonia 45,MUNICIPIO: alcaldia 45,C.P.: 99999,ESTADO: estado 9');

INSERT INTO Contrato (idContrato, idCliente, idTipoContrato, idTipoPago, idTipoToner, idTipoEstadoProducto, idTipoEstadoContrato, fechaCreacionContrato, fechaModificacionContrato, inicioContrato, mesesContrato, diaCorteContrato, rentaMensualContrato, bolsaBNContrato, bolsaColorContrato, clickBNContrato, clickColorContrato) VALUES
    (DEFAULT, 1, 1, 1, 1, 1, 4, CURRENT_TIMESTAMP, NULL, '2022-12-01 00:00:00', 6, 28, 8000.0, 0, 0, 0.0, 0.0),
    (DEFAULT, 2, 2, 2, 2, 2, 2, CURRENT_TIMESTAMP, NULL, '2023-01-01 00:00:00', 8, 22, 2000.0, 3000, 1000, 0.16, 1.2),
    (DEFAULT, 3, 3, 3, 1, 1, 1, CURRENT_TIMESTAMP, NULL, '2023-03-14 00:00:00', 12, 15, 0.0, 0, 0, 0.2, 1.6),
    (DEFAULT, 4, 3, 4, 1, 2, 3, CURRENT_TIMESTAMP, NULL, '2023-06-24 00:00:00', 12, 1, 0.0, 0, 0, 0.18, 2.3);

INSERT INTO Pedido (idPedido, idUsuario, idContrato, idTipoEstadoPedido, fechaCreacionPedido, fechaModificacionPedido) VALUES
    (DEFAULT, 2, 1, 10, CURRENT_TIMESTAMP, NULL);

INSERT INTO Ticket (idTicket, idTipoPrioridad, idTipoEstadoTicket, idTipoTicket, idArea, idUsuario, idPedido, fechaCreacionTicket, fechaModificacionTicket, descripcionTicket) VALUES
    (DEFAULT, 3, 4, 1, 5, 6, 1, CURRENT_TIMESTAMP, NULL, 'Resuleto sin demora'),
    (DEFAULT, 1, 1, 3, 5, NULL, 1, CURRENT_TIMESTAMP, NULL, ''),
    (DEFAULT, 3, 1, 2, 8, 1, NULL, CURRENT_TIMESTAMP, NULL, 'Crear 2 usuarios de Arrendamiento'),
    (DEFAULT, 2, 1, 3, 5, NULL, NULL, CURRENT_TIMESTAMP, NULL, '');

INSERT INTO Producto (idProducto, idTipoProducto, idTipoImpresion, idTipoToner, idTipoColorToner, fechaCreacionProducto, fechaModificacionProducto, modeloProducto, costoProducto, volumenProducto, pesoProducto, rendimientoProducto) VALUES
    (DEFAULT, 2, 2, NULL, NULL, CURRENT_TIMESTAMP, NULL, 'HP123', 8600.0, 0.0, 0.0, NULL),
    (DEFAULT, 1, NULL, NULL, NULL, CURRENT_TIMESTAMP, NULL, 'REF-HP123', 300.0, 0.0, 0.0, NULL),
    (DEFAULT, 3, NULL, 1, 1, CURRENT_TIMESTAMP, NULL, 'TK-HP123', 500.0, 0.0, 0.0, 2000),
    (DEFAULT, 3, NULL, 1, 2, CURRENT_TIMESTAMP, NULL, 'TY-HP123', 600.0, 0.0, 0.0, 1600),
    (DEFAULT, 3, NULL, 1, 3, CURRENT_TIMESTAMP, NULL, 'TC-HP123', 600.0, 0.0, 0.0, 1600),
    (DEFAULT, 3, NULL, 1, 4, CURRENT_TIMESTAMP, NULL, 'TM-HP123', 600.0, 0.0, 0.0, 1600);

INSERT INTO Almacen (idAlmacen, idCliente, fechaCreacionAlmacen, fechaModificacionAlmacen, direccionAlmacen) VALUES
    (DEFAULT, NULL, CURRENT_TIMESTAMP, NULL, 'CALLE: calle0,NUM.EXT.: 0,NUM.INT.: Null,LOCALIDAD: colonia0,MUNICIPIO: alcaldia0,C.P.: 00000,ESTADO: estado0'),
    (DEFAULT, 1, CURRENT_TIMESTAMP, NULL, 'CALLE: calle9,NUM.EXT.: 9,NUM.INT.: Null,LOCALIDAD: colonia9,MUNICIPIO: alcaldia9,C.P.: 99999,ESTADO: estado9');

INSERT INTO DetalleProducto (idDetalleProducto, idProducto, idAlmacen, idTipoEstadoProducto, fechaCreacionDetalleProducto, fechaModificacionDetalleProducto, serieDetalleProducto, contadorClienteDetalleProducto, contadorProductoDetalleProducto) VALUES
    (DEFAULT, 1, 2, 1, CURRENT_TIMESTAMP, NULL, '00001', 0, 0),
    (DEFAULT, 1, 1, 1, CURRENT_TIMESTAMP, NULL, '00002', 0, 0),
    (DEFAULT, 1, 1, 1, CURRENT_TIMESTAMP, NULL, '00003', 0, 0),
    (DEFAULT, 1, 1, 1, CURRENT_TIMESTAMP, NULL, '00004', 0, 0),
    (DEFAULT, 2, 1, NULL, CURRENT_TIMESTAMP, NULL, '00001', NULL, NULL),
    (DEFAULT, 2, 1, NULL, CURRENT_TIMESTAMP, NULL, '00002', NULL, NULL),
    (DEFAULT, 3, 2, NULL, CURRENT_TIMESTAMP, NULL, '00001', NULL, NULL),
    (DEFAULT, 3, 1, NULL, CURRENT_TIMESTAMP, NULL, '00002', NULL, NULL),
    (DEFAULT, 3, 1, NULL, CURRENT_TIMESTAMP, NULL, '00003', NULL, NULL),
    (DEFAULT, 4, 2, NULL, CURRENT_TIMESTAMP, NULL, '00001', NULL, NULL),
    (DEFAULT, 4, 1, NULL, CURRENT_TIMESTAMP, NULL, '00002', NULL, NULL),
    (DEFAULT, 4, 1, NULL, CURRENT_TIMESTAMP, NULL, '00003', NULL, NULL),
    (DEFAULT, 5, 2, NULL, CURRENT_TIMESTAMP, NULL, '00001', NULL, NULL),
    (DEFAULT, 5, 1, NULL, CURRENT_TIMESTAMP, NULL, '00002', NULL, NULL),
    (DEFAULT, 5, 1, NULL, CURRENT_TIMESTAMP, NULL, '00003', NULL, NULL),    
    (DEFAULT, 6, 2, NULL, CURRENT_TIMESTAMP, NULL, '00001', NULL, NULL),
    (DEFAULT, 6, 1, NULL, CURRENT_TIMESTAMP, NULL, '00002', NULL, NULL),
    (DEFAULT, 6, 1, NULL, CURRENT_TIMESTAMP, NULL, '00003', NULL, NULL);

INSERT INTO Factura (idFactura, idContrato, idTipoEstadoFactura, fechaCreacionFactura, fechaModificacionFactura, impuestoFactura, cobroFactura) VALUES
    (DEFAULT, 1, 3, CURRENT_TIMESTAMP, NULL, 16, 8000.0);

INSERT INTO PedidoDetalleProducto (idPedido, idDetalleProducto) VALUES
    (1, 1),
    (1, 7),
    (1, 10),
    (1, 13),
    (1, 16);

INSERT INTO Evidencia (idEvidencia, idTicket, idUsuario, fechaCreacionEvidencia, fechaModificacionEvidencia, comentarioEvidencia, evidencia) VALUES
    (DEFAULT, 1, 7, CURRENT_TIMESTAMP, NULL, 'Entregado', ''),
    (DEFAULT, 1, 5, CURRENT_TIMESTAMP, NULL, 'Instalado', '');
