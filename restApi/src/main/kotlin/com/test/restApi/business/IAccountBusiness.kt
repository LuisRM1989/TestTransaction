package com.test.restApi.business

import com.test.restApi.model.Account

interface IAccountBusiness {
    fun list():List<Account>
    fun load(idAccount:Int):Account
    fun save(account:Account):Account
    fun remove(idAccount:Int)
}