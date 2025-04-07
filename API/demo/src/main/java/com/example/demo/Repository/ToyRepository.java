package com.example.demo.Repository; 
 
import com.example.demo.model.Toy; 
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.data.jpa.repository.Query; 
import org.springframework.data.repository.query.Param; 
 
 
import java.util.List; 
 
public interface ToyRepository extends JpaRepository<Toy, Long> { 
 
    // Find toys by name (Case Insensitive) 
    @Query("SELECT t FROM Toy t WHERE LOWER(t.name) LIKE LOWER(CONCAT('%', :name, '%'))") 
    List<Toy> findByNameContainingIgnoreCase(@Param("name") String name); 
 
    // Find toys within a price range 
 
     
    @Query("SELECT t FROM Toy t WHERE t.price BETWEEN :minPrice AND :maxPrice") 
    List<Toy> findByPriceBetween(@Param("minPrice") double minPrice, @Param("maxPrice") 
double maxPrice); 
  
    //  Find toys by category name 
    @Query("SELECT t FROM Toy t WHERE t.category.name = :categoryName") 
    List<Toy> findByCategoryName(@Param("categoryName") String categoryName); 
} 
