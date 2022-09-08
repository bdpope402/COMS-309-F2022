package com.springboot.app.user;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

//    //Hashmap of all employees
//    HashMap<String, User> employeeList = new HashMap<>();
//
//    //Returns a list of all employees using list operation
//    @GetMapping("/employee")
//    public @ResponseBody HashMap<String, User> getAllEmployees() {
//        return employeeList;
//    }
//
//
//    @PostMapping("/employee")
//    public @ResponseBody String createEmployee(@RequestBody User newEmployee) {
//        employeeList.put(newEmployee.getName(), newEmployee);
//        return "New employee " + newEmployee.getName() + " entered";
//    }
//
//    @GetMapping("/employee/{name}")
//    public @ResponseBody User getEmployee(@PathVariable String name) {
//        User e = employeeList.get(name);
//        return e;
//    }
//
//    // THIS IS THE UPDATE OPERATION
//    // We extract the person from the HashMap and modify it.
//    // Springboot automatically converts the Person to JSON format
//    // Springboot gets the PATHVARIABLE from the URL
//    // Here we are returning what we sent to the method
//    // in this case because of @ResponseBody
//    // Note: To UPDATE we use PUT method
//    @PutMapping("/employee/{name}")
//    public @ResponseBody User updateEmployee(@PathVariable String name, @RequestBody User e) {
//        employeeList.replace(name, e);
//        return employeeList.get(name);
//    }
//
//    // THIS IS THE DELETE OPERATION
//    // Springboot gets the PATHVARIABLE from the URL
//    // We return the entire list -- converted to JSON
//    // in this case because of @ResponseBody
//    // Note: To DELETE we use delete method
//    @DeleteMapping("/employee/{name}")
//    public @ResponseBody HashMap<String, User> deleteEmployee(@PathVariable String name) {
//        employeeList.remove(name);
//        return employeeList;
//    }

    //List of all users
    HashMap<String, User> userList = new HashMap<>();

    @GetMapping("/users")
    public HashMap<String, User> getUsers(){
        return userList;
    }

    @PostMapping("/users/create")
    public String createUser(@RequestParam String name, @RequestParam String role) {
        User newUser = new User(name, role);
        userList.put(newUser.getName(), newUser);
        return "New user " + newUser.getName() + " Added as " + newUser.getRole();
    }

    @PostMapping("/users/create2")
    public String createUser(@RequestBody User newUser) {
        userList.put(newUser.getName(), newUser);
        return "New user " + newUser.getName() + " Added as " + newUser.getRole();
    }

    @DeleteMapping()
    public String deleteUser() {
        return "HTTP Delete request was sent";
    }

    @PutMapping()
    public String updateUser() {
        return "HTTP Put request was sent";
    }
}
