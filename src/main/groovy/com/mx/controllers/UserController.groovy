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
import com.mx.domain.*

@Controller
class UserController {

  @Autowired
  UserRepository repository

  @RequestMapping(value="/form", method=RequestMethod.GET)
  String index(Model model) {
    model.addAttribute("user", new User())
    "user/index"
  }

  @RequestMapping(value="/User", method=RequestMethod.POST)
  String userSubmit(@ModelAttribute User user, Model model) {
    model.addAttribute("user", user)
  	"user/result"
  }

  @RequestMapping(value="/Users", method=RequestMethod.GET)
  ModelAndView getAllUser() {
    new ModelAndView("show","users",repository.findAll())
  }

}
