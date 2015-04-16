
CREATE TABLE RawMatarialType (
                id_raw_material_type INT AUTO_INCREMENT NOT NULL,
                raw_material_type_name VARCHAR(55) NOT NULL,
                PRIMARY KEY (id_raw_material_type)
);


CREATE UNIQUE INDEX rawmatarialtype_idx
 ON RawMatarialType
 ( raw_material_type_name );

CREATE TABLE OrderStatusType (
                id_order_status_type INT AUTO_INCREMENT NOT NULL,
                order_status_name VARCHAR(55) NOT NULL,
                PRIMARY KEY (id_order_status_type)
);


CREATE TABLE RawMatarial (
                id_raw_matarial INT AUTO_INCREMENT NOT NULL,
                id_raw_material_type INT NOT NULL,
                raw_material_amount INT NOT NULL,
                per_unit_price DOUBLE PRECISION NOT NULL,
                PRIMARY KEY (id_raw_matarial)
);


CREATE TABLE OrderStatus (
                id_order_status INT AUTO_INCREMENT NOT NULL,
                id_order_status_type INT NOT NULL,
                PRIMARY KEY (id_order_status)
);


CREATE TABLE ProductType (
                id_product_type INT AUTO_INCREMENT NOT NULL,
                product_type_name VARCHAR(55) NOT NULL,
                PRIMARY KEY (id_product_type)
);


CREATE UNIQUE INDEX producttype_unique
 ON ProductType
 ( product_type_name );

CREATE TABLE ProductInfo (
                id_product INT AUTO_INCREMENT NOT NULL,
                product_name VARCHAR(55) NOT NULL,
                id_product_type INT NOT NULL,
                product_price DOUBLE PRECISION NOT NULL,
                product_image VARCHAR(200),
                PRIMARY KEY (id_product)
);


CREATE UNIQUE INDEX productinfo_unique
 ON ProductInfo
 ( product_name, id_product_type );

CREATE TABLE OrderType (
                id_order_type INT AUTO_INCREMENT NOT NULL,
                order_name VARCHAR(55) NOT NULL,
                PRIMARY KEY (id_order_type)
);


CREATE UNIQUE INDEX ordertype_unique
 ON OrderType
 ( order_name );

CREATE TABLE UserType (
                id_user_type INT AUTO_INCREMENT NOT NULL,
                user_type_name VARCHAR(55) NOT NULL,
                PRIMARY KEY (id_user_type)
);


CREATE UNIQUE INDEX usertype_uniqe
 ON UserType
 ( user_type_name );

CREATE TABLE User (
                id_user INT AUTO_INCREMENT NOT NULL,
                user_name VARCHAR(55) NOT NULL,
                full_name VARCHAR(55) NOT NULL,
                user_email VARCHAR(55) NOT NULL,
                id_user_type INT NOT NULL,
                password VARCHAR(55) NOT NULL,
                company_name VARCHAR(55),
                PRIMARY KEY (id_user)
);


CREATE UNIQUE INDEX user_unique
 ON User
 ( user_email );

CREATE TABLE OrderInfo (
                id_order INT AUTO_INCREMENT NOT NULL,
                id_user INT NOT NULL,
                id_order_type INT NOT NULL,
                product_amount INT NOT NULL,
                order_estimated_date DATE NOT NULL,
                id_product INT NOT NULL,
                order_detail VARCHAR(500),
                id_order_status INT NOT NULL,
                PRIMARY KEY (id_order)
);


CREATE UNIQUE INDEX orderinfo_uniqe
 ON OrderInfo
 ( id_order, id_user );

ALTER TABLE RawMatarial ADD CONSTRAINT rawmatarialtype_rawmatarial_fk
FOREIGN KEY (id_raw_material_type)
REFERENCES RawMatarialType (id_raw_material_type)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE OrderStatus ADD CONSTRAINT orderstatustype_orderstatus_fk
FOREIGN KEY (id_order_status_type)
REFERENCES OrderStatusType (id_order_status_type)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE OrderInfo ADD CONSTRAINT orderstatus_orderinfo_fk
FOREIGN KEY (id_order_status)
REFERENCES OrderStatus (id_order_status)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE ProductInfo ADD CONSTRAINT producttype_productinfo_fk
FOREIGN KEY (id_product_type)
REFERENCES ProductType (id_product_type)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE OrderInfo ADD CONSTRAINT productinfo_orderinfo_fk
FOREIGN KEY (id_product)
REFERENCES ProductInfo (id_product)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE OrderInfo ADD CONSTRAINT ordertype_orderinfo_fk
FOREIGN KEY (id_order_type)
REFERENCES OrderType (id_order_type)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE User ADD CONSTRAINT usertype_user_fk
FOREIGN KEY (id_user_type)
REFERENCES UserType (id_user_type)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE OrderInfo ADD CONSTRAINT user_orderinfo_fk
FOREIGN KEY (id_user)
REFERENCES User (id_user)
ON DELETE CASCADE
ON UPDATE CASCADE;
