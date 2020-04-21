package com.pinhost.discountticketcondition.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Locale;


@Controller
public class LoginControllerHtml {

    @Autowired
    private MessageSource messageSource;

    @GetMapping({"/api/login","/"})
    public String getLogin(Model model,
                           Authentication authentication,
                           HttpServletRequest request,
                           Locale locale){

        if(authentication != null) {
            System.out.println("Hola usuario autenticado, tu username es: ".concat(authentication.getName()));
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if(auth != null) {
            System.out.println("Utilizando forma estática SecurityContextHolder.getContext().getAuthentication(): Usuario autenticado: ".concat(auth.getName()));
        }

        SecurityContextHolderAwareRequestWrapper securityContext = new SecurityContextHolderAwareRequestWrapper(request, "");

        if(securityContext.isUserInRole("ROLE_DiscountTicket")) {
            System.out.println("Forma usando SecurityContextHolderAwareRequestWrapper: Hola ".concat(auth.getName()).concat(" tienes acceso!"));
        } else {
            System.out.println("Forma usando SecurityContextHolderAwareRequestWrapper: Hola ".concat(auth.getName()).concat(" NO tienes acceso!"));
        }

        return "tickets";
    }

    @GetMapping("/login")
    public String login(@RequestParam(value="error", required=false) String error,
                        @RequestParam(value="logout", required = false) String logout,
                        Model model, Principal principal, RedirectAttributes flash, Locale locale) {

        if(principal != null) {
            flash.addFlashAttribute("info", messageSource.getMessage("text.login.already", null, locale));
            return "redirect:/";
        }

        if(error != null) {
            model.addAttribute("error", messageSource.getMessage("text.login.error", null, locale));
        }

        if(logout != null) {
            model.addAttribute("success", messageSource.getMessage("text.login.logout", null, locale));
        }

        return "login";
    }
}
