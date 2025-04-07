package com.example.demo.Controller; 
 
 
import com.example.demo.model.Toy; 
import com.example.demo.Service.ToyService; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.data.domain.Page; 
import org.springframework.data.domain.PageRequest; 
import org.springframework.data.domain.Sort; 
import org.springframework.web.bind.annotation.*; 
 
import java.util.List; 
import java.util.Optional; 
 
@RestController 
@RequestMapping 
public class ToyController { 
 
    @Autowired 
    private ToyService toyService; 
 
    //  Get all toys (with pagination & sorting) 
    @GetMapping("/api/toys/get") 
    public Page<Toy> getAllToys( 
            @RequestParam(defaultValue = "0") int page,      // Page number (starting from 0) 
            @RequestParam(defaultValue = "5") int size,      // Items per page 
            @RequestParam(defaultValue = "name") String sortBy,  // Sort by field (e.g., name, price) 
            @RequestParam(defaultValue = "asc") String order  // Sorting order: asc or desc 
    ) { 
        Sort.Direction sortDirection = order.equalsIgnoreCase("desc") ? Sort.Direction.DESC : 
Sort.Direction.ASC; 
        return toyService.getAllToys(PageRequest.of(page, size, Sort.by(sortDirection, sortBy))); 
 
    } 
 
    // Get toy by ID 
    @GetMapping("/api/toys/get/{id}") 
    public Optional<Toy> getToyById(@PathVariable Long id) { 
        return toyService.getToyById(id); 
    } 
 
    //  Add a new toy 
    @PostMapping("/api/toys/add") 
    public Toy createToy(@RequestBody Toy toy) { 
        return toyService.createToy(toy); 
    } 
 
    //  Update toy by ID 
    @PutMapping("/api/toys/put/{id}") 
    public Toy updateToy(@PathVariable Long id, @RequestBody Toy toy) { 
        return toyService.updateToy(id, toy); 
    } 
 
    // Delete toy by ID 
    @DeleteMapping("/api/toys/del/{id}") 
    public String deleteToy(@PathVariable Long id) { 
        toyService.deleteToy(id); 
        return "Toy deleted successfully"; 
    } 
 
    // Get toys by name (Case Insensitive Search) 
    @GetMapping("/api/toys/searchByName") 
    public List<Toy> getToysByName(@RequestParam String name) { 
 
        return toyService.getToysByName(name); 
    } 
 
    //  Get toys within a price range 
    @GetMapping("/api/toys/searchByPrice") 
    public List<Toy> getToysByPriceRange(@RequestParam double minPrice, 
@RequestParam double maxPrice) { 
        return toyService.getToysByPriceRange(minPrice, maxPrice); 
    } 
 
    // Get toys by category name 
    @GetMapping("/api/toys/searchByCategory") 
    public List<Toy> getToysByCategory(@RequestParam String categoryName) { 
        return toyService.getToysByCategory(categoryName); 
    } 
}