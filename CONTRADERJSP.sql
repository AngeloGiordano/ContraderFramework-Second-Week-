drop database contraderJSP;
create database contraderJSP;

create table contraderJSP.users(
  id_user int(20) NOT NULL AUTO_INCREMENT,
  username varchar(50),
  password varchar(50),
  role varchar(20),
  PRIMARY KEY (id_user)
);

create table contraderJSP.gomme(
  id_gomme int(20) NOT NULL AUTO_INCREMENT,
  model varchar(50),
  manufacturer varchar(50),
  price float,
  PRIMARY KEY (id_gomme)
);

create table contraderJSP.vehicle(
  id_vehicle int(20) NOT NULL AUTO_INCREMENT,
  brand varchar(50),
  model varchar(50),
  fuel varchar(20),
  PRIMARY KEY (id_vehicle)
);

create table contraderJSP.compatibility(
	id_vehicle int(20),
	id_gomme int(20),
	foreign key (id_vehicle) references contrader.vehicle(id_vehicle),
	foreign key (id_gomme) references contrader.gomme(id_gomme)
);


insert into contraderJSP.users (username, password,role)
values ('user','user','user');
insert into contraderJSP.users (username, password,role)
values ('admin', 'admin','admin');

insert into contraderJSP.gomme (model, manufacturer, price)
values ('Trelleborg-B50','Trelleborg',200.50);
insert into contraderJSP.gomme (model, manufacturer, price)
values ('Trelleborg-B60','Trelleborg',100.50);
insert into contraderJSP.gomme (model, manufacturer, price)
values ('Trelleborg-B70','Trelleborg',300.50);
insert into contraderJSP.gomme (model, manufacturer, price)
values ('Pirelli Hard','Pirelli',50.50);
insert into contraderJSP.gomme (model, manufacturer, price)
values ('Pirelli Soft','Pirelli',150.50);
insert into contraderJSP.gomme (model, manufacturer, price)
values ('Pirelli Ultra-Soft','Pirelli',134.50);

insert into contraderJSP.vehicle (brand, model, fuel)
values ('Fiat','Punto','Diesel');
insert into contraderJSP.vehicle (brand, model, fuel)
values ('Bugatti','EB 110','Benzina');
insert into contraderJSP.vehicle (brand, model, fuel)
values ('Ferrari','California','Benzina');
insert into contraderJSP.vehicle (brand, model, fuel)
values ('Mercedes','Classe A','Diesel');
insert into contraderJSP.vehicle (brand, model, fuel)
values ('Honda','Logo','Benzina');

insert into contraderJSP.compatibility (idVehicle, idGomme)
values (1,2);
insert into contraderJSP.compatibility (idVehicle, idGomme)
values (1,6);
insert into contraderJSP.compatibility (idVehicle, idGomme)
values (2,6);
insert into contraderJSP.compatibility (idVehicle, idGomme)
values (3,2);
insert into contraderJSP.compatibility (idVehicle, idGomme)
values (4,6);
insert into contraderJSP.compatibility (idVehicle, idGomme)
values (4,2);