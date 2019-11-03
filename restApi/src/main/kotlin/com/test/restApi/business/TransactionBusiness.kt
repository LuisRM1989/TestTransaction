package com.test.restApi.business

import com.test.restApi.dao.AccountRepository
import com.test.restApi.dao.TransactionRepository
import com.test.restApi.exception.BusinessException
import com.test.restApi.exception.DataException
import com.test.restApi.exception.NotFoundException
import com.test.restApi.model.Account
import com.test.restApi.model.Transaction
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class TransactionBusiness:ITransactionBusiness {

    @Autowired
    var transactionRepository: TransactionRepository? = null

    @Autowired
    var accountRepository: AccountRepository? = null

    @Throws(BusinessException::class)
    override fun list(): List<Transaction> {
        try{
            return transactionRepository!!.findAll()
        }catch(e:Exception){
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class)
    override fun sendByAccount(idTransaction: Int): List<Transaction> {
        try{
            return transactionRepository!!.findByIdAccountFrom(idTransaction)
        }catch(e:Exception){
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class)
    override fun recivedByAccount(idTransaction: Int): List<Transaction> {
        try{
            return transactionRepository!!.findByIdAccountTo(idTransaction)
        }catch(e:Exception){
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun TransactionById(idTransaction: Int): Transaction {
        val op: Optional<Transaction>
        try{
            op = transactionRepository!!.findById(idTransaction)
        }catch(e:Exception){
            throw BusinessException(e.message)
        }
        if(!op.isPresent){
            throw NotFoundException("No se encontro persona con id $idTransaction")
        }
        return op.get()
    }

    @Throws(BusinessException::class)
    override fun save(transaction: Transaction): Transaction {
        try {
            if(transaction.idAccountFrom == transaction.idAccountTo )
                throw DataException("Introduce accounts diferents")
            else{
                val opFrom: Account = accountRepository!!.findById(transaction.idAccountFrom).get()
                val opTo: Account = accountRepository!!.findById(transaction.idAccountTo).get()
                if((opFrom.balance - transaction.amount) > -500){
                    opFrom.balance -=transaction.amount;
                    opTo.balance +=transaction.amount;
                    accountRepository!!.save(opFrom);
                    accountRepository!!.save(opTo)
                    return transactionRepository!!.save(transaction)
                }else
                    throw DataException("Amount is not correct!!!")
            }

        }catch(e:Exception){
            throw BusinessException(e.message)
        }
    }
}