CREATE DATABASE sysgai;
\c sysgai

CREATE TABLE TipoTicket (
    idTipoTicket SERIAL,
    tipoTicket VARCHAR NOT NULL,
    PRIMARY KEY (idTipoTicket),
    UNIQUE (tipoTicket)
);

CREATE TABLE TipoEstadoTicket (
    idTipoEstadoTicket SERIAL,
    tipoEstadoTicket VARCHAR NOT NULL,
    PRIMARY KEY (idTipoEstadoTicket),
    UNIQUE (tipoEstadoTicket)
);

CREATE TABLE TipoPrioridad (
    idTipoPrioridad SERIAL,
    tipoPrioridad VARCHAR NOT NULL,
    PRIMARY KEY (idTipoPrioridad),
    UNIQUE (tipoPrioridad)
);

CREATE TABLE TipoProducto (
    idTipoProducto SERIAL,
    tipoProducto VARCHAR NOT NULL,
    PRIMARY KEY (idTipoProducto),
    UNIQUE (tipoProducto)
);

CREATE TABLE TipoEstadoProducto (
    idTipoEstadoProducto SERIAL,
    tipoEstadoProducto VARCHAR NOT NULL,
    PRIMARY KEY (idTipoEstadoProducto),
    UNIQUE (tipoEstadoProducto)
);

CREATE TABLE TipoImpresion (
    idTipoImpresion SERIAL,
    tipoImpresion VARCHAR NOT NULL,
    PRIMARY KEY (idTipoImpresion),
    UNIQUE (tipoImpresion)
);

CREATE TABLE TipoToner (
    idTipoToner SERIAL,
    tipoToner VARCHAR NOT NULL,
    PRIMARY KEY (idTipoToner),
    UNIQUE (tipoToner)
);

CREATE TABLE TipoColorToner (
    idTipoColorToner SERIAL,
    tipoColorToner VARCHAR,
    PRIMARY KEY (idTipoColorToner),
    UNIQUE (tipoColorToner)
);

CREATE TABLE TipoNivelCliente (
    idTipoNivelCliente SERIAL,
    tipoNivelCliente VARCHAR,
    PRIMARY KEY (idTipoNivelCliente),
    UNIQUE (tipoNivelCliente)
);

CREATE TABLE TipoPago (
    idTipoPago SERIAL,
    tipoPago VARCHAR,
    PRIMARY KEY (idTipoPago),
    UNIQUE (tipoPago)
);

CREATE TABLE TipoContrato (
    idTipoContrato SERIAL,
    tipoContrato VARCHAR,
    PRIMARY KEY (idTipoContrato),
    UNIQUE (tipoContrato)
);

CREATE TABLE TipoEstadoPedido (
    idTipoEstadoPedido SERIAL,
    tipoEstadoPedido VARCHAR NOT NULL,
    PRIMARY KEY (idTipoEstadoPedido),
    UNIQUE (tipoEstadoPedido)
);

CREATE TABLE TipoEstadoContrato (
    idTipoEstadoContrato SERIAL,
    tipoEstadoContrato VARCHAR NOT NULL,
    PRIMARY KEY (idTipoEstadoContrato),
    UNIQUE (tipoEstadoContrato)
);

CREATE TABLE TipoEstadoFactura (
    idTipoEstadoFactura SERIAL,
    tipoEstadoFactura VARCHAR NOT NULL,
    PRIMARY KEY (idTipoEstadoFactura),
    UNIQUE (tipoEstadoFactura)
);

CREATE TABLE Area (
    idArea SERIAL,
    fechaCreacionArea TIMESTAMP NOT NULL,
    fechaModificacionArea TIMESTAMP,
    nombreArea VARCHAR NOT NULL,
    PRIMARY KEY (idArea),
    UNIQUE (nombreArea)
);

CREATE TABLE Usuario (
    idUsuario SERIAL,
    idArea INTEGER NOT NULL,
    fechaCreacionUsuario TIMESTAMP NOT NULL,
    fechaModificacionUsuario TIMESTAMP,
    nombreUsuario VARCHAR NOT NULL,
    telefonoUsuario VARCHAR NOT NULL,
    mailUsuario VARCHAR NOT NULL,
    direccionUsuario TEXT,
    contraseniaUsuario VARCHAR NOT NULL,
    PRIMARY KEY (idUsuario),
    UNIQUE (mailUsuario),
    FOREIGN KEY(idArea) REFERENCES Area(idArea)
);

