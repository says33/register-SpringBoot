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
import com.mx.domain.UserCommand
import com.mx.domain.UserRepository
import com.mx.domain.validator.UserCreateFormValidator
import com.mx.service.UserService
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.validation.Valid;
import java.util.NoSuchElementException;

@Controller
class UserController {

  @Autowired
  UserRepository repository
  @Autowired
  UserService userService
  @Autowired
  UserCreateFormValidator userCreateFormValidator

  Logger LOGGER = LoggerFactory.getLogger(UserController.class);

  @InitBinder("form")
  void initBinder(WebDataBinder binder) {
    binder.addValidators(userCreateFormValidator);
  }

  @RequestMapping(value="/form", method=RequestMethod.GET)
  String index(Model model) {
    LOGGER.debug("index")
    model.addAttribute("user", new UserCommand())
    "user/index"
  }
  
  @RequestMapping(value="/User", method=RequestMethod.POST)
  String userSubmit(@Valid @ModelAttribute("form") UserCommand form, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      "user/index"
    }
    userService.create(user)
    "redirect:/Users"
  }

  @PreAuthorize("hasAuthority('USER')")
  @RequestMapping(value="/Users", method=RequestMethod.GET)
  ModelAndView getAllUser() {
    new ModelAndView("show","users",repository.findAll())
  }

}
