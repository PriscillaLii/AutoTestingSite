package sli.nonwork.AutoTesting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sli.nonwork.AutoTesting.model.Testing;
import sli.nonwork.AutoTesting.model.User;
import sli.nonwork.AutoTesting.service.SecurityService;
import sli.nonwork.AutoTesting.service.UserService;
import sli.nonwork.AutoTesting.validator.UserValidator;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/home";
    }
    
   

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password are invalid.");

        if (logout != null)
            model.addAttribute("message", "You have logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home(Model model) {
    		model.addAttribute("userForm", new User());
    		model.addAttribute("testingForm", new Testing());
        return "home";
    }
    
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model) {
    		//model.addAttribute("testingForm", new Testing());
        model.addAttribute("userForm", new User());

        return "userInfo";
    }
    
    @RequestMapping(value = "/userInfo", method = RequestMethod.POST)
    public ModelAndView userInfo(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {

    		ModelAndView mv = new ModelAndView();
    	
    		userValidator.validateChange(userForm, bindingResult);
    		if (!bindingResult.hasErrors()) {
    			mv.addObject("message", "Success!");
    		}
    		
        userService.update(userForm);

        mv.setViewName("userInfo");
		return mv;
    }
    
    @RequestMapping(value = "/createTesting", method = RequestMethod.GET)
    public String createTesting(Model model) {
        model.addAttribute("testingForm", new Testing());

        return "createTesting";
    }
    
    
}
