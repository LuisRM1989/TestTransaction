package com.test.restApi.web

import com.test.restApi.business.IOwnerBusiness
import com.test.restApi.exception.BusinessException
import com.test.restApi.exception.NotFoundException
import com.test.restApi.model.Owner
import com.test.restApi.utils.Constants
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(Constants.URL_BASE_OWNER)
class OwnerRestController {

    @Autowired
    var ownerBusiness: IOwnerBusiness? = null

    @GetMapping("")
    fun list(): ResponseEntity<List<Owner>> {
        return try{
            ResponseEntity(ownerBusiness!!.list(), HttpStatus.OK)
        }catch(e:Exception){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @GetMapping("/{id}")
    fun load(@PathVariable("id") idOwner:Int): ResponseEntity<Owner>{
        return try{
            ResponseEntity(ownerBusiness!!.load(idOwner), HttpStatus.OK)
        }catch(e: BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch(e: NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @PostMapping("")
    fun insert(@RequestBody owner: Owner):ResponseEntity<Any>{
        return try{
            ownerBusiness!!.save(owner)
            val responseHeader = HttpHeaders()
            responseHeader.set("location",Constants.URL_BASE_OWNER + "/" + owner.id)
            ResponseEntity(responseHeader, HttpStatus.CREATED)
        }catch(e:BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @PutMapping("")
    fun update(@RequestBody owner:Owner):ResponseEntity<Any>{
        return try{
            ownerBusiness!!.save(owner)
            ResponseEntity(HttpStatus.OK)
        }
        catch(e:BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") idOwner: Int): ResponseEntity<Any>{
        return try{
            ownerBusiness!!.remove(idOwner)
            ResponseEntity(HttpStatus.OK)
        }catch(e:BusinessException){
            ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }catch(e:NotFoundException){
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}