package com.mx.service

import com.mx.domain.*

public interface UserService {

    Collection<User> getUserById(long id)

		User getUserByUsername(String username)

    Collection<User> getAllUsers()

    User create(UserCommand command)

}
