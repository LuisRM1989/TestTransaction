package com.test.restApi.dao

import com.test.restApi.model.Account
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository:JpaRepository<Account,Int> {
}