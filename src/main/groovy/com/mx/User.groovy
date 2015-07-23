package com.mx

import javax.persistence.*

@Entity
class User {

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  Long id
  String username
  String password
  String firstName
  String lastName

}
