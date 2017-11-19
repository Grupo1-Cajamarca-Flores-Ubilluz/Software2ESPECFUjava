drop database almacenes_paul;
create database almacenes_paul;
use almacenes_paul;

create table cliente(
	idCliente int auto_increment primary key,
	cedula varchar(10),
	nombres varchar(30),
	apellidos varchar(30),
	telfFijo varchar(10),
	telfMovil varchar(10),
	direccion varchar(30),
	correo varchar(25),
    activo int default 1
);



select * from cliente;

create table producto(
	idProducto int auto_increment primary key,
	nombre varchar(30),
	serie varchar(20),
	marca varchar(20),
	descripcion varchar(25),
	precio float,
    cantidad int,
    activo int default 1
);

select * from producto;


create table venta(
	idVenta int auto_increment primary key,
	idCliente int,
	total float,
	fecha date 
);

select * from venta;

create table productos_venta(
	idVenta int,  
	idProducto int,
    cantidad int
);

select * from productos_venta;

alter table venta add constraint FK_VENTA1 foreign key (idCliente) references CLIENTE(idCliente) on delete restrict on update restrict;

alter table productos_venta add constraint FK_TIENE1 foreign key (idVenta) references VENTA(idVenta) on delete restrict on update restrict;
alter table productos_venta add constraint FK_TIENE2 foreign key (idProducto) references PRODUCTO(idProducto) on delete restrict on update restrict;

select v.idVenta, c.cedula, c.nombres, c.apellidos, v.total, v.fecha
from cliente c join venta v
on (v.idCliente = c.idCliente);

select v.idVenta, c.cedula, c.nombres, c.apellidos, v.total, v.fecha, p.nombre, p.precio, pv.cantidad
from cliente c join venta v join producto p join productos_venta pv
on (v.idCliente = c.idCliente and v.idVenta=pv.idVenta and pv.idProducto=p.idProducto);
