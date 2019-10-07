package com.mmilak.controllers;

import com.mmilak.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("loggedUser")
public class LoginController {

    @PostMapping(value = "/login")
    public String postLogin(Model model, @ModelAttribute("user") User user) {

        model.addAttribute("loggedUser", user);
        return "redirect:user_page"; //odniesienie sie w linku do naszej strony user_page i wejdziemy tym samy w kontroller od user_page
        // jeśli by nie było redirect wtedy został by zwrócony tylko widok a sam kontroller nie był by zawołany. Tutaj chcemy żeby był
        // zawołany wiec robimy redirect.
    }

    @GetMapping(value = "/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }
}
