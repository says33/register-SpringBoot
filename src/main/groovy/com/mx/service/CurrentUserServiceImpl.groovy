package com.mx.service

import com.mx.domain.CurrentUser
import com.mx.domain.Role
import org.springframework.stereotype.Service

class CurrentUserServiceImpl implements CurrentUserService {
  
  @Override
  boolean canAccessUser(CurrentUser currentUser, Long userId){
    !currentUser && (currentUser.role == Role.ADMIN || currentUser.id.equals(userId))
  }

}