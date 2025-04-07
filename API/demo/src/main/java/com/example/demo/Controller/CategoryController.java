package com.example.demo.Controller; 
 
import com.example.demo.model.Category; 
import com.example.demo.Service.CategoryService; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.*; 
 
import java.util.List; 
import java.util.Optional; 
 
@RestController 
@RequestMapping 
 
public class CategoryController { 
 
    @Autowired 
    private CategoryService categoryService; 
 
    @GetMapping("/api/categories/get") 
    public List<Category> getAllCategories() { 
        return categoryService.getAllCategories(); 
    } 
 
    @GetMapping("/api/categories/get/{id}") 
    public Optional<Category> getCategoryById(@PathVariable Long id) { 
        return categoryService.getCategoryById(id); 
    } 
 
    @PostMapping("/api/categories/add") 
    public Category createCategory(@RequestBody Category category) { 
        return categoryService.createCategory(category); 
    } 
 
    @PutMapping("/api/categories/put/{id}") 
    public Category updateCategory(@PathVariable Long id, @RequestBody Category 
category) { 
        return categoryService.updateCategory(id, category); 
    } 
 
    @DeleteMapping("/api/categories/del/{id}") 
    public String deleteCategory(@PathVariable Long id) { 
        categoryService.deleteCategory(id); 
        return "Category deleted successfully"; 
    } 
}
