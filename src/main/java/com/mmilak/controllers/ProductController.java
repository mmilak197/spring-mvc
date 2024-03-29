package com.mmilak.controllers;

import com.mmilak.Product;
import com.mmilak.pojo.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class ProductController {

    @Autowired
    private ProductManager productManager;

    @GetMapping(value = "/products/{category}")
    public String controller(Model model, @PathVariable("category") String category,
                             @MatrixVariable(value = "sortBy", pathVar = "category", required = false) List<String> sortCriteria /*,
                             @RequestParam(value = "count", required = false, defaultValue = "1") String count*/) {

        List<Product> products;

        if(category.equals("ALL")) {
            products  = productManager.findAll();
        } else {
            products = productManager.findByCategory(category);
        }
        //List<Product> products = productManager.findAll();

        //products = getByCount(count, products);
        products = getSorted(products, sortCriteria);
        List<String> categories = productManager.getCategories();

        model.addAttribute("categories", categories);
        model.addAttribute("products", products);

        return "products";
    }

    private List<Product> getByCount(String count, List<Product> products) {
        List<Product> result = new ArrayList<>();
        Integer countAsInt = Integer.valueOf(count);
        IntStream.range(0, countAsInt).forEach(index -> result.add(products.get(index)));
        return  result;
    }

    private List<Product> getSorted(List<Product> products, List<String> sortCriterias) {

        if(sortCriterias == null) {
            return products;
        }

        Comparator<Product> comparator = null;
        if(sortCriterias.contains("name")) {
            comparator = Comparator.comparing(Product::getName);
        }
        if(sortCriterias.contains("name") && sortCriterias.contains("category")) {
            comparator = Comparator.comparing(Product::getName).thenComparing(Product::getCategory);
        }

        return products.stream().sorted(comparator).collect(Collectors.toList());
    }
}
