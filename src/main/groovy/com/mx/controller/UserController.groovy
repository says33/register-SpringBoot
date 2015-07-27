package com.mx.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.ui.Model
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.stereotype.Controller
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.validation.BindingResult
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.*
import org.springframework.security.access.prepost.PreAuthorize
import com.mx.domain.*
import com.mx.domain.validator.UserCreateFormValidator
import com.mx.service.UserService
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
class UserController {

  @Autowired
  UserRepository repository
  @Autowired
  UserService userService
  @Autowired
  UserCreateFormValidator userCreateFormValidator

  Logger LOGGER = LoggerFactory.getLogger(UserController.class);

  @RequestMapping(value="/form", method=RequestMethod.GET)
  String index(Model model) {
    LOGGER.debug("index")
    model.addAttribute("user", new UserCommand())
    "user/index"
  }
  
  @RequestMapping(value="/User", method=RequestMethod.POST)
  String userSubmit(@ModelAttribute UserCommand user, Model model) {
    userService.create(user)
    model.addAttribute("user", user)
  	"user/result"
  }

  @PreAuthorize("hasAuthority('USER')")
  @RequestMapping(value="/Users", method=RequestMethod.GET)
  ModelAndView getAllUser() {
    new ModelAndView("show","users",repository.findAll())
  }

}
