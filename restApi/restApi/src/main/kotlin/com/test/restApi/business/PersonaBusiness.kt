package com.test.restApi.business

import com.test.restApi.dao.PersonaRepository
import com.test.restApi.exception.BusinessException
import com.test.restApi.exception.NotFoundException
import com.test.restApi.model.Persona
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonaBusiness:IPersonaBusiness {

    @Autowired
    var personaRepository: PersonaRepository? = null

    @Throws(BusinessException::class)
    override fun list(): List<Persona> {
        try{
            return personaRepository!!.findAll()
        }catch(e:Exception){
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun load(idPersona: Long): Persona {
        val op: Optional<Persona>
        try{
            op = personaRepository!!.findById(idPersona)
        }catch(e:Exception){
            throw BusinessException(e.message)
        }
        if(!op.isPresent){
            throw NotFoundException("No se encontro persona con id $idPersona")
        }
        return op.get()
    }

    @Throws(BusinessException::class)
    override fun save(persona: Persona): Persona {
        try {
            return personaRepository!!.save(persona)
        }catch(e:Exception){
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun remove(idPersona: Long) {
        val op:Optional<Persona>
        try{
            op=personaRepository!!.findById(idPersona)
        }catch(e:Exception){
            throw BusinessException(e.message)
        }
        if(!op.isPresent){
            throw NotFoundException("No se encontro persona con id $idPersona")
        }else{
            try{
                personaRepository!!.deleteById(idPersona)
            }catch(e:Exception){
                throw BusinessException(e.message)
            }
        }
    }
}