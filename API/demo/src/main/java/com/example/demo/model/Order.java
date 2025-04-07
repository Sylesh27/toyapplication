package com.example.demo.model; 
 
import jakarta.persistence.*; 
import java.time.LocalDate;

 
@Entity 
@Table(name = "`order`")  // Escaping the table name 
public class Order { 
    @Id 
    //@GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id; 
 
    private LocalDate orderDate; 
 
    @ManyToOne 
    @JoinColumn(name = "customer_id") 
    private Customer customer; 
 
    // Getters and Setters 
    public Long getId() { 
        return id; 
    } 
 
    public void setId(Long id) { 
        this.id = id; 
    } 
 
    public LocalDate getOrderDate() { 
        return orderDate; 
 
    } 
 
    public void setOrderDate(LocalDate orderDate) { 
        this.orderDate = orderDate; 
    } 
 
    public Customer getCustomer() { 
        return customer; 
    } 
 
    public void setCustomer(Customer customer) { 
        this.customer = customer; 
    } 
} 
