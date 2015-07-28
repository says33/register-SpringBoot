package com.mx.controller

import com.mx.domain.CurrentUser
import org.springframework.security.core.Authentication
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping


@ControllerAdvice
class CurrentUserControllerAdvice {
  
  @ModelAttribute("currentUser")
  CurrentUser getCurrentUser(Authentication authentication) {
    (authentication == null) ? null : (CurrentUser) authentication.getPrincipal()
  }


}