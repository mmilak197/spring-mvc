package com.mmilak.controllers;

import com.mmilak.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) throws IOException {



        List<Product> products = getProducts();

        model.addAttribute("products", products);
        model.addAttribute("nick", "Mateusz");

        //throw new IOException();  //do pokazania obsługi wyjatkow przez ControllerAdvice(ExceptionController)

        return "home";
    }

    private List<Product> getProducts() {
        List<Product> products = new ArrayList<Product>();
        Product product = new Product("koszulki", "Koszulka1");
        Product product2 = new Product("koszulki", "Koszulka2");
        Product product3 = new Product("spodnie", "Spodnie");
        Product product4 = new Product("spodnie", "Spodnie2");

        products.add(product);
        products.add(product2);
        products.add(product3);
        products.add(product4);

        return products;
    }


}
