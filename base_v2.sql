
create database almacenes_paul;
drop database almacenes_paul;
use almacenes_paul;

create table cliente(
	idCliente int auto_increment primary key,
	cedula varchar(10),
	nombres varchar(30),
	apellidos varchar(30),
	telfFijo varchar(10),
	telfMovil varchar(10),
	direccion varchar(30),
	correo varchar(25)
);

create table producto(
	idProducto int auto_increment primary key,
	nombre varchar(30),
	serie varchar(20),
	marca varchar(20),
	descripcion varchar(25),
	precio float,
    cantidad int
);

create table venta(
	idVenta int auto_increment primary key,
	idCliente int,
	tipo varchar(20),
	fecha date 
);

create table productos_venta(
	idVenta int,  
	idProducto int
);

alter table venta add constraint FK_VENTA foreign key (idCliente)
      references CLIENTE(idCliente) on delete restrict on update restrict;

alter table productos_venta add constraint FK_TIENE1 foreign key (idVenta) references VENTA(idVenta) on delete restrict on update restrict;

alter table productos_venta add constraint FK_TIENE2 foreign key (idProducto) references PRODUCTO(idProducto) on delete restrict on update restrict;
