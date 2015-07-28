 package com.mx.domain

import org.springframework.data.repository.PagingAndSortingRepository

interface UserRepository extends PagingAndSortingRepository<User,Long> {

	User findByUsername(String username)
}
