package com.example.crud.service;


import com.example.crud.entity.Product;
import com.example.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product){
        return repository.save(product);    // Save single product
    }

    public List<Product> saveProduct(List<Product> products) {
        return repository.saveAll(products);        // Save Multiple products
    }

        public List<Product> getProducts(){        // get Multiple products
            return  repository.findAll();
        }
        public  Product getProductById(int id) {   // get single product
            return repository.findById(id).orElse(null);
        }

        public  Product getProductByName(String name){   // get single product
               return repository.findByName(name);
        }
    public String deleteProduct(int id){
        repository.deleteById(id);
        return "Product Removed !! "+id;
    }
    public Product updateProduct(Product product){
        Product existingProduct=repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }

}
