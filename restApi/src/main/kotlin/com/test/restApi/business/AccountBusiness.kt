package com.test.restApi.business

import com.test.restApi.dao.AccountRepository
import com.test.restApi.exception.BusinessException
import com.test.restApi.exception.NotFoundException
import com.test.restApi.model.Account
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class AccountBusiness:IAccountBusiness {

    @Autowired
    var accountRepository: AccountRepository? = null

    @Throws(BusinessException::class)
    override fun list(): List<Account> {
        try{
            return accountRepository!!.findAll()
        }catch(e:Exception){
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun load(idAccount: Int): Account {
        val op: Optional<Account>
        try{
            op = accountRepository!!.findById(idAccount)
        }catch(e:Exception){
            throw BusinessException(e.message)
        }
        if(!op.isPresent){
            throw NotFoundException("Not found account whit id $idAccount")
        }
        return op.get()
    }

    @Throws(BusinessException::class)
    override fun save(account: Account): Account {
        try {
            return accountRepository!!.save(account)
        }catch(e:Exception){
            throw BusinessException(e.message)
        }
    }

    override fun remove(idAccount: Int) {
        val op:Optional<Account>
        try{
            op=accountRepository!!.findById(idAccount)
        }catch(e:Exception){
            throw BusinessException(e.message)
        }
        if(!op.isPresent){
            throw NotFoundException("Not found account whit id $idAccount")
        }else{
            try{
                accountRepository!!.deleteById(idAccount)
            }catch(e:Exception){
                throw BusinessException(e.message)
            }
        }
    }
}