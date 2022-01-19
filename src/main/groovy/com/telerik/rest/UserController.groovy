package com.telerik.rest

import com.telerik.jpa.User
import com.telerik.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {

  @Autowired
  UserService userService

  @GetMapping("/user/{id}")
  User getUserById(@PathVariable('id') Long id) {
    userService.getUserById(id)
  }

  @GetMapping("/user/login/{login}")
  User getUserByLogin(@PathVariable ('login') String login) {
    userService.getUserByLogin(login)
  }
}
