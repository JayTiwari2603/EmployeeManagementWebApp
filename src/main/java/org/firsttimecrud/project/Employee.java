package org.firsttimecrud.project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Now the question is why we use Lombok annotations like @Data, @NoArgsConstructor, @AllArgsConstructor?
//Ans: Lombok annotations like @Data, @NoArgsConstructor, and @AllArgsConstructor are used to reduce boilerplate code in Java classes.
// @Data generates getters, setters, toString, equals, and hashCode methods.
// @NoArgsConstructor generates a no-argument constructor.
// @AllArgsConstructor generates a constructor with one parameter for each field in the class.

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Long id;
    private String name;
    private String role;
    private String email;
    private long phone;

    //The question is why we use private access modifier for fields?
    //Ans: We use private access modifier for fields to encapsulate the data and restrict direct access from outside the class.
    // This helps in maintaining data integrity and allows controlled access through methods (getters and setters)

    //Now the question is why we use getters and setters?
    //Ans: Getters and setters are used to provide controlled access to the private fields of a class.
    // They allow you to retrieve (get) and modify (set) the values of these fields while encapsulating the internal representation of the object.


    // getters and setters for email

    // public String getEmail() {
    //     return email;
    // }
    // public void setEmail(String email) {
    //     this.email = email;
    // }
    // // getters and setters for phone
    // public int getPhone() {
    //     return phone;
    // }
    // public void setPhone(int phone) {
    //     this.phone = phone;
    // }
    // // getters and setters for name
    // public String getName() {
    //     return name;
    // }
    // public void setName(String name) {
    //     this.name = name;
    // }
    // // getters and setters for role
    // public String getRole() {
    //     return role;
    // }
    // public void setRole(String role) {
    //     this.role = role;
    // }


}
