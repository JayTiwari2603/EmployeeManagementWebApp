package org.firsttimecrud.project;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

//Now the question is why we use JPA annotations like @Entity, @Table, @Id, @GeneratedValue?
//Ans: JPA annotations like @Entity, @Table, @Id, and @GeneratedValue are used to map Java classes to database tables
// and define the r elationships between them. @Entity indicates that the class is a JPA entity, @Table specifies the table name in the database,
// @Id marks the primary key field, and @GeneratedValue defines the strategy for generating primary key values automatically.

//Fields: id, name, role, email, phone. Lombok's @Data adds
@Data
//Tells Spring this class maps to a database table.
@Entity
//This is table name in MySQL.
@Table(name ="emp_entity")
public class EmpEntity {

    //Auto-generates unique IDs for each employee.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;
    private String role;
    private String email;
    private long phone;
}
