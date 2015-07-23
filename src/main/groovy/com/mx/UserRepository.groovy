 package com.mx

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.repository.CrudRepository

interface UserRepository extends PagingAndSortingRepository<User,Long> {
}
