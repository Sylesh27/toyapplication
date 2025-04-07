package com.example.demo.Service; 
 
import com.example.demo.model.Toy; 
import com.example.demo.Repository.ToyRepository; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.data.domain.Page; 
import org.springframework.data.domain.Pageable; 
import org.springframework.stereotype.Service; 
 
import java.util.List; 
import java.util.Optional; 
 
 
@Service 
public class ToyService { 
 
    @Autowired 
    private ToyRepository toyRepository; 
 
    // Get all toys with pagination and sorting 
    public Page<Toy> getAllToys(Pageable pageable) { 
        return toyRepository.findAll(pageable); 
    } 
 
    //  Get toy by ID 
    public Optional<Toy> getToyById(Long id) { 
        return toyRepository.findById(id); 
    } 
 
    // Add a new toy 
    public Toy createToy(Toy toy) { 
        return toyRepository.save(toy); 
    } 
 
    //  Update toy by ID 
    public Toy updateToy(Long id, Toy toy) { 
        Optional<Toy> existingToy = toyRepository.findById(id); 
        if (existingToy.isPresent()) { 
            Toy updatedToy = existingToy.get(); 
            updatedToy.setName(toy.getName()); 
            updatedToy.setPrice(toy.getPrice()); 
            updatedToy.setCategory(toy.getCategory()); 
 
            return toyRepository.save(updatedToy); 
        } 
        return null;  // Or throw an exception if the toy doesn't exist 
    } 
 
    //  Delete toy by ID 
    public void deleteToy(Long id) { 
        toyRepository.deleteById(id); 
    } 
 
    //  Get toys by name (Case Insensitive Search) 
    public List<Toy> getToysByName(String name) { 
        return toyRepository.findByNameContainingIgnoreCase(name); 
    } 
 
    // Get toys within a price range 
    public List<Toy> getToysByPriceRange(double minPrice, double maxPrice) { 
        return toyRepository.findByPriceBetween(minPrice, maxPrice); 
    } 
 
    // Get toys by category name 
    public List<Toy> getToysByCategory(String categoryName) { 
        return toyRepository.findByCategoryName(categoryName); 
    } 
} 