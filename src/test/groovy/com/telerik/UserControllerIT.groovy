package com.telerik

import com.telerik.jpa.User
import com.telerik.jpa.UserRepository
import com.telerik.service.UserService
import org.hamcrest.CoreMatchers
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath


@AutoConfigureMockMvc
//@ContextConfiguration(classes = [UserController, UserService])
//@WebMvcTest
@SpringBootTest
class UserControllerIT {

  @Autowired
  MockMvc mockMvc

  @Autowired
  UserRepository userRepository

  @Autowired
  UserService userService

  User user

  @BeforeEach
  void setUp() {
    user = new User(login: 'testUser')


    user = userRepository.save(user)
  }


  @AfterEach
  void cleanUp() {
    userRepository.deleteById(user.id)
  }

  @Test
  void userById() {
    mockMvc.perform(MockMvcRequestBuilders.get("/user/${user.id}")
      .contentType(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
      .andExpect(jsonPath('$.login', CoreMatchers.is(user.login)))

  }

  @Test
  void failure() {
    assert true
  }

}
