package com.test.restApi.web

import com.test.restApi.business.ITransactionBusiness
import com.test.restApi.exception.BusinessException
import com.test.restApi.exception.NotFoundException
import com.test.restApi.model.Transaction
import com.test.restApi.utils.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(Constants.URL_BASE_TRANSACTION)
class TransactionRestController {

    @Autowired
    var transactionBusiness: ITransactionBusiness? = null

    @GetMapping("")
    fun list(): ResponseEntity<List<Transaction>> {
        return try{
            ResponseEntity(transactionBusiness!!.list(), HttpStatus.OK)
        }catch(e:Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{id}")
    fun transactionById(@PathVariable("id") idTransaction:Int): ResponseEntity<Transaction>{
        return try{
            ResponseEntity(transactionBusiness!!.TransactionById(idTransaction), HttpStatus.OK)
        }catch(e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch(e: NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @GetMapping("/send/{id}")
    fun SendByAccount(@PathVariable("id") idTransaction:Int):  ResponseEntity<List<Transaction>> {
        return try{
            ResponseEntity(transactionBusiness!!.sendByAccount(idTransaction), HttpStatus.OK)
        }catch(e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch(e: NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @GetMapping("/recibe/{id}")
    fun RecivedByAccount(@PathVariable("id") idTransaction:Int):  ResponseEntity<List<Transaction>> {
        return try{
            ResponseEntity(transactionBusiness!!.recivedByAccount(idTransaction), HttpStatus.OK)
        }catch(e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch(e: NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("")
    fun insert(@RequestBody transaction: Transaction):ResponseEntity<Any>{
        return try{
            transactionBusiness!!.save(transaction)
            val responseHeader = HttpHeaders()
            responseHeader.set("location",Constants.URL_BASE_TRANSACTION + "/" + transaction.idTransaction)
            ResponseEntity(responseHeader, HttpStatus.CREATED)
        }catch(e:BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

}