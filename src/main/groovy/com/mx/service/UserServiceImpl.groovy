package com.mx.service

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository

    @Override
    Optional<User> getUserById(long id) {
      userRepository.findOne(id)
    }

    @Override
    Optional<User> getUserByEmail(String username) {
      userRepository.findOneByUsername(username);
    }

    @Override
    Collection<User> getAllUsers() {
      userRepository.findAll()
    }

    @Override
    User create(UserCommand command) {
      User user = new User()
      user.setEmail(command.username);
      user.setPasswordHash(new BCryptPasswordEncoder().encode(command.password))
      user.setRole(command.role)
      userRepository.save(user)
    }

}