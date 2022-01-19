package com.telerik.jpa

import org.hibernate.annotations.Type

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "user")
class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id

  String login
  String password
}
