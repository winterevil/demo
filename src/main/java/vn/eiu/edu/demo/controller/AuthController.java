package vn.eiu.edu.demo.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.eiu.edu.demo.model.User;
import vn.eiu.edu.demo.service.UserService;

@Controller
public class AuthController {
    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    @PostMapping("/auth")
    public String doLogin(@ModelAttribute User user, HttpSession session, RedirectAttributes attributes) {
        User login = userService.findByUsername(user.getUsername());
        if (login == null) {
            attributes.addFlashAttribute("err", "You are not authorized to access this function!");
            attributes.addFlashAttribute("username", user.getUsername());
            return "redirect:/login";
        }
        if (!login.getPassword().equals(user.getPassword())) {
            attributes.addFlashAttribute("err", "You are not authorized to access this function!");
            attributes.addFlashAttribute("username", user.getUsername());
            return "redirect:/login";
        }

        session.setAttribute("user", login);
        return "redirect:/equipments";
    }

    @GetMapping("/logout")
    public String doLogout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }
}
