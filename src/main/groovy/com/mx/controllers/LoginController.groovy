package com.mx.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.stereotype.Controller
import org.springframework.web.servlet.ModelAndView

@Controller
class LoginController {

  @RequestMapping(value="/login", method=RequestMethod.GET)
  ModelAndView index(@RequestParam Collection<String> error){
    new ModelAndView("login/index", "error",error)
  }

}
