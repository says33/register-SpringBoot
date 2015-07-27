package com.mx.service

import com.mx.domain.User
import com.mx.domain.CurrentUser
import com.mx.service.UserService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service

@Service
class CurrentUserDetailService implements UserDetailsService {
  private final UserService userService

  @Autowired
  CurrentUserDetailService(UserService userService) {
    this.userService = userService
  }

  @Override
  CurrentUser loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userService.getUserByUsername(username).orElseThrow{ ->
      new UsernameNotFoundException(String.format("User with email=%s was not found", user))
    }
    new CurrentUser(user)
  }

}
