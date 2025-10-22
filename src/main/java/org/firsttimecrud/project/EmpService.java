package org.firsttimecrud.project;

import java.util.List;

//The question is why we use interface here?
//Ans: An interface in Java is used to define a contract that classes can implement. It allows for abstraction and defines a set of methods that must be implemented by any class that implements the interface.
// This promotes loose coupling and enables polymorphism, allowing different classes to be treated uniformly based on the interface they implement.
// In this case, EmpService interface defines the methods for creating, reading, and deleting employees, which can be implemented by different classes to provide specific functionality.
// It also helps in achieving separation of concerns and makes the code more modular and testable.
//Using interface we can achieve multiple inheritance in Java as a class can implement multiple interfaces.

//Still the same interface – defines the contract: create, read, delete employees.
public interface EmpService {
    String createEmployee (Employee employee);
    List<Employee>readEmployees();
    boolean deleteEmployee(Long id);
    String updateEmployee(Long id, Employee employee);
    Employee getEmployeeById(Long id);
}
