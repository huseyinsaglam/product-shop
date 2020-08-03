package com.example.productshop.controller;

import com.example.productshop.model.User;
import com.example.productshop.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class UserController {


     @Autowired
     UserServiceImpl userService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    //Jsp sayfasindaki modelAttribute ile ayni isimde olmalidi! yoksa exception verir!
    public String addLoginPage(@ModelAttribute("login") User user) {

        return "login";

    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    //Jsp sayfasindaki modelAttribute ile ayni isimde olmalidi! yoksa exception verir!
    public String addLoginPageSubmit(@ModelAttribute("login") @Valid User user, Model model, HttpServletRequest request) {


        try {
            User user1 = userService.getByUsernameAndPass(user.getUsername(),user.getPass());
            if(user1.getUsername().equals(user.getUsername()) || user1.getPass().equals(user.getPass()))
            {
                request.getSession().setAttribute("user",user1);
                return "redirect:/products/all";
            }
        }
        catch (Exception e)
        {
            model.addAttribute("message","Kullanici adi veya sifre yanlistir..");
            return "login";
        }

        return "redirect:/login";
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model,HttpServletRequest request) {
        request.getSession().setAttribute("user",null);
        return "redirect:/login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    //Jsp sayfasindaki modelAttribute ile ayni isimde olmalidi! yoksa exception verir!
    public String addRegisterPage(@ModelAttribute("register") User user) {
        System.out.println("addRegisterPage#get invoked!");

        return "register";

    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    //Jsp sayfasindaki modelAttribute ile ayni isimde olmalidi! yoksa exception verir!
    public String addRegisterPageSubmit(@ModelAttribute("register")  @Valid User user,Model model) {


        try {

            if(user==null || user.getUsername()==null || user.getPass()==null || user.getPass2()==null ||
                    user.getName()==null || user.getSurname()==null)
            {

                model.addAttribute("message","Bilgilerinizi eksik doldurdunuz..");
                return "register";
            }
        }
        catch (Exception e)
        {
            model.addAttribute("message","Bilgilerinizi eksik doldurdunuz..");
            return "register";
        }




        try {
            if(user.getUsername().equals(userService.getByUsername(user.getUsername()).getUsername()))
            {
                model.addAttribute("message","Bu username adli baska kullanici bulunmaktadir.");
                return "register";
            }

        }
        catch (Exception e)
        {
            boolean status = control(user);
            if(status == false)
            {
                System.out.println(user.toString());

                model.addAttribute("message", "Bilgilerinizi kontrol ediniz");

                return "register";

            }
        }

            userService.save(user);
            return "redirect:/login";

    }


    private boolean control(User user)
    {
        if(user.getPass2().equals(user.getPass()))
        {
            return true;
        }
        return false;

    }

}
