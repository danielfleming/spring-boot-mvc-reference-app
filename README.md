# spring-boot-mvc-reference-app
Reference application for a Spring MVC app running in Spring Boot

In order to run the application you will need to setup the database.  Use the following instructions:

1. Create a new database named "testdb"

2. Run the following script to setup the tables and sequences

```DROP SCHEMA IF EXISTS testdb cascade; 
CREATE SCHEMA testdb; 
ALTER SCHEMA testdb OWNER TO testdb;

CREATE SEQUENCE testdb.customer_id_seq;

CREATE TABLE testdb.customers ( customer_id BIGINT NOT NULL DEFAULT nextval('testdb.customer_id_seq'), 
	first_name VARCHAR NOT NULL, 
	last_name VARCHAR NOT NULL, 
	address VARCHAR NOT NULL, 
	city VARCHAR NOT NULL,
	state VARCHAR NOT NULL,
	postal_code VARCHAR NOT NULL,
	phone_number VARCHAR NOT NULL,
	CONSTRAINT customers_pk PRIMARY KEY (customer_id) );

ALTER SEQUENCE testdb.customer_id_seq OWNED BY testdb.customers.customer_id;

INSERT INTO testdb.customers VALUES(nextval('testdb.customer_id_seq'), 'John', 'Smith', '1212 Main Street', 'Los Angeles', 'CA', '90210', '205-555-1212');
```

3. Once you have created your database then modify /src/main/resources/application.properties and set your connection parameters

4. Run the src/main/java/org/domain/Application class to run the program in Spring Boot

5. Navigate your browser to http://localhost:8080/customers
