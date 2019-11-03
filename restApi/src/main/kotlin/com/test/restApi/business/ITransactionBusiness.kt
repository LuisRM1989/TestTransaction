package com.test.restApi.business

import com.test.restApi.model.Transaction

interface ITransactionBusiness {
    fun list():List<Transaction>
    fun sendByAccount(idTransaction:Int):List<Transaction>
    fun recivedByAccount(idTransaction:Int):List<Transaction>
    fun TransactionById(idTransaction:Int):Transaction
    fun save(transaction:Transaction):Transaction
    //fun remove(idTransaction:Int)
}