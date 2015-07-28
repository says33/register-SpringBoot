package com.mx.service

import com.mx.domain.*
import java.util.Optional


public interface UserService {

    Optional<User> getUserById(long id)

	Optional<User> getUserByUsername(String username)

    Optional<User> getAllUsers()

    User create(UserCommand command)

}
