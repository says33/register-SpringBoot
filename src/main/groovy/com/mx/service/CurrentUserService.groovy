package com.mx.service

import com.mx.domain.CurrentUser

interface CurrentUserService {
	
	boolean canAccessUser(CurrentUser currentUser, Long userId)
}