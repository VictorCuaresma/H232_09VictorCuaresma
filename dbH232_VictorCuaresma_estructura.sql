use master;

-- Eliminación de una base de datos si existe
IF EXISTS (SELECT name FROM master.dbo.sysdatabases WHERE name = 'dbH232')
BEGIN
    DROP DATABASE dbH232;
END

CREATE DATABASE dbH232;
use dbH232;
--TABLAS

--TABLA area
CREATE TABLE area (
    id int identity(1,1) NOT NULL,
    area_name varchar(90)  NOT NULL, -- solo letras 
    nombre varchar(80)  NOT NULL, -- solo letras
    apellidos varchar(80)  NOT NULL, -- solo letras
);

--TABLA estate
CREATE TABLE estate (
    Amount int  NOT NULL , -- solo que permita numeros enteros
    Code char(7)  NOT NULL , -- solo que sea unico
    Details_Goods varchar(250)  NOT NULL , -- que tenga un limite de 250
    admission_date date  NOT NULL, 
    date_depreciation date  NOT NULL ,
    state char(4)  NOT NULL , --solo acepte BAJA Y ALTA CON ESPACIOS 
    area_id int  NOT NULL ,
    CONSTRAINT estate_pk PRIMARY KEY (Code)
);

--TABLA goods_detail
CREATE TABLE goods_detail (
    id int  NOT NULL,
    worth decimal(8,2)  NOT NULL, -- solo permite numeros con decimales 
    annual_depreciation decimal(8,2)  NOT NULL,  -- solo permite numero con puntos y comas
    monthly_depreciation decimal(8,2)  NOT NULL ,-- solo permite numero con puntos y comas
    accumulated_depreciation decimal(8,2)  NOT NULL ,-- solo permite numero con puntos y comas
    estate_Code int  NOT NULL, 
    CONSTRAINT goods_detail_pk PRIMARY KEY (id)
);
