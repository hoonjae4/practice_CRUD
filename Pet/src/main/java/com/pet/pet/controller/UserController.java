package com.pet.pet.controller;

import com.pet.pet.model.User;
import com.pet.pet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping({"","/"})
    public String index(){
        return "index";
    }

    @PostMapping("/login")
    public String login(User user, HttpSession session) throws Exception{
        User principal = userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
        if(principal != null){
            session.setAttribute("principal",principal);
        }
        System.out.println(session);
        return "redirect:/";
    }
    @GetMapping({"/userList"})
    public String list(Model model){
        List<User> user = userRepository.findAll();
        model.addAttribute("user",user);
        return "userList";
    }
}
