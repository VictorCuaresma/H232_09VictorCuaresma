
-- REGISTROS A AREA

INSERT INTO area(area_name, nombre, apellidos)
VALUES ('Contabilidad', 'Juana Arenas', 'Castillas Sandoval');

INSERT INTO area(area_name, nombre, apellidos)
VALUES ('MARKETING', 'Jurenas', 'Castillas Sandoval');

INSERT INTO area(area_name, nombre, apellidos)
VALUES ('Contabilidad', 'Junas', 'Sandoval');

INSERT INTO area(area_name, nombre, apellidos)
VALUES ('MARKETING', 'Juana', 'Castillas Sandoval');

INSERT INTO area(area_name, nombre, apellidos)
VALUES ('Contabilidad', 'Arenas', 'Castillas Sandoval');

INSERT INTO area(area_name, nombre, apellidos)
VALUES ('PRODUCCION ARTE', 'Lucia', 'Castillas Sandoval');

select * from area;

-- REGISTROS A ESTATE

INSERT INTO estate(Amount, Code, Details_Goods , admission_date , date_depreciation , state ,  area_id)
VALUES ('1', 'EQ-001', 'Escritorio color gris','2023/02/01', '2023/12/31' , 'BAJA', '1');

INSERT INTO estate(Amount, Code, Details_Goods , admission_date , date_depreciation , state ,  area_id)
VALUES ('1', 'EQ-002', 'Escritorio color gris','2023/01/01', '2023/12/31' , 'BAJA', '2');

INSERT INTO estate(Amount, Code, Details_Goods , admission_date , date_depreciation , state ,  area_id)
VALUES ('1', 'EQ-003', 'Escritorio color verde','2023/02/28', '2023/12/31' , 'BAJA', '3');

INSERT INTO estate(Amount, Code, Details_Goods , admission_date , date_depreciation , state ,  area_id)
VALUES ('1', 'EQ-004', 'Escritorio color amarillo','2023/01/01', '2023/12/31' , 'ALTA', '4');

INSERT INTO estate(Amount, Code, Details_Goods , admission_date , date_depreciation , state ,  area_id)
VALUES ('1', 'EQ-005', 'Escritorio color rojo','2023/02/02', '2023/12/31' , 'ALTA', '5');

select * from estate;

-- REGISTROS A goods_detail
INSERT INTO goods_detail (id, worth, annual_depreciation, monthly_depreciation, accumulated_depreciation, estate_Code) 
VALUES (1, 800.00, 0.80, 0.07, 0.80, 1),
       (2, 800.00, 0.80, 0.07, 0.80, 2),
	   (3, 800.00, 0.80, 0.07, 0.80, 3),
	   (4,  800.00, 0.80, 0.07, 0.80, 4),
       (5,  800.00, 0.80, 0.07, 0.80, 5);

select * from goods_detail;

-- Restricciones permitiendo espacios en la tabla area
ALTER TABLE area
ADD CONSTRAINT CK_area_name CHECK (area_name NOT LIKE '%[^a-zA-Z ]%');

ALTER TABLE area
ADD CONSTRAINT CK_nombre CHECK (nombre NOT LIKE '%[^a-zA-Z ]%');

ALTER TABLE area
ADD CONSTRAINT CK_apellidos CHECK (apellidos NOT LIKE '%[^a-zA-Z ]%');


select * from area;


-- Restricciones para la tabla "estate"
ALTER TABLE estate
ADD CONSTRAINT CK_Amount CHECK (Amount = ROUND(Amount, 0)); -- solo permite números enteros

ALTER TABLE estate
ADD CONSTRAINT UQ_Code UNIQUE (Code); -- asegura que sea único

ALTER TABLE estate
ADD CONSTRAINT CK_Details_Goods CHECK (LEN(Details_Goods) <= 250); -- limita a 250 caracteres

ALTER TABLE estate
ADD CONSTRAINT CK_state CHECK (state IN ('BAJA', 'ALTA')); -- solo acepta "BAJA" y "ALTA" con espacios

select * from estate;


-- Restricciones para la tabla "goods_detail"
ALTER TABLE goods_detail
ADD CONSTRAINT CK_worth CHECK (worth = ROUND(worth, 2)); -- solo permite números con dos decimales

ALTER TABLE goods_detail
ADD CONSTRAINT CK_annual_depreciation CHECK (annual_depreciation = ROUND(annual_depreciation, 2)); -- solo permite números con dos decimales

ALTER TABLE goods_detail
ADD CONSTRAINT CK_monthly_depreciation CHECK (monthly_depreciation = ROUND(monthly_depreciation, 2)); -- solo permite números con dos decimales

ALTER TABLE goods_detail
ADD CONSTRAINT CK_accumulated_depreciation CHECK (accumulated_depreciation = ROUND(accumulated_depreciation, 2)); -- solo permite números con dos decimales

select * from goods_detail;
 

-- Actualización de registros en la tabla "estate" (eliminación lógica)
UPDATE estate
SET state = 'BAJA'
WHERE Code = 'EQ-005';

-- Actualización de registros en la tabla "area" (eliminación lógica)
UPDATE area
SET area_name = 'Recursos Humanos'
WHERE id = 6;

-- Actualización de registros en la tabla "goods_detail" (eliminación lógica)
UPDATE goods_detail
SET worth = 750.00
WHERE id = 5;

-- Consulta con WHERE y operadores lógicos
SELECT * FROM area WHERE area_name = 'Contabilidad' OR area_name = 'MARKETING';

-- Bloque de programación con IF
DECLARE @totalAmount int;
SET @totalAmount = (SELECT SUM(Amount) FROM estate WHERE state = 'ALTA');

IF @totalAmount > 100000
BEGIN
    PRINT 'El total de los montos en estado ALTA es mayor a 100,000';
END
ELSE
BEGIN
    PRINT 'El total de los montos en estado ALTA es menor o igual a 100,000';
END

-- Bloque de programación con WHILE
DECLARE @counter int;
SET @counter = 1;

WHILE @counter <= 10
BEGIN
    PRINT 'El contador es: ' + CAST(@counter AS varchar(5));
    SET @counter = @counter + 1;
END


-- Ejemplo de cursor con las tablas existentes en SQL Server

DECLARE @id int;
DECLARE @area_name varchar(90);
DECLARE @nombre varchar(80);
DECLARE @apellidos varchar(80);

DECLARE area_cursor CURSOR FOR
SELECT id, area_name, nombre, apellidos
FROM area;

OPEN area_cursor;
FETCH NEXT FROM area_cursor INTO @id, @area_name, @nombre, @apellidos;

WHILE @@FETCH_STATUS = 0
BEGIN
    -- Realizar operaciones con los datos del cursor
    PRINT 'ID: ' + CAST(@id AS varchar(10)) + ', Area Name: ' + @area_name + ', Nombre: ' + @nombre + ', Apellidos: ' + @apellidos;

    FETCH NEXT FROM area_cursor INTO @id, @area_name, @nombre, @apellidos;
END

CLOSE area_cursor;
DEALLOCATE area_cursor;
