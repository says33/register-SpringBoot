package com.mx

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.stereotype.Controller

@Controller
class RegisterController {

  @RequestMapping(value="/form", method=RequestMethod.GET)
  String index(Model model) {
    model.addAttribute("user", new User())
    "registration/index"
  }

  @RequestMapping(value="/User", method=RequestMethod.POST)
  String userSubmit(@ModelAttribute User user, Model model) {
  	model.addAttribute("user", user)
  	"registration/result"
  }

}
