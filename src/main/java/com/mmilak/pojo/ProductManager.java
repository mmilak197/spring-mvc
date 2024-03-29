package com.mmilak.pojo;

import com.mmilak.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductManager {

    private List<Product> products;

    public ProductManager(List<Product> products) {
        this.products = prepareProducts();
    }

    private List<Product> prepareProducts() {

        List<Product> products = new ArrayList<Product>();
        Product product = new Product("koszulki", "KoszulkaA");
        Product secondProduct = new Product("koszulki", "KoszulkaB");
        Product thirdProduct = new Product("spodnie", "Spodnie1");
        Product forthProduct = new Product("spodnie", "Spodnie2");
        Product fifthProduct = new Product("bluzy", "BluzaA");
        Product sixthProduct = new Product("bluzy", "KoszulkaA");

        products.add(product);
        products.add(secondProduct);
        products.add(thirdProduct);
        products.add(forthProduct);
        products.add(fifthProduct);
        products.add(sixthProduct);

        return products;
    }

    public List<Product> findAll() {

        return products;
    }

    public List<Product> findByCategory(final String categoryName) {

        return products.stream().filter(product -> categoryMatch(categoryName, product)).collect(Collectors.toList());
    }

    private boolean categoryMatch(String category, Product product) {
        String productCategory = product.getCategory();
        return category.equals(productCategory);
    }

    public List<String> getCategories() {
        List<String> result = new ArrayList<String>();
        result.add("koszulki");
        result.add("spodnie");

        return result;
    }
}
