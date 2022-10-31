package kodlama.io.northwind.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name="products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private int productId;
    @Column(name="category_id")
    private int categoryId;
    @Column(name="product_name")
    private String productName;
    @Column(name="unit_price")
    private double unitPrice;
    @Column(name="units_in_stock")
    private short unitsInStock;
    @Column(name="quantity_per_unit")
    private String quantityPerUnit;



}