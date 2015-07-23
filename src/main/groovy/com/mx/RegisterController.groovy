package com.mx

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView

@Controller
@RequestMapping("/registers")
class RegisterController {

  @Autowired
  UserRepository repository

  @RequestMapping("/form")
  ModelAndView index() {
    new ModelAndView("registration/index")
  }

}
