package com.telerik.jpa

//import org.springframework.data.repository.CrudRepository
//import org.springframework.stereotype.Repository

//@Repository
interface UserRepository {
//  extends CrudRepository<User, String> {

  User getUserById(String id)
  User getUserByLogin(String login)
}
