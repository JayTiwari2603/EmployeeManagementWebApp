package org.firsttimecrud.project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//The question is why we use implements keyword here?
//Ans: The implements keyword in Java is used by a class to implement an interface. It signifies that the class agrees to provide concrete implementations for all the abstract methods defined in the interface.
// This allows for abstraction and polymorphism, enabling different classes to be treated uniformly based on the interface they implement.
// In this case, EmpServiceImpl class implements the EmpService interface, providing specific implementations for the methods to create, read, and delete employees.
@Service
public class EmpServiceImpl implements EmpService{
    @Autowired
    private EmpRepository empRepository;

    //In-memory list to store employees
    List<Employee> employees= new ArrayList<>();
    //The question is why we use List and ArrayList here?
    //Ans: List is an interface in Java that represents an ordered collection of elements. It allows duplicate elements and provides methods for accessing, adding, and removing elements.
    // ArrayList is a concrete implementation of the List interface that uses a dynamic array to store elements. It provides fast random access to elements and is suitable for scenarios where frequent access and iteration are required.



    //createEmployee(): Converts Employee (DTO) to EmpEntity, saves to database via repository.save().
    @Override
    public String  createEmployee(Employee employee) {
        EmpEntity empEntity = new EmpEntity();
        BeanUtils.copyProperties(employee, empEntity);  //employee ki properties copy karra hai empEntity mein
        empRepository.save(empEntity);
        //employees.add(employee);
        return "saved successfully";
    }

    @Override
    public Employee getEmployeeById(Long id) {
        EmpEntity empEntity = empRepository.findById(id).get();
        Employee employee = new Employee();
        BeanUtils.copyProperties(empEntity, employee);
        return employee;
    }


    //readEmployees(): Gets all EmpEntity from database, converts back to Employee list (only name/email for now).
    @Override
    public List<Employee> readEmployees() {
        List<EmpEntity> empEntities = empRepository.findAll();
        List<Employee> employees = new ArrayList<>();
        
        for(EmpEntity empEntity : empEntities){
            Employee emp = new Employee();
            emp.setName(empEntity.getName());
            emp.setEmail(empEntity.getEmail());
            emp.setPhone(empEntity.getPhone());
            emp.setRole(empEntity.getRole());
            emp.setId(empEntity.getId());
            employees.add(emp);

        }
        return employees;
    }

    
    //deleteEmployee(): Still buggy – uses old in-memory list instead of repository.deleteById(id). Needs fixing!
    @Override
    public boolean deleteEmployee(Long id) {
        empRepository.deleteById(id);
        return true;
    }


    @Override
    public String updateEmployee(Long id, Employee employee) {
        EmpEntity existingEmployee = empRepository.findById(id).get();

        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setPhone(employee.getPhone());
        existingEmployee.setRole(employee.getRole());   
        
        empRepository.save(existingEmployee);

        return "updated successfully";
    }


    

    


}
