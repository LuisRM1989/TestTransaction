package com.test.restApi.business

import com.test.restApi.model.Owner

interface IOwnerBusiness {
    fun list():List<Owner>
    fun load(idOwner:Int):Owner
    fun save(owner:Owner): Owner
    fun remove(idOwner:Int)
}