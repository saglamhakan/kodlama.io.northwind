package kodlama.io.northwind.api.controllers;

import kodlama.io.northwind.business.abstracts.ProductService;
import kodlama.io.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    private ProductService productService;

    @GetMapping("/getall")
    public List<Product> getAll() {
        return this.productService.getAll();

    }
    @GetMapping("/getAllOrderByName")
    public List<Product> getAllOrderByName(){
        return this.productService.getAllOrderByName();
    }
    @PostMapping("/add")
    public String add(@RequestBody Product product){
        return this.productService.add(product);
    }
}
