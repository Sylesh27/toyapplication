package com.example.demo.Controller; 
 
import com.example.demo.model.Order; 
import com.example.demo.Service.OrderService; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.*; 
 
import java.util.List; 
import java.util.Optional; 
 
@RestController 
@RequestMapping 
public class OrderController { 
 
    @Autowired 
    private OrderService orderService; 
 
    @GetMapping("/api/orders/get") 
    public List<Order> getAllOrders() { 
        return orderService.getAllOrders(); 
 
    } 
 
    @GetMapping("/api/orders/get/{id}") 
    public Optional<Order> getOrderById(@PathVariable Long id) { 
        return orderService.getOrderById(id); 
    } 
 
    @PostMapping("/api/orders/add") 
    public Order createOrder(@RequestBody Order order) { 
        return orderService.createOrder(order); 
    } 
 
    @PutMapping("/api/orders/put/{id}") 
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order) { 
        return orderService.updateOrder(id, order); 
    } 
 
    @DeleteMapping("/api/orders/del/{id}") 
    public String deleteOrder(@PathVariable Long id) { 
        orderService.deleteOrder(id); 
        return "Order deleted successfully"; 
    } 
} 

