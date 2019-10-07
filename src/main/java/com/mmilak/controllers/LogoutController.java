package com.mmilak.controllers;

import com.mmilak.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @GetMapping(value = "/logout")
    public String userPage(Model model, HttpSession session) {

        session.invalidate(); // powoduje wyczyszczenie wszystkich wartości w bieżącej sesji

        return "redirect:/"; //przeniesienie na stronę domowa oraz uruchominie odpowiedniego kontrollera
    }
}
