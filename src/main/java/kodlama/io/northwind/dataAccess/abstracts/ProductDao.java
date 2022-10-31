package kodlama.io.northwind.dataAccess.abstracts;

import kodlama.io.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer>{
    @Query(
            value = "SELECT * FROM products ORDER BY product_name",
            countQuery = "SELECT count(*) FROM products",
            nativeQuery = true)
    List<Product> findAllProductsOrderByName();

}
