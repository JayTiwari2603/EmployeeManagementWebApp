package org.firsttimecrud.project;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.firsttimecrud.project.Employee;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




//The question is why we use @RestController and @RequestMapping annotations?
//Ans: @RestController is a specialized version of the @Controller annotation in Spring that combines @Controller and @ResponseBody.
// It is used to create RESTful web services and automatically serializes return objects into JSON or XML format.
// @RequestMapping is used to map web requests to specific handler classes or methods. It can be applied at the class level or method level to define the URL patterns that the controller will handle.

@CrossOrigin(origins = "http://localhost:3000", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/")

//The question is why we use List and ArrayList?
//Ans: List is an interface in Java that represents an ordered collection of elements. It allows duplicate elements and provides methods for accessing, adding, and removing elements.
// ArrayList is a concrete implementation of the List interface that uses a dynamic array to store elements. It provides fast random access to elements and is suitable for scenarios where frequent access and iteration are required.

public class EmpController {
    //EmpService empService = new EmpServiceImpl();

    //Dependency Injection
    //The question is why we use Dependency Injection here?
    //Ans: Dependency Injection (DI) is a design pattern used to implement Inversion of Control (IoC) in which the control of creating and managing dependencies is transferred from the class itself to an external entity, such as a framework or container.
    // This promotes loose coupling, enhances testability, and improves maintainability of the code.
    // In this case, the EmpService dependency is injected into the EmpController class, allowing it to use the service without being tightly coupled to its implementation.
    // This allows for easier testing, as different implementations of the EmpService can be injected during testing.
    @Autowired
    EmpService empService;



    //Now the question is why we use @GetMapping and @RequestParam annotations?
    //Ans: @GetMapping is a specialized version of the @RequestMapping annotation that is used to handle HTTP GET requests. It is a shortcut for @RequestMapping(method = RequestMethod.GET).
    @GetMapping("employees")
    public List<Employee> getAllEmployees() {
        return empService.readEmployees();    //call karra hai service ko
    }

    @GetMapping("employees/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return empService.getEmployeeById(id);   //call karra hai service ko
    }

    //Now the question is why we use @PostMapping and @RequestBody annotations?
    //Ans: @PostMapping is a specialized version of the @RequestMapping annotation that is used to handle HTTP POST requests. It is a shortcut for @RequestMapping(method = RequestMethod.POST).
    // @RequestBody is used to bind the HTTP request body to a Java object. It allows you to automatically deserialize JSON or XML data from the request body into a Java object.
    @PostMapping("employees")
    //
    public String createEmployee(@RequestBody Employee employee) {
        //TODO: process POST request
        //employees.add(employee);
        return empService.createEmployee(employee);  //call karra hai service ko to create employee
        
    }


    //Now the question is why we use @DeleteMapping and @PathVariable annotations?
    //Ans: @DeleteMapping is a specialized version of the @RequestMapping annotation that is used to handle HTTP DELETE requests. It is a shortcut for @RequestMapping(method = RequestMethod.DELETE).
    // @PathVariable is used to bind a URI template variable to a method parameter. It allows you to extract values from the URL and use them as method parameters.
   @DeleteMapping("employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        boolean removed = empService.deleteEmployee(id);
        if (removed) {
            return ResponseEntity.ok("Deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }
    }

    @PutMapping("employees/{id}")
    public String putMethodName(@PathVariable Long id, @RequestBody Employee employee) {
        //TODO: process PUT request
        
        return empService.updateEmployee(id, employee);     //call karra hai service ko
    }

    
    
}
