package com.example.demo.Repository; 
import com.example.demo.model.Customer; 
import org.springframework.data.jpa.repository.JpaRepository; 
 
public interface CustomerRepository extends JpaRepository<Customer, Long> { 
} 