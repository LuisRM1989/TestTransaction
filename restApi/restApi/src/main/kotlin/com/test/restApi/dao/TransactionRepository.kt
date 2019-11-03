package com.test.restApi.dao

import com.test.restApi.model.Account
import com.test.restApi.model.Transaction
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface TransactionRepository:JpaRepository<Transaction,Int> {

    @Query("Select t from Transaction AS t where t.idAccountFrom = :param")
    fun findByIdAccountFrom(param:Int): List<Transaction>
    @Query("Select t from Transaction AS t where t.idAccountTo = :param")
    fun findByIdAccountTo(param:Int): List<Transaction>

}