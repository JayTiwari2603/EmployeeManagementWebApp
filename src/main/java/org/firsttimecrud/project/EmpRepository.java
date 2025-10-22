//This class is database helper class.

package org.firsttimecrud.project;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


//Marks it as a Spring bean for auto-injection.
//What it does: Handles all database queries for EmpEntity.
@Repository

//JpaRepository<EmpEntity, Long>: Gives you ready-made methods like save(), findAll(), deleteById() without writing SQL.
public interface EmpRepository extends JpaRepository<EmpEntity, Long>{
    
    //List<EmpEntity> findByName(String name);
    //save , delete, findById, findAll are already present in JpaRepository
}