CREATE TABLE Cliente (
    idCliente SERIAL,
    idTipoNivelCliente INTEGER NOT NULL,
    fechaCreacionCliente TIMESTAMP NOT NULL,
    fechaModificacionCliente TIMESTAMP,
    nombreCliente VARCHAR NOT NULL,
    telefonoCliente VARCHAR NOT NULL,
    mailCliente VARCHAR NOT NULL,
    direccionCliente TEXT NOT NULL,
    PRIMARY KEY (idCliente),
    FOREIGN KEY(idTipoNivelCliente) REFERENCES TipoNivelCliente(idTipoNivelCliente)
);

CREATE TABLE Contrato (
    idContrato SERIAL,
    idCliente INTEGER NOT NULL,
    idTipoContrato INTEGER NOT NULL,
    idTipoPago INTEGER NOT NULL,
    idTipoToner INTEGER NOT NULL,
    idTipoEstadoProducto INTEGER NOT NULL,
    idTipoEstadoContrato INTEGER NOT NULL,
    fechaCreacionContrato TIMESTAMP NOT NULL,
    fechaModificacionContrato TIMESTAMP,
    inicioContrato TIMESTAMP NOT NULL,
    mesesContrato INTEGER NOT NULL,
    diaCorteContrato INTEGER NOT NULL,
    rentaMensualContrato INTEGER NOT NULL,
    bolsaBNContrato INTEGER NOT NULL,
    bolsaColorContrato INTEGER NOT NULL,
    clickBNContrato FLOAT NOT NULL,
    clickColorContrato FLOAT NOT NULL,
    PRIMARY KEY (idContrato),
    FOREIGN KEY(idCliente) REFERENCES Cliente(idCliente),
    FOREIGN KEY(idTipoContrato) REFERENCES TipoContrato(idTipoContrato),
    FOREIGN KEY(idTipoPago) REFERENCES TipoPago(idTipoPago),
    FOREIGN KEY(idTipoToner) REFERENCES TipoToner(idTipoToner),
    FOREIGN KEY(idTipoEstadoProducto) REFERENCES TipoEstadoProducto(idTipoEstadoProducto),
    FOREIGN KEY(idTipoEstadoContrato) REFERENCES TipoEstadoContrato(idTipoEstadoContrato)
);

CREATE TABLE Pedido (
    idPedido SERIAL,
    idUsuario INTEGER NOT NULL,
    idContrato INTEGER NOT NULL,
    idTipoEstadoPedido INTEGER NOT NULL,
    fechaCreacionPedido TIMESTAMP NOT NULL,
    fechaModificacionPedido TIMESTAMP,
    PRIMARY KEY (idPedido),
    FOREIGN KEY(idUsuario) REFERENCES Usuario(idUsuario),
    FOREIGN KEY(idContrato) REFERENCES Contrato(idContrato),
    FOREIGN KEY(idTipoEstadoPedido) REFERENCES TipoEstadoPedido(idTipoEstadoPedido)
);

CREATE TABLE Ticket (
    idTicket SERIAL,
    idTipoPrioridad INTEGER NOT NULL,
    idTipoEstadoTicket INTEGER NOT NULL,
    idTipoTicket INTEGER NOT NULL,
    idArea INTEGER NOT NULL,
    idUsuario INTEGER,
    idPedido INTEGER,
    fechaCreacionTicket TIMESTAMP NOT NULL NOT NULL,
    fechaModificacionTicket TIMESTAMP,
    descripcionTicket VARCHAR,
    PRIMARY KEY (idTicket),
    FOREIGN KEY(idTipoPrioridad) REFERENCES TipoPrioridad(idTipoPrioridad),
    FOREIGN KEY(idTipoEstadoTicket) REFERENCES TipoEstadoTicket(idTipoEstadoTicket),
    FOREIGN KEY(idTipoTicket) REFERENCES TipoTicket(idTipoTicket),
    FOREIGN KEY(idArea) REFERENCES Area(idArea),
    FOREIGN KEY(idUsuario) REFERENCES Usuario(idUsuario),
    FOREIGN KEY(idPedido) REFERENCES Pedido(idPedido)
);

