package com.test.restApi.web

import com.test.restApi.business.IAccountBusiness
import com.test.restApi.exception.BusinessException
import com.test.restApi.exception.NotFoundException
import com.test.restApi.model.Account
import com.test.restApi.utils.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(Constants.URL_BASE_ACCOUNT)
class AccountRestController {

    @Autowired
    var accountBusiness: IAccountBusiness? = null

    @GetMapping("")
    fun list(): ResponseEntity<List<Account>> {
        return try{
            ResponseEntity(accountBusiness!!.list(), HttpStatus.OK)
        }catch(e:Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{id}")
    fun load(@PathVariable("id") idAccount:Int): ResponseEntity<Account>{
        return try{
            ResponseEntity(accountBusiness!!.load(idAccount), HttpStatus.OK)
        }catch(e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch(e: NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("")
    fun insert(@RequestBody account: Account):ResponseEntity<Any>{
        return try{
            accountBusiness!!.save(account)
            val responseHeader = HttpHeaders()
            responseHeader.set("location",Constants.URL_BASE_ACCOUNT + "/" + account.clave)
            ResponseEntity(responseHeader, HttpStatus.CREATED)
        }catch(e:BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping("")
    fun update(@RequestBody account: Account):ResponseEntity<Any>{
        return try{
            accountBusiness!!.save(account)
            ResponseEntity(HttpStatus.OK)
        }
        catch(e:BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") idAccount: Int): ResponseEntity<Any>{
        return try{
            accountBusiness!!.remove(idAccount)
            ResponseEntity(HttpStatus.OK)
        }catch(e:BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch(e:NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}