package com.test.restApi.business

import com.test.restApi.dao.OwnerRepository
import com.test.restApi.exception.BusinessException
import com.test.restApi.exception.NotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import com.test.restApi.model.Owner
import java.util.*

@Service
class OwnerBusiness:IOwnerBusiness {

    @Autowired
    var ownerRepository: OwnerRepository? = null

    @Throws(BusinessException::class)
    override fun list(): List<Owner> {
        try{
            return ownerRepository!!.findAll()
        }catch(e:Exception){
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun load(idOwner: Int): Owner {
        val op: Optional<Owner>
        try{
            op = ownerRepository!!.findById(idOwner)
        }catch(e:Exception){
            throw BusinessException(e.message)
        }
        if(!op.isPresent){
            throw NotFoundException("Not found Owner whit id $idOwner")
        }
        return op.get()
    }

    @Throws(BusinessException::class)
    override fun save(owner: Owner): Owner {
        try {
            return ownerRepository!!.save(owner)
        }catch(e:Exception){
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun remove(idOwner: Int) {
        val op:Optional<Owner>
        try{
            op=ownerRepository!!.findById(idOwner)
        }catch(e:Exception){
            throw BusinessException(e.message)
        }
        if(!op.isPresent){
            throw NotFoundException("Not found owner whit id $idOwner")
        }else{
            try{
                ownerRepository!!.deleteById(idOwner)
            }catch(e:Exception){
                throw BusinessException(e.message)
            }
        }
    }
}