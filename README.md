# spring-boot-mvc-reference-app
Reference application for a Spring MVC app running in Spring Boot

In order to run the application you will need to setup the database.  Use the following instructions:

1. Create a new database named "testdb"

2. Run the following script to setup the tables and sequences

DROP SCHEMA IF EXISTS testdb cascade;
CREATE SCHEMA testdb;
ALTER SCHEMA testdb OWNER TO testdb;

CREATE SEQUENCE testdb.greeting_id_seq;

CREATE TABLE testdb.greetings (
                greeting_id BIGINT NOT NULL DEFAULT nextval('test.greeting_id_seq'),
                name VARCHAR NOT NULL,
                message VARCHAR NOT NULL,
                CONSTRAINT greetings_pk PRIMARY KEY (greeting_id)
);


ALTER SEQUENCE testdb.greeting_id_seq OWNED BY testdb.greetings.greeting_id;

INSERT INTO testdb.greetings VALUES(nextval('testdb.greeting_id_seq'), 'Hello World', 'Hello World!');

3. Once you have created your database then modify /src/main/resources/application.properties and set your connection parameters

4. Run the src/main/java/org/domain/Application class to run the program in Spring Boot

5. Navigate your browser to http://localhost:8080/greetings
