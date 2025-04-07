package com.example.demo.Repository; 
import com.example.demo.model.Order; 
 
import org.springframework.data.jpa.repository.JpaRepository; 
 
public interface OrderRepository extends JpaRepository<Order, Long> { 
}