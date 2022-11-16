package com.pet.pet.controller;

import com.pet.pet.model.Take;
import com.pet.pet.model.User;
import com.pet.pet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping({"", "/"})
    public String index() {
        return "index";
    }

    @PostMapping("/login")
    public String login(User user, HttpSession session) throws Exception {
        User principal = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (principal != null) {
            session.setAttribute("principal", principal);
        }
        System.out.println(session);
        return "redirect:/";
    }

    @GetMapping({"/userList"})
    public String list(Model model) {
        List<User> user = userRepository.findAll();
        model.addAttribute("user", user);
        return "userList";
    }

    @GetMapping("/menual")
    public String menual(){
        return "menual";
    }

    @GetMapping("/userDetail/{id}")
    public String userDetail(@PathVariable int id,Model model){
        model.addAttribute("user",userRepository.findById(id));
        return "userDetail";
    }

    @PostMapping("/userDetail/authenticate")
    @Transactional
    public String authenticate(String id) throws Exception{
        int userId = Integer.parseInt(id);
        User tempUser = userRepository.findById(userId);
        tempUser.setIsAgreed(Take.O);

        System.out.println(tempUser.getIsAgreed());
        return "redirect:/userList";
    }

}