CREATE TABLE Producto (
    idProducto SERIAL,
    idTipoProducto INTEGER NOT NULL,
    idTipoImpresion INTEGER,
    idTipoToner INTEGER,
    idTipoColorToner INTEGER,
    fechaCreacionProducto TIMESTAMP NOT NULL,
    fechaModificacionProducto TIMESTAMP,
    modeloProducto VARCHAR NOT NULL,
    costoProducto FLOAT NOT NULL,
    volumenProducto FLOAT NOT NULL,
    pesoProducto FLOAT NOT NULL,
    rendimientoProducto INTEGER,
    PRIMARY KEY (idProducto),
    FOREIGN KEY(idTipoProducto) REFERENCES TipoProducto(idTipoProducto),
    FOREIGN KEY(idTipoImpresion) REFERENCES TipoImpresion(idTipoImpresion),
    FOREIGN KEY(idTipoToner) REFERENCES TipoToner(idTipoToner),
    FOREIGN KEY(idTipoColorToner) REFERENCES TipoColorToner(idTipoColorToner)
);

CREATE TABLE Almacen (
    idAlmacen SERIAL,
    idCliente INTEGER,
    fechaCreacionAlmacen TIMESTAMP NOT NULL,
    fechaModificacionAlmacen TIMESTAMP,
    direccionAlmacen VARCHAR NOT NULL,
    PRIMARY KEY (idAlmacen),
    FOREIGN KEY(idCliente) REFERENCES Cliente(idCliente)
);

CREATE TABLE DetalleProducto (
    idDetalleProducto SERIAL,
    idProducto INTEGER NOT NULL,
    idAlmacen INTEGER NOT NULL,
    idTipoEstadoProducto INTEGER,
    fechaCreacionDetalleProducto TIMESTAMP NOT NULL,
    fechaModificacionDetalleProducto TIMESTAMP,
    serieDetalleProducto VARCHAR NOT NULL,
    contadorClienteDetalleProducto INTEGER,
    contadorProductoDetalleProducto INTEGER,
    PRIMARY KEY (idDetalleProducto),
    FOREIGN KEY(idProducto) REFERENCES Producto(idProducto),
    FOREIGN KEY(idAlmacen) REFERENCES Almacen(idAlmacen),
    FOREIGN KEY(idTipoEstadoProducto) REFERENCES TipoEstadoProducto(idTipoEstadoProducto)
);

CREATE TABLE Factura (
    idFactura SERIAL,
    idContrato INTEGER NOT NULL,
    idTipoEstadoFactura INTEGER NOT NULL,
    fechaCreacionFactura TIMESTAMP NOT NULL,
    fechaModificacionFactura TIMESTAMP,
    impuestoFactura INTEGER NOT NULL,
    cobroFactura FLOAT NOT NULL,
    PRIMARY KEY (idFactura),
    FOREIGN KEY(idContrato) REFERENCES Contrato(idContrato),
    FOREIGN KEY(idTipoEstadoFactura) REFERENCES TipoEstadoFactura(idTipoEstadoFactura)
);

CREATE TABLE PedidoDetalleProducto (
    idPedido INTEGER NOT NULL,
    idDetalleProducto INTEGER NOT NULL,
    FOREIGN KEY(idPedido) REFERENCES Pedido(idPedido),
    FOREIGN KEY(idDetalleProducto) REFERENCES DetalleProducto(idDetalleProducto)
);

CREATE TABLE Evidencia (
    idEvidencia SERIAL,
    idTicket INTEGER NOT NULL,
    idUsuario INTEGER NOT NULL,
    fechaCreacionEvidencia TIMESTAMP NOT NULL,
    fechaModificacionEvidencia TIMESTAMP,
    comentarioEvidencia TEXT NOT NULL,
    evidencia BYTEA NOT NULL,
    PRIMARY KEY (idEvidencia),
    FOREIGN KEY(idTicket) REFERENCES Ticket(idTicket),
    FOREIGN KEY(idUsuario) REFERENCES Usuario(idUsuario)
);
