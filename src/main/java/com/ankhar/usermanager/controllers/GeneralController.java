package com.ankhar.usermanager.controllers;

import com.ankhar.usermanager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class GeneralController {
    private final UserService userService;

    @Autowired
    public GeneralController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"/", "/list"})
    public String getHomePage(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "list";
    }

    @RequestMapping("/delete")
    public String deleteUser(@RequestParam long id) {
        userService.deleteById(id);
        return "redirect:/list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editUser(@RequestParam long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "user";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createUser(Model model) {
//        model.addAttribute("user", userService.initializeNewUser());
        return "new";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String updateUser(@RequestParam(name = "id") Long id,
                             @RequestParam(name = "name") String name,
                             @RequestParam(name = "title") String title,
                             @RequestParam(name = "secureNumber") Long code) {
        userService.updateUser(id, name, title, code);
        return "redirect:list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String persistNewUser(@RequestParam(name = "name") String name,
                                 @RequestParam(name = "title") String title,
                                 @RequestParam(name = "secureNumber") Long code) {
        userService.createUser(name, title, code);
        return "redirect:list";
    }
}
