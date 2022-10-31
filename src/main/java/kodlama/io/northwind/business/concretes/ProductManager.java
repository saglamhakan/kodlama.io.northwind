package kodlama.io.northwind.business.concretes;

import kodlama.io.northwind.business.abstracts.ProductService;
import kodlama.io.northwind.dataAccess.abstracts.ProductDao;
import kodlama.io.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductManager implements ProductService {
    private ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAll() {
        return this.productDao.findAll();
    }

    @Override
    public List<Product> getAllOrderByName() {
        List<Product> productList= this.productDao.findAllProductsOrderByName();
        if (productList==null){
            return new ArrayList<Product>();
        }
        return productList;
    }

    @Override
    public String add(Product product) {
        if (product.getProductName().length()<3){
            return "Ürün ismi 3 harften az olamaz";
        }
        if (product.getUnitsInStock()<0){
            return "Stok adedi 0'dan küçük olamaz";
        }
        product.setProductId(0);
        this.productDao.save(product);
        return "Başarıyla eklendi";
    }



}
