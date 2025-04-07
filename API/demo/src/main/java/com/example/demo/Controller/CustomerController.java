package com.example.demo.Controller; 
 
import com.example.demo.model.Customer; 
import com.example.demo.Service.CustomerService; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.*; 
import java.util.List; 
import java.util.Optional; 
@RestController 
@RequestMapping 
public class CustomerController { 
 
    @Autowired 
    private CustomerService customerService; 
    @GetMapping("/api/customers/get") 
    public List<Customer> getAllCustomers() { 
        return customerService.getAllCustomers(); 
    } 
 
 
    @GetMapping("/api/customers/get/{id}") 
    public Optional<Customer> getCustomerById(@PathVariable Long id) { 
        return customerService.getCustomerById(id); 
    } 
 
    @PostMapping("/api/customers/add") 
    public Customer createCustomer(@RequestBody Customer customer) { 
        return customerService.createCustomer(customer); 
    } 
 
    @PutMapping("/api/customers/put/{id}") 
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer 
customer) { 
        return customerService.updateCustomer(id, customer); 
    } 
 
    @DeleteMapping("/api/customers/del/{id}") 
    public String deleteCustomer(@PathVariable Long id) { 
        customerService.deleteCustomer(id); 
        return "Customer deleted successfully"; 
    } 
}