package com.telerik.service

import com.telerik.jpa.User
import com.telerik.jpa.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserService {

  @Autowired
  UserRepository userRepository

  User getUserById(Long id) {
    userRepository.getUserById(id)
  }

  User getUserByLogin(String login) {
    userRepository.getUserByLogin(login)
  }
}
