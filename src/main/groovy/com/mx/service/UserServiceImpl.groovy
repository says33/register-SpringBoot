package com.mx.service

import com.mx.domain.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository

    @Override
    Collection<User> getUserById(long id) {
      userRepository.findOne(id)
    }

    @Override
    Collection<User> getUserByUsername(String username) {
      userRepository.findOneByUsername(username);
    }

    @Override
    Collection<User> getAllUsers() {
      userRepository.findAll()
    }

    @Override
    User create(UserCommand command) {
      User user = new User()
      user.username = command.username
      user.password = new BCryptPasswordEncoder().encode(command.password)
      user.role = Role.USER
      user.firstName = command.firstName
      user.lastName = command.lastName
      userRepository.save(user)
    }

}
