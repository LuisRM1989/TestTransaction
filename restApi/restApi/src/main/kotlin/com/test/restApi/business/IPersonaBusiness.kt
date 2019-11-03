package com.test.restApi.business

import com.test.restApi.model.Persona

interface IPersonaBusiness {
    fun list():List<Persona>
    fun load(idPersona:Long):Persona
    fun save(persona:Persona):Persona
    fun remove(idPersona:Long)
}